#From user table
INSERT INTO db_starexpress.user VALUES (1, 'test@test', 1234);
INSERT INTO db_starexpress.user VALUES (2, 'first@test', 1234);
INSERT INTO db_starexpress.user VALUES (3, 'second@test', 1234);

#From profile table
INSERT INTO db_starexpress.profile VALUES (1, 1, 'Tester', 'Test', 'Earth', '7778', 99, 'Other');
INSERT INTO db_starexpress.profile(idProfile, idUser, lastName, currentCity)
  VALUES (2, 2, 'First', 'Minsk');
INSERT INTO db_starexpress.profile(idProfile, idUser, firstName, lastName, age)
  VALUES (3, 3, 'First', 'Tester', 1);

#From post table
INSERT INTO db_starexpress.posts
  VALUES (1, 1, 'This is my first message', 'Test Tester', current_time);
INSERT INTO db_starexpress.posts
  VALUES (2, 1, 'My telephone number is 7778', 'Test Tester', current_time);
INSERT INTO db_starexpress.posts
  VALUES (3, 1, 'My name is Tester', 'Test Tester', current_time);


