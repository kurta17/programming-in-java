package com.harbourspace.tracker.activity.jdbc;

import com.harbourspace.tracker.activity.model.Activity;
import com.harbourspace.tracker.activity.model.ActivityType;
import com.harbourspace.tracker.activity.model.NewActivity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActivityJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public ActivityJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Activity> getAllActivities() {
        return jdbcTemplate.query(
                "SELECT * FROM activity",
                (rs, rowNum) -> new Activity(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        ActivityType.valueOf(rs.getString("type")),
                        rs.getString("name"),
                        rs.getDouble("kcal_per_minute")
                )
        );
    }


    public Activity getActivityById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM activity WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> new Activity(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        ActivityType.valueOf(rs.getString("type")),
                        rs.getString("name"),
                        rs.getDouble("kcal_per_minute")
                )
        );
    }

    public List<Activity> getActivitiesByType(ActivityType type) {
        return jdbcTemplate.query(
                "SELECT * FROM activity WHERE type = ?",
                new Object[]{type.toString()},
                (rs, rowNum) -> new Activity(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        ActivityType.valueOf(rs.getString("type")),
                        rs.getString("name"),
                        rs.getDouble("kcal_per_minute")
                )
        );
    }




    public Object addActivity(NewActivity newActivity) {
        jdbcTemplate.update(
                "INSERT INTO activity (type, name, kcal_per_minute) VALUES (?, ?, ?)",
                newActivity.getType().toString(),
                newActivity.getName(),
                newActivity.getKcalPerMinute()
        );
        return null;
    }

    // Implement update and delete methods similarly
    public void updateActivity(Long id, NewActivity  newActivity) {
        jdbcTemplate.update(
                "UPDATE activity SET type = ?, name = ?, kcal_per_minute = ? WHERE id = ?",
                newActivity.getType().toString(),
                newActivity.getName(),
                newActivity.getKcalPerMinute(),
                id
        );
    }
    public void deleteActivity(Long id) {
        jdbcTemplate.update(
                "DELETE FROM activity WHERE id = ?",
                id
        );
    }

}
