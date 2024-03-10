CREATE TABLE IF NOT EXISTS users
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS activity
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    type TEXT NOT NULL,
    name TEXT NOT NULL,
    kcal_per_minute DECIMAL NOT NULL,
    UNIQUE (user_id, name)
);

CREATE TABLE IF NOT EXISTS exercise
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    activity_id BIGINT NOT NULL REFERENCES activity(id),
    start_time TIMESTAMP NOT NULL,
    duration BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS exercises
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    activity_id BIGINT NOT NULL,
    start_time TIMESTAMP NOT NULL,
    duration INT NOT NULL,
    kcal_burned DOUBLE,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (activity_id) REFERENCES activity(id)
);