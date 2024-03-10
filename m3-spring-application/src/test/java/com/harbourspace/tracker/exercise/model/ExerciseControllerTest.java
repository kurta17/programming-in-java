package com.harbourspace.tracker.exercise.model;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.harbourspace.tracker.exercise.controller.ExerciseController;
import com.harbourspace.tracker.exercise.jdbc.ExerciseJdbcService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

public class ExerciseControllerTest {

    @Mock
    private ExerciseJdbcService exerciseService;

    @InjectMocks
    private ExerciseController exerciseController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(exerciseController).build();
    }

    @Test
    public void testGetExerciseById() throws Exception {
        Exercise exercise = new Exercise(1L, 1L, 1L, LocalDateTime.now(), 60, 0);
        when(exerciseService.getExerciseById(1L)).thenReturn(exercise);
        mockMvc.perform(get("/api/exercises/1"))
                .andExpect(status().isOk());
    }


    @Test
    public void testDeleteExercise() throws Exception {
        doNothing().when(exerciseService).deleteExercise(1L);
        mockMvc.perform(delete("/api/exercises/1"))
                .andExpect(status().isOk());
    }

    // Add more test cases for other endpoints in ExerciseController class

    @Test
    public void testAddExercise() throws Exception {
        NewExercise newExercise = new NewExercise(1L, 1L, LocalDateTime.now(), 60);
        Exercise exercise = new Exercise(1L, 1L, 1L, LocalDateTime.now(), 60, 0);
        when(exerciseService.addExercise(newExercise)).thenReturn(exercise);

        // Create a new ObjectMapper and register the JavaTimeModule
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        mockMvc.perform(post("/api/exercises")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(newExercise))) // Use the configured mapper here
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateExercise() throws Exception {
        NewExercise newExercise = new NewExercise(1L, 1L, LocalDateTime.now(), 60);
        Exercise exercise = new Exercise(1L, 1L, 1L, LocalDateTime.now(), 60, 0);
        when(exerciseService.updateExercise(1L, newExercise)).thenReturn(exercise);

        // Create a new ObjectMapper and register the JavaTimeModule
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        mockMvc.perform(put("/api/exercises/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(newExercise))) // Use the configured mapper here
                .andExpect(status().isOk());
    }

    @Test
    public void testGetExercisesByUserIdAndActivityId() throws Exception {
        Exercise exercise = new Exercise(1L, 1L, 1L, LocalDateTime.now(), 60, 0);
        when(exerciseService.getExercisesByUserIdAndActivityId(1L, 1L)).thenReturn(List.of(exercise));
        mockMvc.perform(get("/api/exercises/user/1/activity/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetExercisesByUserIdAndDate() throws Exception {
        Exercise exercise = new Exercise(1L, 1L, 1L, LocalDateTime.now(), 60, 0);
        when(exerciseService.getExercisesByUserIdAndDate(1L, "2021-01-01")).thenReturn(List.of(exercise));
        mockMvc.perform(get("/api/exercises/user/1/date/2021-01-01"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetExercisesByUserIdAndDuration() throws Exception {
        Exercise exercise = new Exercise(1L, 1L, 1L, LocalDateTime.now(), 60, 0);
        when(exerciseService.getExercisesByUserIdAndDuration(1L, 60)).thenReturn(List.of(exercise));
        mockMvc.perform(get("/api/exercises/user/1/duration/60"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllExercisesByUserId() throws Exception {
        Exercise exercise = new Exercise(1L, 1L, 1L, LocalDateTime.now(), 60, 0);
        when(exerciseService.getAllExercisesByUserId(1L)).thenReturn(List.of(exercise));
        mockMvc.perform(get("/api/exercises/user/1"))
                .andExpect(status().isOk());
    }



}
