package ru.otus.dao;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.domane.Book;
import ru.otus.model.Authors;
import ru.otus.model.Books;
import ru.otus.model.Genres;

import java.util.ArrayList;
import java.util.List;


@DisplayName("В классе BookDAOjdbcTest")
@DataJpaTest
@Import(BookDAOjdbc.class)
class BookDAOjdbcTest {

    @Autowired
    private BookDAOjdbc bookDAOjdbc;

    @Autowired
    private TestEntityManager em;


    @Test
    @DisplayName("метод addBook() должен добавлять книгу ")
    void addBook() {
        Book book = new Book("Антон", "Код", "Java");
        bookDAOjdbc.addBook(book);
        bookDAOjdbc.viewBook("Код").get(0);
        Assert.assertEquals(book, bookDAOjdbc.viewBook("Код").get(0));
    }

    @Test
    @DisplayName("метод deleteBook() должен удалять книгу ")
    void deleteBook() {
        Book book = new Book("Антон", "Код", "Java");
        bookDAOjdbc.addBook(book);
        bookDAOjdbc.deleteBook("Код");
        Assert.assertNotEquals(book, bookDAOjdbc.viewBook("Код").get(0));
    }

    @Test
    @DisplayName("метод getAllBooks() должен возвращать все книги")
    void getAllBooks() {
        Genres genres = new Genres("Роман");
        Authors authors =new Authors("Толстой Л.Н");
        Books books=new Books("Война и мир");

        List <Books> listBook =new ArrayList<>();
        listBook.add(books);
        List<Authors> listAuthors = new ArrayList<>();
        listAuthors.add(authors);
        genres.setAuthor(listAuthors);

        Assert.assertEquals(genres, bookDAOjdbc.getAllBooks().get(0));
    }

    @Test
    @DisplayName("метод editingBook() должен редактировать книгу")
    void editingBook() {
        Book book = new Book("Толстой Л.Н", "Море", "Роман");
        bookDAOjdbc.editingBook("Война и мир", "Море");
        Assert.assertEquals(book, bookDAOjdbc.viewBook("Море").get(0));
    }

    @Test
    @DisplayName("метод viewBook() должен показывать книгу")
    void viewBook() {
        Book book = new Book("Толстой Л.Н", "Война и мир", "Роман");
        Assert.assertEquals(book, bookDAOjdbc.viewBook("Война и мир").get(0));
    }
}