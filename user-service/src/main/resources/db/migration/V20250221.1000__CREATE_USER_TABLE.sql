CREATE TABLE user_db.user_record
(
    USER_ID      uuid DEFAULT gen_random_uuid(),
    NAME         VARCHAR(255) NOT NULL,
    AGE          INTEGER      NOT NULL,
    GENDER       VARCHAR(1) CHECK ( GENDER IN ('M', 'F') ),
    CREATED_TIME TIMESTAMP    NOT NULL,
    UPDATED_TIME TIMESTAMP    NOT NULL,
    CONSTRAINT USER_ID_PK PRIMARY KEY (USER_ID)
);