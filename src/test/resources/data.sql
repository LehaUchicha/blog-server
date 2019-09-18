INSERT INTO roles (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO roles (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

INSERT INTO users (id, first_name, last_name, password, username) VALUES (1, 'a', 'a', '$2y$10$nXwM1FDj0LAjdHT5VTqK0.G38.4NuSjZno3qPGG82SNQe6RI20N32', 'a.a');
INSERT INTO users (id, first_name, last_name, password, username) VALUES (2, 'b', 'b', '$2y$10$nXwM1FDj0LAjdHT5VTqK0.G38.4NuSjZno3qPGG82SNQe6RI20N32', 'b.b');

INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);

INSERT INTO posts (id, title, short_text, full_text) VALUES (0,
'Spring Boot - Spring Data JPA with Hibernate and H2 Web Console',
'Curret tecknologies are developed very fast. It difficult to controll all technologies',
'Spring Boot - Spring Data JPA with Hibernate and H2 Web Console');

--
--INSERT INTO messages (id, text, from_id, to_id) VALUES (0, 'hello, how are you?', 1, 2);
--INSERT INTO messages (id, text, from_id, to_id) VALUES (1, 'fine, thanks and you?', 2, 1);
--INSERT INTO messages (id, text, from_id, to_id) VALUES (2, 'i am heppy. welcome to best blog in the world!', 1, 2);
--INSERT INTO messages (id, text, from_id, to_id) VALUES (3, 'thanks', 2, 1);
--
INSERT INTO comments (id, text, author_id, post_id) VALUES (0, 'good post, thanks', 1, 0);
INSERT INTO comments (id, text, author_id, post_id) VALUES (1, 'отстой, братан, ну серьезно', 2, 0);
INSERT INTO comments (id, text, author_id, post_id) VALUES (2, 'пойдет', 1, 0);

INSERT INTO likes (id, user_id, post_id, comment_id) VALUES (0, 1, 0, null);
INSERT INTO likes (id, user_id, post_id, comment_id) VALUES (1, 1, null, 0);
INSERT INTO likes (id, user_id, post_id, comment_id) VALUES (2, 1, null, 1);
INSERT INTO likes (id, user_id, post_id, comment_id) VALUES (3, 2, 0, null);
INSERT INTO likes (id, user_id, post_id, comment_id) VALUES (4, 2, null, 0);
INSERT INTO likes (id, user_id, post_id, comment_id) VALUES (5, 2, null, 1);

INSERT INTO dialogs (id, dialog_name) VALUES (0, 'Интересный чатик');
INSERT INTO dialogs (id, dialog_name) VALUES (1, 'Alex справедливый');

INSERT INTO user_dialog (id, dialog_id, user_id, text) VALUES (0, 0, 1, 'Привет))');
INSERT INTO user_dialog (id, dialog_id, user_id, text) VALUES (1, 0, 2, 'Здороуууу');
INSERT INTO user_dialog (id, dialog_id, user_id, text) VALUES (2, 0, 1, 'Как твои дела, мне интересно?');
INSERT INTO user_dialog (id, dialog_id, user_id, text) VALUES (3, 0, 2, 'Ниче не понял че ты написала)');
INSERT INTO user_dialog (id, dialog_id, user_id, text) VALUES (4, 0, 1, 'Ну и пока тогда, козел!');
INSERT INTO user_dialog (id, dialog_id, user_id, text) VALUES (5, 1, 1, 'Чат пуст))');