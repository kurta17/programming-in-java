package com.harbourspace.tracker.exercise.jdbc;

import com.harbourspace.tracker.exercise.model.Exercise;
import com.harbourspace.tracker.exercise.model.NewExercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ExerciseJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ExerciseJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Exercise addExercise(NewExercise newExercise) {
        String query = "INSERT INTO exercise (user_id, activity_id, start_time, duration) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(query, newExercise.getUserId(), newExercise.getActivityId(), newExercise.getStartTime(), newExercise.getDuration());
        Long generatedId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
        return getExerciseById(generatedId);
    }

    public Exercise getExerciseById(Long exerciseId) {
        String query = "SELECT * FROM exercise WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{exerciseId}, exerciseRowMapper);
    }

    public List<Exercise> getAllExercisesByUserId(Long userId) {
        String query = "SELECT * FROM exercise WHERE user_id = ?";
        return jdbcTemplate.query(query, new Object[]{userId}, exerciseRowMapper);
    }

    public List<Exercise> getExercisesByUserIdAndActivityId(Long userId, Long activityId) {
        String query = "SELECT * FROM exercise WHERE user_id = ? AND activity_id = ?";
        return jdbcTemplate.query(query, new Object[]{userId, activityId}, exerciseRowMapper);
    }

    public List<Exercise> getExercisesByUserIdAndDate(Long userId, String date) {
        String query = "SELECT * FROM exercise WHERE user_id = ? AND DATE(start_time) = ?";
        return jdbcTemplate.query(query, new Object[]{userId, date}, exerciseRowMapper);
    }

    public List<Exercise> getExercisesByUserIdAndDuration(Long userId, int duration) {
        String query = "SELECT * FROM exercise WHERE user_id = ? AND duration = ?";
        return jdbcTemplate.query(query, new Object[]{userId, duration}, exerciseRowMapper);
    }

    public Exercise updateExercise(Long exerciseId, NewExercise newExercise) {
        String query = "UPDATE exercise SET user_id = ?, activity_id = ?, start_time = ?, duration = ? WHERE id = ?";
        jdbcTemplate.update(query, newExercise.getUserId(), newExercise.getActivityId(), newExercise.getStartTime(), newExercise.getDuration(), exerciseId);
        return getExerciseById(exerciseId);
    }

    public void deleteExercise(Long exerciseId) {
        String query = "DELETE FROM exercise WHERE id = ?";
        jdbcTemplate.update(query, exerciseId);
    }

    private static final RowMapper<Exercise> exerciseRowMapper = new RowMapper<Exercise>() {
        @Override
        public Exercise mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Exercise(
                    rs.getLong("id"),
                    rs.getLong("user_id"),
                    rs.getLong("activity_id"),
                    rs.getTimestamp("start_time").toLocalDateTime(),
                    rs.getInt("duration"),
                    0 // kcalBurned is not set here
            );
        }
    };
}