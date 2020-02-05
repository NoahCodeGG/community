create table QUESTION
(
    ID            BIGINT auto_increment,
    TITLE         VARCHAR(50),
    DESCRIPTION   VARCHAR(500),
    GMT_CREATE    BIGINT,
    GMT_MODIFIED  BIGINT,
    CREATOR       BIGINT,
    COMMENT_COUNT INT default 0,
    VIEW_COUNT    INT default 0,
    LIKE_COUNT    INT default 0,
    TAG           VARCHAR(256),
    constraint QUESTION_PK
        primary key (ID)
);