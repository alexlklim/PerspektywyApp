

INSERT IGNORE INTO users (is_active, first_name, last_name, email, password, last_activity, created, updated, roles)
VALUES
    (TRUE, 'Admin', 'Admin', 'admin@gmail.com', '$2a$10$G7/RXIL6FTjldvXU60lM9OkZNH/DeniXHbskTUyQ7lVpU/C..Aeb2',
     NOW(), NOW(), NOW(), 'ADMIN'),
    (TRUE, 'Alex', 'Klim', 'alex@gmail.com', '$2a$10$G7/RXIL6FTjldvXU60lM9OkZNH/DeniXHbskTUyQ7lVpU/C..Aeb2',
     NOW(), NOW(), NOW(), 'USER');
