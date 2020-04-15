package ru.otus.dao;

import ru.otus.model.Book;

import java.util.List;

public interface BookDAO {

    void addBook(Book book);

    void deleteById(long id);

    List<Book> getAllBooks();

    void editingBook(long id, String newNameBook);

    Book viewBook(String nameBook);




}
