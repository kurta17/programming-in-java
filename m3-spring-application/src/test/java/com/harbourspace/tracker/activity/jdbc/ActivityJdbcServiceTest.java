package com.harbourspace.tracker.activity.jdbc;

import com.harbourspace.tracker.activity.model.Activity;
import com.harbourspace.tracker.activity.model.ActivityType;
import com.harbourspace.tracker.activity.model.NewActivity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class ActivityJdbcServiceTest {

    @Test
    @DisplayName("should return all activities")
    void testGetAllActivities() {
        com.harbourspace.tracker.activity.jdbc.ActivityJdbcRepository activityRepository = Mockito.mock(com.harbourspace.tracker.activity.jdbc.ActivityJdbcRepository.class);
        com.harbourspace.tracker.activity.jdbc.ActivityJdbcService activityService = new com.harbourspace.tracker.activity.jdbc.ActivityJdbcService(activityRepository);

        List<Activity> expected = List.of(
                new Activity(1L, 1L, ActivityType.USER, "Running", 10.0),
                new Activity(2L, 1L, ActivityType.USER, "Cycling", 8.0)
        );

        Mockito.when(activityRepository.getAllActivities()).thenReturn(expected);

        List<Activity> result = activityService.getAllActivities();

        Assertions.assertEquals(expected, result);
    }

    // Add more tests for other methods as needed
    @Test
    @DisplayName("should return activity by id")
    void testGetActivityById() {
        com.harbourspace.tracker.activity.jdbc.ActivityJdbcRepository activityRepository = Mockito.mock(com.harbourspace.tracker.activity.jdbc.ActivityJdbcRepository.class);
        com.harbourspace.tracker.activity.jdbc.ActivityJdbcService activityService = new com.harbourspace.tracker.activity.jdbc.ActivityJdbcService(activityRepository);

        Activity expected = new Activity(1L, 1L, ActivityType.USER, "Running", 10.0);

        Mockito.when(activityRepository.getActivityById(1L)).thenReturn(expected);

        Activity result = activityService.getActivityById(1L);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("should return activities by type")
    void testGetActivitiesByType() {
        com.harbourspace.tracker.activity.jdbc.ActivityJdbcRepository activityRepository = Mockito.mock(com.harbourspace.tracker.activity.jdbc.ActivityJdbcRepository.class);
        com.harbourspace.tracker.activity.jdbc.ActivityJdbcService activityService = new com.harbourspace.tracker.activity.jdbc.ActivityJdbcService(activityRepository);

        List<Activity> expected = List.of(
                new Activity(1L, 1L, ActivityType.USER, "Running", 10.0),
                new Activity(2L, 1L, ActivityType.USER, "Cycling", 8.0)
        );

        Mockito.when(activityRepository.getActivitiesByType(ActivityType.USER)).thenReturn(expected);

        List<Activity> result = activityService.getActivitiesByType(ActivityType.USER);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("should update activity")
    void testUpdateActivity() {
        com.harbourspace.tracker.activity.jdbc.ActivityJdbcRepository activityRepository = Mockito.mock(com.harbourspace.tracker.activity.jdbc.ActivityJdbcRepository.class);
        com.harbourspace.tracker.activity.jdbc.ActivityJdbcService activityService = new com.harbourspace.tracker.activity.jdbc.ActivityJdbcService(activityRepository);

        Activity expected = new Activity(1L, 1L, ActivityType.USER, "Running", 10.0);

        Mockito.when(activityRepository.getActivityById(1L)).thenReturn(expected);

        activityService.updateActivity(1L, new NewActivity(ActivityType.USER, "Running", 10.0));

        Activity result = activityService.getActivityById(1L);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("should add activity")
    void testAddActivity() {
        com.harbourspace.tracker.activity.jdbc.ActivityJdbcRepository activityRepository = Mockito.mock(com.harbourspace.tracker.activity.jdbc.ActivityJdbcRepository.class);
        com.harbourspace.tracker.activity.jdbc.ActivityJdbcService activityService = new com.harbourspace.tracker.activity.jdbc.ActivityJdbcService(activityRepository);

        NewActivity newActivity = new NewActivity(ActivityType.USER, "Running", 10.0);

        activityService.addActivity(newActivity);

        Mockito.verify(activityRepository).addActivity(newActivity);
    }

    @Test
    @DisplayName("should delete activity")
    void testDeleteActivity() {
        com.harbourspace.tracker.activity.jdbc.ActivityJdbcRepository activityRepository = Mockito.mock(com.harbourspace.tracker.activity.jdbc.ActivityJdbcRepository.class);
        com.harbourspace.tracker.activity.jdbc.ActivityJdbcService activityService = new com.harbourspace.tracker.activity.jdbc.ActivityJdbcService(activityRepository);

        activityService.deleteActivity(1L);

        Mockito.verify(activityRepository).deleteActivity(1L);
    }

}
