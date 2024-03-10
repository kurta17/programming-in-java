package com.harbourspace.tracker.exercise.model;

import java.time.LocalDateTime;

public class ExerciseFixtures {

    public static NewExercise createNewExercise(Long userId, Long activityId, LocalDateTime startTime, int duration) {
        NewExercise newExercise = new NewExercise(userId, activityId, startTime, duration);
        return newExercise;
    }

    public static Exercise createExercise(Long id, Long userId, Long activityId, LocalDateTime startTime, int duration, double kcalBurned) {
        Exercise exercise = new Exercise(id, userId, activityId, startTime, duration, kcalBurned);
        return exercise;
    }
}