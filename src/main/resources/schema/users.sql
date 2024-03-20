

-- Table: educations
CREATE TABLE educations (
    id int  NOT NULL,
    is_current int  NOT NULL,
    start_date date  NOT NULL,
    end_date date  NOT NULL,
    degree int  NOT NULL,
    University_ID int  NOT NULL,
    Specialization_ID int  NOT NULL,
    CONSTRAINT educations_pk PRIMARY KEY (id)
);


-- Table: image
CREATE TABLE image (
    id int  NOT NULL,
    created_time datetime  NOT NULL,
    updated_time datetime  NOT NULL,
    image int  NOT NULL,
    CONSTRAINT image_pk PRIMARY KEY (id)
);


-- Table: news
CREATE TABLE news (
    id int  NOT NULL,
    is_active bool  NOT NULL,
    created_time datetime  NOT NULL,
    updated_time datetime  NOT NULL,
    title varchar(50)  NOT NULL,
    description varchar(50)  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT news_pk PRIMARY KEY (id)
);

-- Table: notification
CREATE TABLE notification (
    id int  NOT NULL,
    created_time datetime  NOT NULL,
    is_viewed int  NOT NULL,
    notification varchar(50)  NOT NULL,
    user_id int  NOT NULL,
    reason_id int  NOT NULL,
    CONSTRAINT notification_pk PRIMARY KEY (id)
);



-- Table: skill
CREATE TABLE skill (
    id int  NOT NULL,
    is_active bool  NOT NULL,
    created_time datetime  NOT NULL,
    updated_time datetime  NOT NULL,
    skill varchar(50)  NOT NULL,
    CONSTRAINT skill_pk PRIMARY KEY (id)
);


CREATE TABLE users (
    id int  NOT NULL,
    is_active bool  NOT NULL,
    updated_time datetime  NOT NULL,
    created_time datetime  NOT NULL,
    email varchar(50)  NOT NULL,
    password varchar(50)  NOT NULL,
    role varchar(20)  NOT NULL,
    first_name varchar(20)  NOT NULL,
    last_name varchar(20)  NOT NULL,
    about_me varchar(500)  NOT NULL,
    born_year int  NOT NULL,
    longitude double(10,9)  NOT NULL,
    latitude double(10,9)  NOT NULL,
    experience_years int  NOT NULL,
    city_id int  NOT NULL,
    experience_level_id int  NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (id)
);

-- Table: token
CREATE TABLE token (
    id int  NOT NULL,
    token varchar(50)  NOT NULL,
    created datetime  NOT NULL,
    expired datetime  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT token_pk PRIMARY KEY (id)
);
