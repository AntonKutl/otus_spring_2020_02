package ru.otus.service;

import java.io.IOException;

public interface BookService {

    void addBook() throws IOException;

    void viewAllBooks();

    void deleteBook() throws IOException;

    void editingBook() throws IOException;

    void viewBook() throws IOException;

}
