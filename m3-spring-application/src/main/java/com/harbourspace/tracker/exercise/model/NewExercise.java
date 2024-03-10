package com.harbourspace.tracker.exercise.model;

import java.time.LocalDateTime;

public class NewExercise {
    private Long userId;
    private Long activityId;
    private LocalDateTime startTime;
    private int duration;

    public NewExercise(Long userId, Long activityId, LocalDateTime startTime, int duration) {
        this.userId = userId;
        this.activityId = activityId;
        this.startTime = startTime;
        this.duration = duration;
    }

    // getters and setters
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getActivityId() {
        return activityId;
    }
    public void setActivityId(Long activityId) {
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



}
