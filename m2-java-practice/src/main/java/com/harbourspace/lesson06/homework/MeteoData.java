package com.harbourspace.lesson06.homework;


import java.time.ZonedDateTime;

public class MeteoData implements Comparable<MeteoData> {
    private ZonedDateTime time;
    private Double temperature;
    private Double humidity;
    private Double precipitation;

    public MeteoData(ZonedDateTime time, Double temperature, Double humidity, Double precipitation) {
        this.time = time;
        this.temperature = temperature;
        this.humidity = humidity;
        this.precipitation = precipitation;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getPrecipitation() {
        return precipitation;
    }

    public MeteoData withNewTime(ZonedDateTime newTime) {
        return new MeteoData(newTime, this.temperature, this.humidity, this.precipitation);
    }

    @Override
    public int compareTo(MeteoData other) {
        return this.time.compareTo(other.time);
    }
}