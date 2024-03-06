package com.harbourspace.tracker.exercise;

import java.time.LocalDateTime;

public class NewExercise {
    private Long userId;
    private Long activityId;
    private LocalDateTime startTime;
    private Long duration; // in seconds

    // Constructors, getters, setters
    public NewExercise(Long userId, Long activityId, LocalDateTime startTime, Long duration) {
        this.userId = userId;
        this.activityId = activityId;
        this.startTime = startTime;
        this.duration = duration;
    }

    public Long getUserId() {
        return userId;
    }

}
