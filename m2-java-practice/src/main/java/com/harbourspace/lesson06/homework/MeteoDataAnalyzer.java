package com.harbourspace.lesson06.homework;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class MeteoDataAnalyzer {

    public static List<MeteoData> calculateDailyStatistics(List<MeteoData> dataList, ZoneId zoneId) {
        // Convert all timestamps to the desired time zone
        List<MeteoData> convertedDataList = dataList.stream()
                .map(data -> data.withNewTime(data.getTime().withZoneSameInstant(zoneId)))
                .collect(Collectors.toList());

        // Group MeteoData by truncated date
        Map<ZonedDateTime, List<MeteoData>> groupedByDay = convertedDataList.stream()
                .collect(Collectors.groupingBy(data -> data.getTime().truncatedTo(ChronoUnit.DAYS)));

        // Calculate daily statistics
        List<MeteoData> dailyStatistics = new ArrayList<>();
        for (Map.Entry<ZonedDateTime, List<MeteoData>> entry : groupedByDay.entrySet()) {
            ZonedDateTime day = entry.getKey();
            List<MeteoData> dailyData = entry.getValue();

            // Calculate average temperature
            double avgTemperature = dailyData.stream()
                    .mapToDouble(MeteoData::getTemperature)
                    .average()
                    .orElse(Double.NaN);

            // Calculate average humidity
            double avgHumidity = dailyData.stream()
                    .mapToDouble(MeteoData::getHumidity)
                    .average()
                    .orElse(Double.NaN);

            // Calculate sum of precipitation
            double sumPrecipitation = dailyData.stream()
                    .mapToDouble(MeteoData::getPrecipitation)
                    .sum();

            // Create MeteoData object for daily statistics
            MeteoData dailyStat = new MeteoData(day, avgTemperature, avgHumidity, sumPrecipitation);
            dailyStatistics.add(dailyStat);
        }

        // Sort the result by date
        Collections.sort(dailyStatistics);

        return dailyStatistics;
    }

    public static void main(String[] args) {
        // Example usage
        List<MeteoData> sampleData = SampleMeteoData.DATA;
        ZoneId timeZone = ZoneId.of("Asia/Bangkok"); // Example time zone, you can change it
        List<MeteoData> dailyStatistics = calculateDailyStatistics(sampleData, timeZone);
        for (MeteoData data : dailyStatistics) {
            System.out.println(data.getTime() + ": Avg Temp=" + data.getTemperature() +
                    ", Avg Humidity=" + data.getHumidity() + ", Sum Precipitation=" + data.getPrecipitation());
        }
    }
}
