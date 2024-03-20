CREATE TABLE chat (
    id int  NOT NULL,
    is_active bool  NOT NULL,
    created_time datetime  NOT NULL,
    updated_time datetime  NOT NULL,
    title varchar(50)  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT chat_pk PRIMARY KEY (id)
);

-- Table: chat_users
CREATE TABLE chat_users (
    chat_id int  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT chat_users_pk PRIMARY KEY (chat_id,user_id)
);


-- Table: message
CREATE TABLE message (
    id int  NOT NULL,
    is_active bool  NOT NULL,
    created_time datetime  NOT NULL,
    updated_time datetime  NOT NULL,
    message varchar(50)  NOT NULL,
    chat_id int  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT message_pk PRIMARY KEY (id)
);
