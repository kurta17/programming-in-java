insert into users (id, name) values (0, 'SYSTEM');
insert into users (name) values ('John');
insert into users (name) values ('Jane');

insert into activity (user_id, name, type, kcal_per_minute) values (0, 'Walking', 'SYSTEM', 5.0);
insert into activity (user_id, name, type, kcal_per_minute) values (0, 'Running', 'SYSTEM', 10.0);
insert into activity (user_id, name, type, kcal_per_minute) values (0, 'Cycling', 'SYSTEM', 8.0);
insert into activity (user_id, name, type, kcal_per_minute) values (0, 'Swimming', 'SYSTEM', 7.0);
insert into activity (user_id, name, type, kcal_per_minute) values (0, 'Weight Training', 'SYSTEM', 3.0);

insert into exercise (user_id, activity_id, start_time, duration) values (1, 1, '2022-01-01 10:00:00', 60);
insert into exercises (user_id, activity_id, start_time, duration, kcal_burned) values (1, 1, '2022-01-01 10:00:00', 60, 300.0);

-- Insert more users
insert into users (name) values ('Alice');
insert into users (name) values ('Bob');
insert into users (name) values ('Charlie');

-- Insert more activities
insert into activity (user_id, name, type, kcal_per_minute) values (0, 'Yoga', 'SYSTEM', 3.0);
insert into activity (user_id, name, type, kcal_per_minute) values (0, 'Pilates', 'SYSTEM', 4.0);
insert into activity (user_id, name, type, kcal_per_minute) values (0, 'Boxing', 'SYSTEM', 7.0);

-- Insert more exercises for the new users and activities
insert into exercise (user_id, activity_id, start_time, duration) values (2, 2, '2022-01-02 10:00:00', 60);
insert into exercise (user_id, activity_id, start_time, duration) values (3, 3, '2022-01-03 10:00:00', 60);
insert into exercise (user_id, activity_id, start_time, duration) values (4, 4, '2022-01-04 10:00:00', 60);

insert into exercises (user_id, activity_id, start_time, duration, kcal_burned) values (2, 2, '2022-01-02 10:00:00', 60, 300.0);
insert into exercises (user_id, activity_id, start_time, duration, kcal_burned) values (3, 3, '2022-01-03 10:00:00', 60, 300.0);
insert into exercises (user_id, activity_id, start_time, duration, kcal_burned) values (4, 4, '2022-01-04 10:00:00', 60, 300.0);