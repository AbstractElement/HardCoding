DROP DATABASE IF EXISTS db_starexpress;

CREATE DATABASE IF NOT EXISTS db_starexpress;

USE db_starexpress;

CREATE TABLE db_starexpress.user
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  email VARCHAR(255) UNIQUE NOT NULL,
  pass VARCHAR(255) NOT NULL
);

CREATE TABLE db_starexpress.profile
(
  idProfile INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  idUser INT REFERENCES user(id) ON UPDATE CASCADE ON DELETE CASCADE,
  firstName VARCHAR(255),
  lastName VARCHAR(255),
  currentCity VARCHAR(255),
  phoneNumber VARCHAR(255),
  age INT DEFAULT 0,
  sex VARCHAR(10),
  avatar VARCHAR(255)
);

CREATE TABLE db_starexpress.posts
(
  idPost INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  idProfile INT REFERENCES profile(idProfile) ON UPDATE CASCADE ON DELETE CASCADE,
  message VARCHAR(255),
#   image INT,
#   ownerPost VARCHAR(255),
  timeOfPublication TIMESTAMP
);

CREATE TABLE db_starexpress.likes
(
  idLike INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  idProfile INT REFERENCES profile(idProfile) ON UPDATE CASCADE ON DELETE CASCADE,
  idPost INT REFERENCES posts(idPost) ON UPDATE CASCADE ON DELETE CASCADE,
  timeThisLike TIMESTAMP
);
