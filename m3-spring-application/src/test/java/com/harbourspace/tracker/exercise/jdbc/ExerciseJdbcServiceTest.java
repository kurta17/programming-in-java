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

    @Test
    public void testGetExerciseById() {
        // Mock dependencies
        Exercise mockExercise = new Exercise(1L, 1L, 1L, LocalDateTime.now(), 60, 0.0);
        when(exerciseRepository.getExerciseById(1L)).thenReturn(mockExercise);

        // Call service method
        Exercise actualExercise = exerciseService.getExerciseById(1L);

        // Verify repository method was called
        verify(exerciseRepository).getExerciseById(1L);


    }
    @Test
    public void testGetAllExercisesByUserId() {
        // Mock dependencies
        List<Exercise> mockExercises = List.of(
                new Exercise(1L, 1L, 1L, LocalDateTime.now(), 60, 0.0),
                new Exercise(2L, 1L, 1L, LocalDateTime.now(), 60, 0.0),
                new Exercise(3L, 1L, 1L, LocalDateTime.now(), 60, 0.0)
        );
        when(exerciseRepository.getAllExercisesByUserId(1L)).thenReturn(mockExercises);

        // Call service method
        List<Exercise> actualExercises = exerciseService.getAllExercisesByUserId(1L);

        // Verify repository method was called
        verify(exerciseRepository).getAllExercisesByUserId(1L);

        // Add more assertions if needed
    }

    @Test
    public void testGetExercisesByUserIdAndActivityId() {
        // Mock dependencies
        List<Exercise> mockExercises = List.of(
                new Exercise(1L, 1L, 1L, LocalDateTime.now(), 60, 0.0),
                new Exercise(2L, 1L, 1L, LocalDateTime.now(), 60, 0.0),
                new Exercise(3L, 1L, 1L, LocalDateTime.now(), 60, 0.0)
        );
        when(exerciseRepository.getExercisesByUserIdAndActivityId(1L, 1L)).thenReturn(mockExercises);

        // Call service method
        List<Exercise> actualExercises = exerciseService.getExercisesByUserIdAndActivityId(1L, 1L);

        // Verify repository method was called
        verify(exerciseRepository).getExercisesByUserIdAndActivityId(1L, 1L);

    }


}
