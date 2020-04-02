
INSERT INTO genres (nameGenre) VALUES ('Роман');
INSERT INTO authors(genresId, nameAuthor) VALUES (LAST_INSERT_ID(),'Толстой Л.Н');
INSERT INTO books (authorsId, nameBook) VALUES (LAST_INSERT_ID(), 'Война и мир');
INSERT INTO books (authorsId, nameBook) VALUES (LAST_INSERT_ID(), 'Анна Каренина');

INSERT INTO genres (nameGenre) VALUES ('Стихи');
INSERT INTO authors(genresId, nameAuthor) VALUES (LAST_INSERT_ID(),'Пушкин А.С');
INSERT INTO books (authorsId, nameBook) VALUES (LAST_INSERT_ID(), 'Кавказ');




