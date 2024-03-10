package com.harbourspace.tracker.exercise.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.harbourspace.tracker.exercise.jdbc.ExerciseJdbcRepository;
import com.harbourspace.tracker.exercise.model.Exercise;
import com.harbourspace.tracker.exercise.model.NewExercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class ExerciseTests {

    private ExerciseJdbcRepository exerciseRepository;

    @BeforeEach
    void setUp() {
        exerciseRepository = mock(ExerciseJdbcRepository.class);
    }

    @Test
    void testAddExercise() {
        NewExercise newExercise = new NewExercise(1L, 1L, LocalDateTime.now(), 60);
        Exercise expectedExercise = new Exercise(1L, 1L, 1L, LocalDateTime.now(), 60, 100); // Example values for kcalBurned

        when(exerciseRepository.addExercise(newExercise)).thenReturn(expectedExercise);

        Exercise actualExercise = exerciseRepository.addExercise(newExercise);

        assertNotNull(actualExercise);
        assertEquals(expectedExercise.getId(), actualExercise.getId());
        assertEquals(expectedExercise.getUserId(), actualExercise.getUserId());
        assertEquals(expectedExercise.getActivityId(), actualExercise.getActivityId());
        assertEquals(expectedExercise.getStartTime(), actualExercise.getStartTime());
        assertEquals(expectedExercise.getDuration(), actualExercise.getDuration());
        assertEquals(expectedExercise.getKcalBurned(), actualExercise.getKcalBurned());
    }

    @Test
    void testUpdateExercise() {
        Long exerciseId = 1L;
        NewExercise updatedExercise = new NewExercise(1L, 1L, LocalDateTime.now(), 60);
        Exercise expectedExercise = new Exercise(1L, 1L, 1L, LocalDateTime.now(), 60, 100); // Example values for kcalBurned

        when(exerciseRepository.updateExercise(exerciseId, updatedExercise)).thenReturn(expectedExercise);

        Exercise actualExercise = exerciseRepository.updateExercise(exerciseId, updatedExercise);

        assertNotNull(actualExercise);
        assertEquals(expectedExercise.getId(), actualExercise.getId());
        assertEquals(expectedExercise.getUserId(), actualExercise.getUserId());
        assertEquals(expectedExercise.getActivityId(), actualExercise.getActivityId());
        assertEquals(expectedExercise.getStartTime(), actualExercise.getStartTime());
        assertEquals(expectedExercise.getDuration(), actualExercise.getDuration());
        assertEquals(expectedExercise.getKcalBurned(), actualExercise.getKcalBurned());
    }

    @Test
    void testGetExerciseById() {
        Long exerciseId = 1L;
        Exercise expectedExercise = new Exercise(1L, 1L, 1L, LocalDateTime.now(), 60, 100); // Example values for kcalBurned

        when(exerciseRepository.getExerciseById(exerciseId)).thenReturn(expectedExercise);

        Exercise actualExercise = exerciseRepository.getExerciseById(exerciseId);

        assertNotNull(actualExercise);
        assertEquals(expectedExercise.getId(), actualExercise.getId());
        assertEquals(expectedExercise.getUserId(), actualExercise.getUserId());
        assertEquals(expectedExercise.getActivityId(), actualExercise.getActivityId());
    }
}
