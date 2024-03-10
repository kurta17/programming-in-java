package com.harbourspace.tracker.exercise.controller;

import com.harbourspace.tracker.exercise.model.Exercise;
import com.harbourspace.tracker.exercise.jdbc.ExerciseJdbcService;
import com.harbourspace.tracker.exercise.model.NewExercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    private final ExerciseJdbcService exerciseService;

    @Autowired
    public ExerciseController(ExerciseJdbcService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping
    public Exercise addExercise(@RequestBody NewExercise newExercise) {
        return exerciseService.addExercise(newExercise);
    }

    @GetMapping("/{exerciseId}")
    public Exercise getExerciseById(@PathVariable Long exerciseId) {
        return exerciseService.getExerciseById(exerciseId);
    }

    @GetMapping("/user/{userId}")
    public List<Exercise> getAllExercisesByUserId(@PathVariable Long userId) {
        return exerciseService.getAllExercisesByUserId(userId);
    }

    @GetMapping("/user/{userId}/activity/{activityId}")
    public List<Exercise> getExercisesByUserIdAndActivityId(@PathVariable Long userId, @PathVariable Long activityId) {
        return exerciseService.getExercisesByUserIdAndActivityId(userId, activityId);
    }

    @GetMapping("/user/{userId}/date/{date}")
    public List<Exercise> getExercisesByUserIdAndDate(@PathVariable Long userId, @PathVariable String date) {
        return exerciseService.getExercisesByUserIdAndDate(userId, date);
    }

    @GetMapping("/user/{userId}/duration/{duration}")
    public List<Exercise> getExercisesByUserIdAndDuration(@PathVariable Long userId, @PathVariable int duration) {
        return exerciseService.getExercisesByUserIdAndDuration(userId, duration);
    }

    @PutMapping("/{exerciseId}")
    public Exercise updateExercise(@PathVariable Long exerciseId, @RequestBody NewExercise newExercise) {
        return exerciseService.updateExercise(exerciseId, newExercise);
    }

    @DeleteMapping("/{exerciseId}")
    public void deleteExercise(@PathVariable Long exerciseId) {
        exerciseService.deleteExercise(exerciseId);
    }
}
