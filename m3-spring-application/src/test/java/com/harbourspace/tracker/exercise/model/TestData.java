package com.harbourspace.tracker.exercise.model;
import com.harbourspace.tracker.activity.model.ActivityType;
import com.harbourspace.tracker.user.model.User;

import com.harbourspace.tracker.activity.model.Activity;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class TestData {

    public static List<User> getUsers() {
        return Arrays.asList(
                new User(0L, "SYSTEM"),
                new User(1L, "John"),
                new User(2L, "Jane"),
                new User(3L, "Alice"),
                new User(4L, "Bob"),
                new User(5L, "Charlie")
        );
    }

    public static List<Activity> getActivities() {
        return Arrays.asList(
                new Activity(0L, 0L, ActivityType.SYSTEM, "Walking", 5.0),
                new Activity(0L, 0L, ActivityType.SYSTEM, "Running", 10.0),
                new Activity(0L, 0L, ActivityType.SYSTEM, "Cycling", 8.0),
                new Activity(0L, 0L, ActivityType.SYSTEM, "Swimming", 7.0),
                new Activity(0L, 0L, ActivityType.SYSTEM, "Weight Training", 3.0),
                new Activity(0L, 0L, ActivityType.SYSTEM, "Yoga", 3.0),
                new Activity(0L, 0L, ActivityType.SYSTEM, "Pilates", 4.0),
                new Activity(0L, 0L, ActivityType.SYSTEM, "Boxing", 7.0)
        );
    }

    public static List<Exercise> getExercises() {
        return Arrays.asList(
                new Exercise(1L, 1L, 1L, LocalDateTime.parse("2022-01-01T10:00:00"), 60, 300.0),
                new Exercise(2L, 2L, 2L, LocalDateTime.parse("2022-01-02T10:00:00"), 60, 300.0),
                new Exercise(3L, 3L, 3L, LocalDateTime.parse("2022-01-03T10:00:00"), 60, 300.0),
                new Exercise(4L, 4L, 4L, LocalDateTime.parse("2022-01-04T10:00:00"), 60, 300.0)
        );
    }
}