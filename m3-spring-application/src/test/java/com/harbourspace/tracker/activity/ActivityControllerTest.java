package com.harbourspace.tracker.activity;

import com.harbourspace.tracker.activity.jdbc.ActivityJdbcService;
import com.harbourspace.tracker.activity.model.Activity;
import com.harbourspace.tracker.activity.model.ActivityType;
import com.harbourspace.tracker.authorization.AuthorizationService;
import com.harbourspace.tracker.config.SecurityConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(com.harbourspace.tracker.activity.ActivityController.class)
@Import(SecurityConfiguration.class)
public class ActivityControllerTest {


    @MockBean
    private ActivityJdbcService activityService;
    @MockBean
    private AuthorizationService authorizationService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        List<Activity> activities = List.of(
                new Activity(1L, 1L, ActivityType.USER, "Running", 10.0),
                new Activity(2L, 1L, ActivityType.USER, "Cycling", 8.0)
        );

        Mockito.when(activityService.getAllActivities()).thenReturn(activities);
        Mockito.when(activityService.getActivityById(1L)).thenReturn(activities.get(0));
    }

    @Test
    @DisplayName("GET /api/activities")
    void testGetAllActivities() throws Exception {
        var expected = "[{\"id\":1,\"userId\":1,\"type\":\"USER\",\"name\":\"Running\",\"kcalPerMinute\":10.0}," +
                "{\"id\":2,\"userId\":1,\"type\":\"USER\",\"name\":\"Cycling\",\"kcalPerMinute\":8.0}]";
        mockMvc.perform(get("/api/activities").header("Authorization", "Basic 0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expected));
    }

    @Test
    @DisplayName("GET /api/activities/1")
    void testGetActivityById() throws Exception {
        var expected = "{\"id\":1,\"userId\":1,\"type\":\"USER\",\"name\":\"Running\",\"kcalPerMinute\":10.0}";
        mockMvc.perform(get("/api/activities/1").header("Authorization", "Basic 0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expected));
    }


    @Test
    @DisplayName("POST /api/activities")
    void testAddActivity() throws Exception {
        var newActivity = "{\"userId\":1,\"type\":\"USER\",\"name\":\"Running\",\"kcalPerMinute\":10.0}";
        mockMvc.perform(get("/api/activities").header("Authorization", "Basic 0")
                .contentType("application/json")
                .content(newActivity))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("PUT /api/activities/1")
    void testUpdateActivity() throws Exception {
        var updatedActivity = "{\"userId\":1,\"type\":\"USER\",\"name\":\"Running\",\"kcalPerMinute\":10.0}";
        mockMvc.perform(get("/api/activities/1").header("Authorization", "Basic 0")
                .contentType("application/json")
                .content(updatedActivity))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("DELETE /api/activities/1")
    void testDeleteActivity() throws Exception {
        mockMvc.perform(get("/api/activities/1").header("Authorization", "Basic 0"))
                .andDo(print())
                .andExpect(status().isOk());
    }




}
