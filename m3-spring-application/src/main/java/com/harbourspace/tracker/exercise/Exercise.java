package com.harbourspace.tracker.exercise;

import java.time.LocalDateTime;

public class Exercise {
    private Long id;
    private Long userId;
    private Long activityId;
    private LocalDateTime startTime;
    private Long duration; // in seconds
    private Double kcalBurned; // calculated number

    // Constructors, getters, setters
    public Exercise(Long id, Long userId, Long activityId, LocalDateTime startTime, Long duration, Double kcalBurned) {
        this.id = id;
        this.userId = userId;
        this.activityId = activityId;
        this.startTime = startTime;
        this.duration = duration;
        this.kcalBurned = kcalBurned;
    }

    public Long getId() {
        return id;
    }

}
