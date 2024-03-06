package com.harbourspace.tracker.activity;

public record NewActivity(

        ActivityType type,
        String name,
        Double kcalPerMinute
) {
}
