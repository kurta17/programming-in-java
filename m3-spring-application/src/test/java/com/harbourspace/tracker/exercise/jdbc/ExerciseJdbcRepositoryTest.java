package com.harbourspace.tracker.exercise.jdbc;

import com.harbourspace.tracker.authorization.AuthorizationService;
import com.harbourspace.tracker.exercise.model.Exercise;
import com.harbourspace.tracker.exercise.model.NewExercise;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDateTime;
import java.util.List;

@JdbcTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Import(ExerciseJdbcRepository.class)
public class ExerciseJdbcRepositoryTest {

    @Autowired
    private ExerciseJdbcRepository exerciseJdbcRepository;

    @MockBean
    private AuthorizationService authorizationService;

    @Test
    public void testGetExerciseById() {
        // Arrange
        NewExercise newExercise = new NewExercise(1L, 1L, LocalDateTime.now(), 60);
        Exercise actualExercise = exerciseJdbcRepository.addExercise(newExercise);

        // Act
        Exercise actualExerciseById = exerciseJdbcRepository.getExerciseById(actualExercise.getId());

        // Assert
        Assertions.assertNotNull(actualExerciseById);
        Assertions.assertEquals(actualExercise.getId(), actualExerciseById.getId());
        Assertions.assertEquals(actualExercise.getUserId(), actualExerciseById.getUserId());
        Assertions.assertEquals(actualExercise.getActivityId(), actualExerciseById.getActivityId());
    }

    @Test
    public void testGetAllExercisesByUserId() {
        // Arrange
        NewExercise newExercise = new NewExercise(1L, 1L, LocalDateTime.now(), 60);
        exerciseJdbcRepository.addExercise(newExercise);
        exerciseJdbcRepository.addExercise(newExercise);
        exerciseJdbcRepository.addExercise(newExercise);

        // Act
        List<Exercise> actualExercises = exerciseJdbcRepository.getAllExercisesByUserId(1L);

        // Assert
        Assertions.assertNotNull(actualExercises);
        Assertions.assertEquals(4, actualExercises.size());
    }

    @Test
    public void testGetExercisesByUserIdAndActivityId() {
        // Arrange
        NewExercise newExercise = new NewExercise(1L, 1L, LocalDateTime.now(), 60);
        exerciseJdbcRepository.addExercise(newExercise);
        exerciseJdbcRepository.addExercise(newExercise);
        exerciseJdbcRepository.addExercise(newExercise);

        // Act
        List<Exercise> actualExercises = exerciseJdbcRepository.getExercisesByUserIdAndActivityId(1L, 1L);

        // Assert
        Assertions.assertNotNull(actualExercises);
        Assertions.assertEquals(4, actualExercises.size());
    }

    @Test
    public void testGetExercisesByUserIdAndDuration() {
        // Arrange
        NewExercise newExercise = new NewExercise(1L, 1L, LocalDateTime.now(), 60);
        exerciseJdbcRepository.addExercise(newExercise);
        exerciseJdbcRepository.addExercise(newExercise);
        exerciseJdbcRepository.addExercise(newExercise);

        // Act
        List<Exercise> actualExercises = exerciseJdbcRepository.getExercisesByUserIdAndDuration(1L, 60);

        // Assert
        Assertions.assertNotNull(actualExercises);
        Assertions.assertEquals(4, actualExercises.size());
    }

}