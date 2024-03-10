package com.harbourspace.tracker.exercise.jdbc;

import com.harbourspace.tracker.exercise.model.Exercise;
import com.harbourspace.tracker.exercise.model.NewExercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseJdbcService {

    private final ExerciseJdbcRepository exerciseJdbcRepository;

    @Autowired
    public ExerciseJdbcService(ExerciseJdbcRepository exerciseJdbcRepository) {
        this.exerciseJdbcRepository = exerciseJdbcRepository;
    }

    public Exercise addExercise(NewExercise newExercise) {
        return exerciseJdbcRepository.addExercise(newExercise);
    }

    public Exercise getExerciseById(Long exerciseId) {
        return exerciseJdbcRepository.getExerciseById(exerciseId);
    }

    public List<Exercise> getAllExercisesByUserId(Long userId) {
        return exerciseJdbcRepository.getAllExercisesByUserId(userId);
    }

    public List<Exercise> getExercisesByUserIdAndActivityId(Long userId, Long activityId) {
        return exerciseJdbcRepository.getExercisesByUserIdAndActivityId(userId, activityId);
    }

    public List<Exercise> getExercisesByUserIdAndDate(Long userId, String date) {
        return exerciseJdbcRepository.getExercisesByUserIdAndDate(userId, date);
    }

    public List<Exercise> getExercisesByUserIdAndDuration(Long userId, int duration) {
        return exerciseJdbcRepository.getExercisesByUserIdAndDuration(userId, duration);
    }

    public Exercise updateExercise(Long exerciseId, NewExercise newExercise) {
        return exerciseJdbcRepository.updateExercise(exerciseId, newExercise);
    }

    public void deleteExercise(Long exerciseId) {
        exerciseJdbcRepository.deleteExercise(exerciseId);
    }
}
