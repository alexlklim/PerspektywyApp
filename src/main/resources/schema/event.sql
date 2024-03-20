-- Table: event
CREATE TABLE event (
    id int  NOT NULL,
    is_active bool  NOT NULL,
    created_time datetime  NOT NULL,
    updated_time datetime  NOT NULL,
    title varchar(50)  NOT NULL,
    description varchar(50)  NOT NULL,
    start_date date  NOT NULL,
    duration int  NOT NULL,
    level varchar(50)  NOT NULL,
    event_type_id int  NOT NULL,
    user_id int  NOT NULL,
    city_id int  NOT NULL,
    experience_level_id int  NOT NULL,
    CONSTRAINT event_pk PRIMARY KEY (id)
);

