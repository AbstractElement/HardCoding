DROP DATABASE IF EXISTS db_starexpress;

CREATE DATABASE IF NOT EXISTS db_starexpress;

USE db_starexpress;

CREATE TABLE db_starexpress.user
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  email VARCHAR(45) UNIQUE NOT NULL,
  pass VARCHAR(45)  NOT NULL
);

CREATE TABLE db_starexpress.profile
(
  idProfile INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  idUser INT REFERENCES user(id) ON UPDATE CASCADE ON DELETE CASCADE,
  firstName VARCHAR(45) DEFAULT '',
  lastName VARCHAR(45) DEFAULT '',
  currentCity VARCHAR(45) DEFAULT '',
  phoneNumber VARCHAR(14) DEFAULT '',
  age INT DEFAULT 0,
  sex VARCHAR(10) DEFAULT ''
);

CREATE TABLE db_starexpress.posts
(
  idPost INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  idProfile INT REFERENCES profile(idProfile) ON UPDATE CASCADE ON DELETE CASCADE,
  message VARCHAR(255),
  ownerPost VARCHAR(80),
  timeOfPublication TIMESTAMP
);
