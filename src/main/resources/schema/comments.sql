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