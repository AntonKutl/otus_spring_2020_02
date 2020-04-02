package ru.otus.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.dao.BookDAO;
import ru.otus.domane.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class BookServiceImpl implements BookService {
    private final BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public void addBook() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Book book = new Book();
        System.out.println("Введите название книги");
        book.setTitle(reader.readLine());
        System.out.println("Введите жанр книги");
        book.setGenre(reader.readLine());
        System.out.println("Введите автора книги");
        book.setAuthor(reader.readLine());
        bookDAO.insertBook(book);
    }

    @Override
    public void viewAllBooks() {
        for (Book book : bookDAO.getAllBooks()) {
            System.out.println(book);
        }
    }

    @Override
    public void deleteBook() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название удаляемой книги");
        String nameBook = reader.readLine();
        bookDAO.deleteBook(nameBook);
    }

    @Override
    public void editingBook() throws IOException {
        Book book = new Book();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название редактируемой книги");
        String oldNameBook = reader.readLine();
        System.out.println("Введите новое название книги");
        String nameBook = reader.readLine();

        bookDAO.editingBook(oldNameBook, nameBook);
    }

    @Override
    public void viewBook() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название книги");
        String nameBook = reader.readLine();
        System.out.println(bookDAO.viewBook(nameBook));
    }


}
