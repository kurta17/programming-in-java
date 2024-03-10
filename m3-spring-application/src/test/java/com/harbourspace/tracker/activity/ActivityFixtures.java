package com.harbourspace.tracker.activity;

import com.harbourspace.tracker.activity.model.Activity;
import com.harbourspace.tracker.activity.model.ActivityType;
import com.harbourspace.tracker.activity.model.NewActivity;

import java.util.List;

public class ActivityFixtures {

    public static final Activity activity1 = new Activity(1L, 0L, ActivityType.SYSTEM, "Walking", 5.0);
    public static final Activity activity2 = new Activity(2L, 0L, ActivityType.SYSTEM, "Running", 10.0);
    public static final Activity activity3 = new Activity(3L, 0L, ActivityType.SYSTEM, "Cycling", 8.0);
    public static final Activity activity4 = new Activity(4L, 0L, ActivityType.SYSTEM, "Swimming", 7.0);
    //insert into activity (user_id, name, type, kcal_per_minute) values (0, 'Weight Training', 'SYSTEM', 3.0);
    public static final Activity activity5 = new Activity(5L, 0L, ActivityType.SYSTEM, "Weight Training", 3.0);
    public static final List<Activity> activities = List.of(activity1, activity2, activity3, activity4);
    public static final NewActivity newActivity = new NewActivity(ActivityType.SYSTEM, "Swimming", 12.0);

}
