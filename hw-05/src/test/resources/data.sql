
INSERT INTO genres (nameGenre) VALUES ('Роман');
INSERT INTO authors(genresId, nameAuthor) VALUES (LAST_INSERT_ID(),'Толстой Л.Н');
INSERT INTO books (authorsId, nameBook) VALUES (LAST_INSERT_ID(), 'Война и мир');





