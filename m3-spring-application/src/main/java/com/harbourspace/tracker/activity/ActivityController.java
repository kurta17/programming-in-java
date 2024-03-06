package com.harbourspace.tracker.activity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private List<Activity> activities = List.of(
            new Activity(1L, 0L, ActivityType.SYSTEM, "Running", 10.0),
            new Activity(2L, 0L, ActivityType.SYSTEM, "Swimming", 8.0),
            new Activity(3L, 0L, ActivityType.SYSTEM, "Cycling", 12.0),
            new Activity(4L, 0L, ActivityType.SYSTEM, "Walking", 5.0)
    );

    // Method to get all activity types in the context of a user
    @GetMapping
    public List<Activity> getActivities(@RequestParam(value = "type", required = false) ActivityType type) {
        if (type == null) {
            return activities;
        } else {
            return activities.stream()
                    .filter(activity -> activity.type() == type)
                    .collect(Collectors.toList());
        }
    }

    // Method to get an activity type by its unique identifier
    @GetMapping("{id}")
    public Activity getActivityById(@PathVariable Long id) {
        return activities.stream()
                .filter(activity -> activity.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Method to add a new USER activity type
    @PostMapping()
    public Activity postActivity(@RequestBody NewActivity newActivity) {
        if (newActivity.name() == null || newActivity.kcalPerMinute() == null || newActivity.type() == null) {
            throw new IllegalArgumentException("Invalid activity");
        }

        Activity activity = new Activity(
                (long) (activities.size() + 1),
                0L,
                newActivity.type(),
                newActivity.name(),
                newActivity.kcalPerMinute());
        activities.add(activity);
        return activity;
    }

    // Method to update an existing USER activity type
    @PutMapping("{id}")
    public Activity updateActivity(@PathVariable Long id, @RequestBody NewActivity newActivity) {
        // Make a copy of the id variable
        Long activityId = id;
        var ref = new Object() {
            Activity existingActivity = activities.stream()
                    .filter(activity -> activity.id().equals(activityId))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
        };

        // Check if the activity is a USER type and belongs to the current user
        if (ref.existingActivity.type() == ActivityType.USER && ref.existingActivity.userId().equals(0L)) {
            // Update the activity details
            ref.existingActivity = new Activity(
                    ref.existingActivity.id(),
                    ref.existingActivity.userId(),
                    newActivity.type(),
                    newActivity.name(),
                    newActivity.kcalPerMinute()
            );
            activities.replaceAll(activity -> activity.id().equals(activityId) ? ref.existingActivity : activity);
            return ref.existingActivity;
        } else {
            throw new IllegalArgumentException("Cannot update SYSTEM activity or activity not owned by current user");
        }
    }


    // Method to delete an existing USER activity type
    @DeleteMapping("{id}")
    public void deleteActivity(@PathVariable Long id) {
        Activity existingActivity = activities.stream()
                .filter(activity -> activity.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Activity not found"));

        // Check if the activity is a USER type and belongs to the current user
        if (existingActivity.type() == ActivityType.USER && existingActivity.userId().equals(0L)) {
            // Check if the activity is not used in any user exercise
            if (isActivityUsed(id)) {
                throw new IllegalArgumentException("Cannot delete activity as it is used in user exercises");
            }
            // Remove the activity
            activities.removeIf(activity -> activity.id().equals(id));
        } else {
            throw new IllegalArgumentException("Cannot delete SYSTEM activity or activity not owned by current user");
        }
    }

    // Helper method to check if an activity is used in any user exercise
    private boolean isActivityUsed(Long id) {

        return false;
    }
}

