



ALTER TABLE images DROP CONSTRAINT image_created_by_user;

DROP TABLE IF EXISTS images;
DROP TABLE IF EXISTS user_statuses;
DROP TABLE IF EXISTS user_programming_langs;
DROP TABLE IF EXISTS user_speaking_langs;
DROP TABLE IF EXISTS educations;
DROP TABLE IF EXISTS token;
DROP TABLE IF EXISTS user_skills;
DROP TABLE IF EXISTS notifications;
DROP TABLE IF EXISTS skills;
DROP TABLE IF EXISTS news;
DROP TABLE IF EXISTS users;
