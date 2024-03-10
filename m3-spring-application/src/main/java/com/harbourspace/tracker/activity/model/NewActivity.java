package com.harbourspace.tracker.activity.model;

public class NewActivity {
    private ActivityType type;
    private String name;
    private Double kcalPerMinute;

    // Constructors, getters, setters
    public NewActivity(ActivityType type, String name, Double kcalPerMinute) {
        this.type = type;
        this.name = name;
        this.kcalPerMinute = kcalPerMinute;
    }
    //getters and setters
    public ActivityType getType() {
        return type;
    }
    public void setType(ActivityType type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getKcalPerMinute() {
        return kcalPerMinute;
    }
    public void setKcalPerMinute(Double kcalPerMinute) {
        this.kcalPerMinute = kcalPerMinute;
    }
}

