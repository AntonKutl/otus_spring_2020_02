package ru.otus.dao;

import ru.otus.domane.Book;
import ru.otus.model.Books;
import ru.otus.model.Genres;

import java.util.List;

public interface BookDAO {

    void addBook(Book book);

    void deleteBook(String nameBook);

    List<Genres> getAllBooks();

    void editingBook(String nameBook, String book);

    List<Book> viewBook(String nameBook);


}
