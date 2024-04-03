

INSERT IGNORE INTO users (is_active, first_name, last_name, email, password, last_activity, created, updated, roles)
VALUES
    (TRUE, 'Admin', 'Admin', 'admin@gmail.com', '$2a$10$G7/RXIL6FTjldvXU60lM9OkZNH/DeniXHbskTUyQ7lVpU/C..Aeb2',
     NOW(), NOW(), NOW(), 'ADMIN'),
    (TRUE, 'Alex', 'Klim', 'alex@gmail.com', '$2a$10$G7/RXIL6FTjldvXU60lM9OkZNH/DeniXHbskTUyQ7lVpU/C..Aeb2',
     NOW(), NOW(), NOW(), 'USER');



-- Inserting a fake user
INSERT IGNORE INTO users (created, updated, last_activity, is_active, first_name, last_name, about_me, born_year, email, password, roles, longitude, latitude, experience_years, city, experience_level)
VALUES (NOW(), NOW(), NOW(), TRUE, 'John', 'Doe', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 1990, 'john.doe@example.com', 'password123', 'USER', 0.0, 0.0, 5, 'WARSAW', 'SENIOR');

-- Getting the user ID
SET @user_id := LAST_INSERT_ID();

-- Inserting user statuses
INSERT IGNORE INTO user_statuses (user_id, user_status) VALUES (@user_id, 'IS_MENTOR');
INSERT IGNORE INTO user_statuses (user_id, user_status) VALUES (@user_id, 'IS_OPEN_FOR_EVENTS');

-- Inserting user programming languages
INSERT IGNORE INTO user_programming_langs (user_id, programming_lang) VALUES (@user_id, 'JAVA');
INSERT IGNORE INTO user_programming_langs (user_id, programming_lang) VALUES (@user_id, 'PYTHON');

-- Inserting user speaking languages
INSERT IGNORE INTO user_speaking_langs (user_id, speaking_lang) VALUES (@user_id, 'ENGLISH');
INSERT IGNORE INTO user_speaking_langs (user_id, speaking_lang) VALUES (@user_id, 'SPANISH');

-- Inserting user education
INSERT IGNORE INTO educations (is_current, start_date, finish_date, degree, specialization, university, user_id)
VALUES (FALSE, '2010-09-01', '2014-06-30', 'BACHELOR', 'COMPUTER_SCIENCE', 'PJATK', @user_id);
