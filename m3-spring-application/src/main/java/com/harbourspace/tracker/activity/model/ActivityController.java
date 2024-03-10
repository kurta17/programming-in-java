package com.harbourspace.tracker.activity;

import com.harbourspace.tracker.activity.jdbc.ActivityJdbcService;
import com.harbourspace.tracker.activity.model.Activity;
import com.harbourspace.tracker.activity.model.ActivityType;
import com.harbourspace.tracker.activity.model.NewActivity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityJdbcService activityService;

    public ActivityController(ActivityJdbcService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<Activity> getAllActivities(@RequestParam(value = "type", required = false) String type) {
        if (type != null) {
            ActivityType activityType = ActivityType.valueOf(type.toUpperCase());
            return activityService.getActivitiesByType(activityType);
        } else {
            return activityService.getAllActivities();
        }
    }


    @GetMapping("/type/{type}")
    public List<Activity> getActivitiesByType(@PathVariable String type) {
        ActivityType activityType = ActivityType.valueOf(type.toUpperCase());
        return activityService.getActivitiesByType(activityType);
    }

    @GetMapping("/{id}")
    public Activity getActivityById(@PathVariable Long id) {
        return activityService.getActivityById(id);
    }

    @PostMapping()
    public void addActivity(@RequestBody NewActivity newActivity) {
        activityService.addActivity(newActivity);
    }

    @PutMapping("/{id}")
    public void updateActivity(@PathVariable Long id, @RequestBody NewActivity updatedActivity) {
        activityService.updateActivity(id, updatedActivity);
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Long id) {
        activityService.deleteActivity(id);
    }


}
