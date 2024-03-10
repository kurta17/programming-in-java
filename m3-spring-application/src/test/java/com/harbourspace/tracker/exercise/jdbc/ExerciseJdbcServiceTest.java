package com.harbourspace.tracker.exercise.jdbc;

import com.harbourspace.tracker.authorization.AuthorizationService;
import com.harbourspace.tracker.exercise.jdbc.ExerciseJdbcRepository;
import com.harbourspace.tracker.exercise.jdbc.ExerciseJdbcService;
import com.harbourspace.tracker.exercise.model.Exercise;
import com.harbourspace.tracker.exercise.model.NewExercise;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@JdbcTest
public class ExerciseJdbcServiceTest {

    @Mock
    private ExerciseJdbcRepository exerciseRepository;
    @MockBean
    private AuthorizationService authorizationService;

    @InjectMocks
    private ExerciseJdbcService exerciseService;

    @Test
    public void testAddExercise() {
        // Mock dependencies
        NewExercise newExercise = new NewExercise(1L, 1L, LocalDateTime.now(), 60);
        Exercise mockExercise = new Exercise(1L, 1L, 1L, LocalDateTime.now(), 60, 0.0);
        when(exerciseRepository.addExercise(any(NewExercise.class))).thenReturn(mockExercise);

        // Call service method
        Exercise addedExercise = exerciseService.addExercise(newExercise);

        // Verify repository method was called
        verify(exerciseRepository).addExercise(newExercise);

        // Add more assertions if needed
    }

    // Add more test methods for other service methods
}
