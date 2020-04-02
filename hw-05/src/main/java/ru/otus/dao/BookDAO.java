package ru.otus.dao;

import ru.otus.domane.Book;

import java.util.List;

public interface BookDAO {

    void insertBook(Book book);

    void deleteBook(String nameBook);

    List<Book> getAllBooks();

    void editingBook(String nameBook, String book);

    Book viewBook(String nameBook);


}
