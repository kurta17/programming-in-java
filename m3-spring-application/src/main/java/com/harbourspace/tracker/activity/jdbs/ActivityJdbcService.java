package com.harbourspace.tracker.activity.jdbc;

import com.harbourspace.tracker.activity.model.Activity;
import com.harbourspace.tracker.activity.model.ActivityType;
import com.harbourspace.tracker.activity.model.NewActivity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityJdbcService {

    private final com.harbourspace.tracker.activity.jdbc.ActivityJdbcRepository activityRepository;

    public ActivityJdbcService(com.harbourspace.tracker.activity.jdbc.ActivityJdbcRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> getAllActivities() {
        return activityRepository.getAllActivities();
    }


    public Activity getActivityById(Long id) {
        return activityRepository.getActivityById(id);
    }

    public List<Activity> getActivitiesByType(ActivityType type) {
        return activityRepository.getActivitiesByType(type);
    }


    public void addActivity(NewActivity newActivity) {
        activityRepository.addActivity(newActivity);
    }

    // Implement update and delete methods similarly
    public void updateActivity(Long id, NewActivity newActivity) {
        activityRepository.updateActivity(id, newActivity);
    }
    public void deleteActivity(Long id) {
        activityRepository.deleteActivity(id);
    }

}

