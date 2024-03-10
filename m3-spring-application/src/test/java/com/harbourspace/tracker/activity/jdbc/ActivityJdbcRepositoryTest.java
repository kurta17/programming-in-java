package com.harbourspace.tracker.activity.jdbc;

import com.harbourspace.tracker.activity.model.Activity;
import com.harbourspace.tracker.activity.model.ActivityType;
import com.harbourspace.tracker.activity.model.NewActivity;
import com.harbourspace.tracker.activity.ActivityFixtures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

@JdbcTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Import(com.harbourspace.tracker.activity.jdbc.ActivityJdbcRepository.class)
public class ActivityJdbcRepositoryTest {

    @Autowired
    private com.harbourspace.tracker.activity.jdbc.ActivityJdbcRepository activityRepository;

    @Autowired
    private com.harbourspace.tracker.activity.jdbc.ActivityJdbcRepository activityJdbcRepository;


    // Add more tests for other methods as needed
    @Test
    @DisplayName("should return activity by id")
    void testGetActivityById() {
        Activity expected = ActivityFixtures.activity1;

        Activity result = activityRepository.getActivityById(1L);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("should return activities by type")
    void testGetActivitiesByType() {
        List<Activity> expected = List.of(
                ActivityFixtures.activity1,
                ActivityFixtures.activity2,
                ActivityFixtures.activity3,
                ActivityFixtures.activity4,
                ActivityFixtures.activity5

        );

        List<Activity> result = activityRepository.getActivitiesByType(ActivityType.SYSTEM);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("should return all activities")
    void testGetAllActivities() {
        List<Activity> expected = List.of(
                ActivityFixtures.activity1,
                ActivityFixtures.activity2,
                ActivityFixtures.activity3,
                ActivityFixtures.activity4,
                ActivityFixtures.activity5
        );

        List<Activity> result = activityRepository.getAllActivities();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("should update activity")
    void testUpdateActivity() {
        Activity expected = new Activity(1L, 0L, ActivityType.SYSTEM, "Walking", 10.0);

        activityRepository.updateActivity(1L, new NewActivity(ActivityType.SYSTEM, "Walking", 10.0));

        Activity result = activityRepository.getActivityById(1L);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("should delete activity")
    void testDeleteActivity() {
        activityRepository.deleteActivity(1L);

        List<Activity> result = activityRepository.getAllActivities();

        Assertions.assertEquals(List.of(
                ActivityFixtures.activity2,
                ActivityFixtures.activity3,
                ActivityFixtures.activity4,
                ActivityFixtures.activity5
        ), result);
    }

}

