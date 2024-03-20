
CREATE TABLE project_statuses (
    project_id int  NOT NULL,
    project_statuses_id int  NOT NULL,
    CONSTRAINT project_statuses_pk PRIMARY KEY (project_id,project_statuses_id)
);

-- Table: project
CREATE TABLE project (
    id int  NOT NULL,
    is_active bool  NOT NULL,
    created_time datetime  NOT NULL,
    updated_time datetime  NOT NULL,
    title varchar(50)  NOT NULL,
    description varchar(50)  NOT NULL,
    start_date date  NOT NULL,
    duration date  NOT NULL,
    user_id int  NOT NULL,
    main_image_id int  NOT NULL,
    back_image_id int  NOT NULL,
    topic_id int  NOT NULL,
    city_id int  NOT NULL,
    experience_level_id int  NOT NULL,
    CONSTRAINT project_pk PRIMARY KEY (id)
);




