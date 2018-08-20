INSERT INTO posts  VALUES (0,
'Spring Boot - Spring Data JPA with Hibernate and H2 Web Console',
5,
'Curret tecknologies are developed very fast. It difficult to controll all technologies',
'Spring Boot - Spring Data JPA with Hibernate and H2 Web Console');
--
INSERT INTO roles (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO roles (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

INSERT INTO users (id, first_name, last_name, password, username) VALUES (1, 'a', 'a', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'a.a');
INSERT INTO users (id, first_name, last_name, password, username) VALUES (2, 'b', 'b', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'b.b');

INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);
--
INSERT INTO messages (id, text, from_id, to_id) VALUES (0, 'hello, how are you?', 1, 2);
INSERT INTO messages (id, text, from_id, to_id) VALUES (1, 'fine, thanks and you?', 2, 1);
INSERT INTO messages (id, text, from_id, to_id) VALUES (2, 'i am heppy. welcome to best blog in the world!', 1, 2);
INSERT INTO messages (id, text, from_id, to_id) VALUES (3, 'thanks', 2, 1);
--
INSERT INTO comments (id, text, author_id, post_id) VALUES (0, 'good post, thanks', 1, 0);
INSERT INTO comments (id, text, author_id, post_id) VALUES (1, 'отстой, братан, ну серьезно', 2, 0);
INSERT INTO comments (id, text, author_id, post_id) VALUES (2, 'пойдет', 1, 0);