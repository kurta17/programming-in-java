package com.harbourspace.tracker.activity;

import java.sql.SQLException;

public record Activity(
        Long id,
        Long userId,
        ActivityType type,
        String name,
        Double kcalPerMinute

) {

}
