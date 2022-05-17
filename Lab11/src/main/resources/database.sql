DROP TABLE friends;
DROP TABLE users;

CREATE TABLE users(
    id_user NUMBER(6) PRIMARY KEY ,
    name VARCHAR2(20)
);

CREATE TABLE friends(
    id_user NUMBER(6),
    id_friend NUMBER(6)
);
