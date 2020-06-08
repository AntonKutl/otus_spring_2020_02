
INSERT INTO genres (name_genre) VALUES ('Роман');
INSERT INTO authors(genres_id, name_author) VALUES (1,'Толстой Л.Н');
INSERT INTO books (authors_id, name_book) VALUES (1, 'Война и мир');
INSERT INTO books (authors_id, name_book) VALUES (1, 'Анна Каренина');


INSERT INTO authors(genres_id, name_author) VALUES (1,'Пушкин А.С');
INSERT INTO books (authors_id, name_book) VALUES (2, 'Кавказ');
INSERT INTO comments (book_id, value_comment) VALUES (3, 'Самое непонятное задание');

INSERT INTO usertable(name_user, password_user, name_role) VALUES ('user', 'password', 'USER');
INSERT INTO usertable(name_user, password_user, name_role) VALUES ('admin', 'password', 'ADMIN');





