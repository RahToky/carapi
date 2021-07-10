DROP TABLE IF EXISTS User;
CREATE TABLE User
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    pseudo   VARCHAR(10)  NOT NULL,
    password VARCHAR(250) NOT NULL,
    photo    CLOB DEFAULT NULL,
    token    VARCHAR(500)
);

DROP TABLE IF EXISTS Car;
CREATE TABLE Car
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(30) NOT NULL,
    model VARCHAR(30) NOT NULL,
    photo CLOB DEFAULT NULL
);

DROP TABLE IF EXISTS Comment;
CREATE TABLE Comment
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    car_id  INT,
    user_id Int,
    text    TEXT NOT NULL
);

DROP TABLE IF EXISTS user_token;
CREATE TABLE user_token
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    token   TEXT NOT NULL
)