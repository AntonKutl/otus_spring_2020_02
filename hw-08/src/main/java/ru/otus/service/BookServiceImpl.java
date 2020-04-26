package ru.otus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.dao.BookRepository;
import ru.otus.dao.CommentRepository;
import ru.otus.model.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void addBook() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Book book = new Book();
        System.out.println("Введите название книги");
        book.setNameBook(reader.readLine());
        System.out.println("Введите имя автора");
        book.setAuthor(reader.readLine());
        System.out.println("Введите жанр книги");
        book.setGenre(reader.readLine());

        bookRepository.save(book);
    }

    @Override
    public void viewAllBooks() {
        printListBook(bookRepository.findAll());
    }

    @Override
    public void deleteBook() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите ID удаляемой книги");
        String id = reader.readLine();
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void editingBook() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите ID редактируемой книги");
        String id = reader.readLine();
        System.out.println("Введите новое название книги");
        String nameBook = reader.readLine();
        Optional<Book> bookOptional=bookRepository.findById(id);
        Book book=bookOptional.get();
        book.setNameBook(nameBook);
        bookRepository.save(book);
    }

    @Override
    public void viewBook() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название книги");
        String nameBook = reader.readLine();
        printBook(bookRepository.findByNameBook(nameBook));
    }

    private void printListBook(List<Book> listBook){
        for (Book book:listBook) {
            System.out.println(book);
        }
    }

    private void printBook(Book book){
        System.out.println(book);
    }
}
