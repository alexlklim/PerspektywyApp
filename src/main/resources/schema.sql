CREATE TABLE IF NOT EXISTS images
(
    id         BIGINT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    created    DATETIME,
    updated    DATETIME,
    is_active  BOOLEAN NOT NULL,
    title      VARCHAR(255),
    type       VARCHAR(255),
    image_data LONGBLOB,
    user_id    BIGINT
);


CREATE TABLE IF NOT EXISTS users
(
    id               BIGINT                 NOT NULL AUTO_INCREMENT PRIMARY KEY,
    created          DATETIME,
    updated          DATETIME,
    last_activity    DATETIME               NOT NULL,
    is_active        BOOLEAN                NOT NULL,

    first_name       VARCHAR(255)           NOT NULL,
    last_name        VARCHAR(255)           NOT NULL,
    about_me         TEXT,
    born_year        INT,
    email            VARCHAR(255) UNIQUE    NOT NULL,
    password         VARCHAR(255)           NOT NULL,
    roles            ENUM ('ADMIN', 'USER') NOT NULL,

    longitude        DOUBLE,
    latitude         DOUBLE,
    experience_years INT,
    city             ENUM ('WARSAW', 'KRAKOW', 'LODZ', 'WROCLAW', 'POZNAN', 'GDANSK', 'SZCZECIN', 'BYDGOSZCZ', 'LUBLIN', 'KATOWICE'),
    experience_level ENUM ('JUNIOR', 'MID_LEVEL', 'SENIOR', 'LEAD', 'ARCHITECT', 'PRINCIPAL'),
    image_id         BIGINT
);


ALTER TABLE images
    ADD CONSTRAINT image_created_by_user FOREIGN KEY (user_id) REFERENCES users (id);


CREATE TABLE IF NOT EXISTS user_statuses
(
    user_id     BIGINT,
    user_status ENUM ('IS_MENTOR', 'IS_MENTEE', 'IS_OPEN_FOR_EVENTS', 'IS_OPEN_FOR_PROJECTS', 'IS_VISIBLE_ON_MAP'),
    FOREIGN KEY (user_id) REFERENCES users (id)
);



CREATE TABLE IF NOT EXISTS user_programming_langs
(
    user_id          BIGINT,
    programming_lang ENUM ('C_PLUS', 'JAVA', 'PYTHON', 'C_SHARP', 'JAVASCRIPT', 'RUBY', 'SWIFT', 'GO', 'PHP', 'TYPESCRIPT', 'KOTLIN', 'RUST', 'SCALA', 'PERL', 'HTML', 'CSS'),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS user_speaking_langs
(
    user_id       BIGINT,
    speaking_lang ENUM ('POLISH', 'ENGLISH', 'GERMAN', 'FRENCH', 'SPANISH', 'ITALIAN', 'RUSSIAN'),
    FOREIGN KEY (user_id) REFERENCES users (id)
);



CREATE TABLE IF NOT EXISTS educations
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    created        DATETIME,
    updated        DATETIME,
    is_active      BOOLEAN                                                                                                                                                                                                                                                                                                            NOT NULL,
    is_current     BOOLEAN                                                                                                                                                                                                                                                                                                            NOT NULL,
    start_date     DATE                                                                                                                                                                                                                                                                                                               NOT NULL,
    finish_date    DATE,
    degree         ENUM ('BACHELOR', 'MASTER', 'DOCTORATE', 'ASSOCIATE', 'DIPLOMA', 'CERTIFICATE')                                                                                                                                                                                                                                    NOT NULL,
    specialization ENUM ('COMPUTER_SCIENCE', 'SOFTWARE_ENGINEERING', 'INFORMATION_TECHNOLOGY', 'ELECTRICAL_ENGINEERING', 'MECHANICAL_ENGINEERING', 'CIVIL_ENGINEERING', 'BIOMEDICAL_ENGINEERING', 'CHEMICAL_ENGINEERING', 'AEROSPACE_ENGINEERING', 'INDUSTRIAL_ENGINEERING', 'TELECOMMUNICATIONS_ENGINEERING', 'SYSTEMS_ENGINEERING') NOT NULL,
    university     ENUM ('PJATK', 'AGH', 'UJ', 'PW', 'UWr', 'UW', 'UMCS', 'UEK', 'UG', 'PUT', 'KUL')                                                                                                                                                                                                                                  NOT NULL,
    user_id        BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id)
);



CREATE TABLE IF NOT EXISTS token
(
    id      BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    token   BINARY(16),
    created DATETIME,
    expired DATETIME,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id)
);



CREATE TABLE IF NOT EXISTS skills
(
    id        BIGINT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    created   DATETIME,
    updated   DATETIME,
    is_active BOOLEAN NOT NULL,
    skill     VARCHAR(255)
);


CREATE TABLE IF NOT EXISTS user_skills
(
    user_id  BIGINT NOT NULL,
    skill_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, skill_id),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (skill_id) REFERENCES skills (id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS notifications
(
    id         BIGINT                           NOT NULL AUTO_INCREMENT PRIMARY KEY,
    is_active  BOOLEAN                          NOT NULL,
    created    DATETIME,
    updated    DATETIME,
    is_viewed  BOOLEAN                          NOT NULL,
    reason     ENUM ('ACCOUNT_CREATED', 'PASSWORD_WAS_CHANGED',
        'USER_WAS_DISABLED', 'YOU_WERE_DISABLED',
        'USER_WAS_ENABLED', 'YOU_WERE_ENABLED') NOT NULL,
    message    VARCHAR(255),
    to_user_id BIGINT,
    created_by BIGINT,
    FOREIGN KEY (to_user_id) REFERENCES users (id),
    FOREIGN KEY (created_by) REFERENCES users (id)
);



CREATE TABLE IF NOT EXISTS news
(
    id        BIGINT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    is_active BOOLEAN NOT NULL,
    created   DATETIME,
    updated   DATETIME,
    user_id   BIGINT,
    image_id  BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id)
);