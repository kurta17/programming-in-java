package com.harbourspace.tracker.exercise.model;

import java.time.LocalDateTime;

public class Exercise {
    private Long id;
    private Long userId;
    private Long activityId;
    private LocalDateTime startTime;
    private int duration;
    private double kcalBurned;

    public Exercise(Long id, Long userId, Long activityId, LocalDateTime startTime, int duration, double kcalBurned) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getKcalBurned() {
        return kcalBurned;
    }

    public void setKcalBurned(double kcalBurned) {
        this.kcalBurned = kcalBurned;
    }
}
