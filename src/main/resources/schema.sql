CREATE TABLE IF NOT EXISTS users
(
    id            BIGINT                NOT NULL AUTO_INCREMENT PRIMARY KEY,
    created       DATETIME,
    updated       DATETIME,
    is_active     BOOLEAN               NOT NULL,
    firstname     VARCHAR(255)          NOT NULL,
    lastname      VARCHAR(255)          NOT NULL,
    email         VARCHAR(255) UNIQUE   NOT NULL,
    password      VARCHAR(255)          NOT NULL,
    last_activity DATETIME              NOT NULL,
    roles         ENUM ('ADMIN', 'USER') NOT NULL
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


CREATE TABLE IF NOT EXISTS notifications (
    id          BIGINT        NOT NULL AUTO_INCREMENT PRIMARY KEY,
    is_active   BOOLEAN       NOT NULL,
    created     DATETIME,
    updated     DATETIME,
    is_viewed     BOOLEAN       NOT NULL,
    reason      ENUM ('ACCOUNT_CREATED', 'PASSWORD_WAS_CHANGED',
        'USER_WAS_DISABLED', 'YOU_WERE_DISABLED',
        'USER_WAS_ENABLED', 'YOU_WERE_ENABLED') NOT NULL,
    message     VARCHAR(255),
    to_user_id  BIGINT,
    created_by  BIGINT,
    FOREIGN KEY (to_user_id) REFERENCES users (id),
    FOREIGN KEY (created_by) REFERENCES users (id)
);
