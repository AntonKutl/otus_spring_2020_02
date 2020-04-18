package ru.otus.dao;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.model.Book;

import java.util.ArrayList;
import java.util.List;


@DisplayName("В классе BookDAOjdbcTest")
@JdbcTest
@Import(BookDAOjdbc.class)
class BookDAOjdbcTest {

    @Autowired
    private BookDAOjdbc bookDAOjdbc;


    @Test
    @DisplayName("метод insertBook() должен добавлять книгу ")
    void insertBook() {
        Book book = new Book("Антон", "Код", "Java");
        bookDAOjdbc.insertBook(book);
        Assert.assertEquals(book, bookDAOjdbc.viewBook("Код"));
    }

    @Test
    @DisplayName("метод deleteBook() должен удалять книгу ")
    void deleteBook() {
        Book book = new Book("Антон", "Код", "Java");
        bookDAOjdbc.insertBook(book);
        bookDAOjdbc.deleteBook("Код");
        Assert.assertEquals(1, bookDAOjdbc.getAllBooks().size());
    }

    @Test
    @DisplayName("метод getAllBooks() должен возвращать все книги")
    void getAllBooks() {
        List<Book> list = new ArrayList<>();
        Book book = new Book("Антон", "Код", "Java");
        list.add(new Book("Толстой Л.Н", "Война и мир", "Роман"));
        list.add(book);
        bookDAOjdbc.insertBook(book);

        Assert.assertEquals(list, bookDAOjdbc.getAllBooks());
    }

    @Test
    @DisplayName("метод editingBook() должен редактировать книгу")
    void editingBook() {
        Book book = new Book("Толстой Л.Н", "Море", "Роман");
        bookDAOjdbc.editingBook("Война и мир", "Море");
        Assert.assertEquals(book, bookDAOjdbc.viewBook("Море"));
    }

    @Test
    @DisplayName("метод viewBook() должен показывать книгу")
    void viewBook() {
        Book book = new Book("Толстой Л.Н", "Война и мир", "Роман");
        Assert.assertEquals(book, bookDAOjdbc.viewBook("Война и мир"));
    }
}