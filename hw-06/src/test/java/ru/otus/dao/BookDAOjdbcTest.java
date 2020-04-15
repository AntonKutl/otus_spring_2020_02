package ru.otus.dao;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.model.Book;
import ru.otus.model.Comment;

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
    @DisplayName("метод getAllBooks() должен возвращать все книги")
    void getAllBooks() {
        List <Book> listBook =new ArrayList<>();
        Book book1=new Book();
        book1.setId(1);
        book1.setAuthorsID(1);
        book1.setNameBook("Война и мир");
        book1.setComments(new ArrayList<Comment>());
        Book book2=new Book();
        book2.setId(2);
        book2.setAuthorsID(1);
        book2.setNameBook("Семейное счастье");
        book2.setComments(new ArrayList<Comment>());
        listBook.add(book1);
        listBook.add(book2);

        Assert.assertEquals(listBook, bookDAOjdbc.getAllBooks());
    }

    @Test
    @DisplayName("метод editingBook() должен редактировать книгу")
    void editingBook() {
        Book book1=new Book();
        book1.setId(1);
        book1.setAuthorsID(1);
        book1.setNameBook("Море");
        book1.setComments(new ArrayList<Comment>());
        bookDAOjdbc.editingBook(1, "Море");
        Assert.assertEquals(book1, bookDAOjdbc.viewBook("Море"));
    }

    @Test
    @DisplayName("метод viewBook() должен показывать книгу")
    void viewBook() {
        Book book1=new Book();
        book1.setId(1);
        book1.setAuthorsID(1);
        book1.setNameBook("Война и мир");
        book1.setComments(new ArrayList<Comment>());
        Assert.assertEquals(book1, bookDAOjdbc.viewBook("Война и мир"));
    }
}