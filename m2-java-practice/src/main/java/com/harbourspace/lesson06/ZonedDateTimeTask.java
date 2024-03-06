package com.harbourspace.lesson06;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeTask {

    public static void main(String[] args) {
        // Get current date and time in local time zone
        ZonedDateTime localDateTime = ZonedDateTime.now();

        // Print local zone and offset
        System.out.println("Local Zone: " + localDateTime.getZone());
        System.out.println("Local Zone Offset: " + localDateTime.getOffset());

        // Choose a different time zone
        ZoneId otherZoneId = ZoneId.of("Asia/Tokyo");
        ZonedDateTime otherZoneDateTime = localDateTime.withZoneSameInstant(otherZoneId);

        // Print other zone and offset
        System.out.println("Other Zone: " + otherZoneDateTime.getZone());
        System.out.println("Other Zone Offset: " + otherZoneDateTime.getOffset());

        // Calculate time difference
        long hoursDifference = otherZoneDateTime.getHour() - localDateTime.getHour();
        long minutesDifference = otherZoneDateTime.getMinute() - localDateTime.getMinute();

        System.out.println("Time difference: " + hoursDifference + " hours, " + minutesDifference + " minutes");
    }
}

