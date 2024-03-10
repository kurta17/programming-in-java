package com.harbourspace.tracker.exercise.jdbc;

import com.harbourspace.tracker.authorization.AuthorizationService;
import com.harbourspace.tracker.exercise.model.Exercise;
import com.harbourspace.tracker.exercise.model.NewExercise;
import com.harbourspace.tracker.exercise.jdbc.ExerciseJdbcRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDateTime;

@JdbcTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Import(ExerciseJdbcRepository.class)
public class ExerciseJdbcRepositoryTest {

    @Autowired
    private ExerciseJdbcRepository exerciseJdbcRepository;
    @MockBean
    private AuthorizationService authorizationService;




}