package ru.otus.dao;

import ru.otus.domane.Book;
import ru.otus.model.Comments;
import ru.otus.model.Genres;

import java.util.List;

public interface BookDAO {

    void addBook(Book book);

    void deleteBook(String nameBook);

    List<Genres> getAllBooks();

    void editingBook(String nameBook, String book);

    List<Book> viewBook(String nameBook);

    void addComments(String nameBook, String comment);

    List<Comments> viewComment(String nameBook);


}
