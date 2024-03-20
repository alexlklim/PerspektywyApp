-- tables
-- Table: chat
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

-- Table: city
CREATE TABLE city (
    id int  NOT NULL,
    city varchar(50)  NOT NULL,
    CONSTRAINT city_pk PRIMARY KEY (id)
) COMMENT 'enum';

-- Table: comment
CREATE TABLE comment (
    id int  NOT NULL,
    is_active bool  NOT NULL,
    created_time datetime  NOT NULL,
    updated_time datetime  NOT NULL,
    comment varchar(50)  NOT NULL,
    user_id int  NOT NULL,
    comment_id int  NULL,
    CONSTRAINT comment_pk PRIMARY KEY (id)
);

-- Table: comment_event
CREATE TABLE comment_event (
    comment_id int  NOT NULL,
    event_id int  NOT NULL,
    CONSTRAINT comment_event_pk PRIMARY KEY (comment_id,event_id)
);

-- Table: comment_news
CREATE TABLE comment_news (
    comment_id int  NOT NULL,
    news_id int  NOT NULL,
    CONSTRAINT comment_news_pk PRIMARY KEY (comment_id,news_id)
);

-- Table: comments_project
CREATE TABLE comments_project (
    project_id int  NOT NULL,
    Comment_id int  NOT NULL,
    CONSTRAINT comments_project_pk PRIMARY KEY (project_id,Comment_id)
);

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

-- Table: event_statuses
CREATE TABLE event_statuses (
    event_id int  NOT NULL,
    statuses_id int  NOT NULL,
    CONSTRAINT event_statuses_pk PRIMARY KEY (event_id,statuses_id)
);

-- Table: event_type
CREATE TABLE event_type (
    id int  NOT NULL,
    event_type varchar(50)  NOT NULL,
    CONSTRAINT event_type_pk PRIMARY KEY (id)
) COMMENT 'enum';

-- Table: event_user
CREATE TABLE event_user (
    event_id int  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT event_user_pk PRIMARY KEY (event_id,user_id)
);

-- Table: experience_level
CREATE TABLE experience_level (
    id int  NOT NULL,
    level varchar(50)  NOT NULL,
    CONSTRAINT experience_level_pk PRIMARY KEY (id)
) COMMENT 'enum';

-- Table: image
CREATE TABLE image (
    id int  NOT NULL,
    created_time datetime  NOT NULL,
    updated_time datetime  NOT NULL,
    image int  NOT NULL,
    CONSTRAINT image_pk PRIMARY KEY (id)
);

-- Table: member_skills
CREATE TABLE member_skills (
    user_id int  NOT NULL,
    skill_id int  NOT NULL,
    CONSTRAINT member_skills_pk PRIMARY KEY (user_id,skill_id)
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

-- Table: programmin_languages
CREATE TABLE programmin_languages (
    id int  NOT NULL,
    programming_lang bool  NOT NULL,
    CONSTRAINT programmin_languages_pk PRIMARY KEY (id)
);

-- Table: projct_statuses
CREATE TABLE projct_statuses (
    project_id int  NOT NULL,
    project_statuses_id int  NOT NULL,
    CONSTRAINT projct_statuses_pk PRIMARY KEY (project_id,project_statuses_id)
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

-- Table: project_programming_lang
CREATE TABLE project_programming_lang (
    project_id int  NOT NULL,
    programmin_languages_id int  NOT NULL,
    CONSTRAINT project_programming_lang_pk PRIMARY KEY (project_id,programmin_languages_id)
);

-- Table: project_skills
CREATE TABLE project_skills (
    project_id int  NOT NULL,
    skill_id int  NOT NULL,
    CONSTRAINT project_skills_pk PRIMARY KEY (project_id,skill_id)
);

-- Table: project_users
CREATE TABLE project_users (
    project_id int  NOT NULL,
    speaking_languages_id int  NOT NULL,
    CONSTRAINT project_users_pk PRIMARY KEY (project_id,speaking_languages_id)
);

-- Table: reason
CREATE TABLE reason (
    id int  NOT NULL,
    reason varchar(50)  NOT NULL,
    CONSTRAINT reason_pk PRIMARY KEY (id)
) COMMENT 'enum';

-- Table: skill
CREATE TABLE skill (
    id int  NOT NULL,
    is_active bool  NOT NULL,
    created_time datetime  NOT NULL,
    updated_time datetime  NOT NULL,
    skill varchar(50)  NOT NULL,
    CONSTRAINT skill_pk PRIMARY KEY (id)
);

-- Table: speaking_languages
CREATE TABLE speaking_languages (
    id int  NOT NULL,
    speaking_lang bool  NOT NULL,
    CONSTRAINT speaking_languages_pk PRIMARY KEY (id)
);

-- Table: specializations
CREATE TABLE specializations (
    id int  NOT NULL,
    specialization varchar(50)  NOT NULL,
    CONSTRAINT specializations_pk PRIMARY KEY (id)
);

-- Table: statuses_id
CREATE TABLE statuses_id (
    id int  NOT NULL,
    status varchar(50)  NOT NULL,
    CONSTRAINT statuses_id_pk PRIMARY KEY (id)
) COMMENT 'it will be enum
IS_FINIHSED,
IS_PUBLIC,
IS_OPEN_FOR_PARTICIPANTS,
IS_ONLY_FOR_PROGRAMMERS
IS_LOCATION_IMPORTANT
IS_ONLAIN';

-- Table: token
CREATE TABLE token (
    id int  NOT NULL,
    token varchar(50)  NOT NULL,
    created datetime  NOT NULL,
    expired datetime  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT token_pk PRIMARY KEY (id)
);

-- Table: topic
CREATE TABLE topic (
    id int  NOT NULL,
    topic varchar(50)  NOT NULL,
    CONSTRAINT topic_pk PRIMARY KEY (id)
) COMMENT 'enum';

-- Table: universities
CREATE TABLE universities (
    id int  NOT NULL,
    university varchar(50)  NOT NULL,
    CONSTRAINT universities_pk PRIMARY KEY (id)
);

-- Table: user_education
CREATE TABLE user_education (
    user_id int  NOT NULL,
    educations_id int  NOT NULL,
    CONSTRAINT user_education_pk PRIMARY KEY (user_id,educations_id)
);

-- Table: user_programming_lang
CREATE TABLE user_programming_lang (
    user_id int  NOT NULL,
    programmin_languages_id int  NOT NULL,
    level varchar(20)  NOT NULL,
    CONSTRAINT user_programming_lang_pk PRIMARY KEY (user_id,programmin_languages_id)
);

-- Table: user_speaking_lang
CREATE TABLE user_speaking_lang (
    user_id int  NOT NULL,
    speaking_languages_id int  NOT NULL,
    level varchar(20)  NOT NULL,
    CONSTRAINT user_speaking_lang_pk PRIMARY KEY (user_id,speaking_languages_id)
);

-- Table: user_statuses
CREATE TABLE user_statuses (
    id int  NOT NULL,
    status varchar(50)  NOT NULL,
    CONSTRAINT user_statuses_pk PRIMARY KEY (id)
) COMMENT 'enum

IS_MENTOR
IS_MENTEE
IS_OPEN_FOR_EVENTS
IS_OPEN_FOR_PROJECTS
ISVISIBLE_ON_MAP';

-- Table: user_user_statuses
CREATE TABLE user_user_statuses (
    users_id int  NOT NULL,
    user_statuses_id int  NOT NULL,
    CONSTRAINT user_user_statuses_pk PRIMARY KEY (users_id,user_statuses_id)
) COMMENT 'enum

IS_MENTOR
IS_MENTEE
IS_OPEN_FOR_EVENTS
IS_OPEN_FOR_PROJECTS
ISVISIBLE_ON_MAP';

-- Table: users
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