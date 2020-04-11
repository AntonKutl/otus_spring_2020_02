package ru.otus.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.dao.BookDAO;
import ru.otus.domane.Book;
import ru.otus.model.Authors;
import ru.otus.model.Books;
import ru.otus.model.Comments;
import ru.otus.model.Genres;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

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
        bookDAO.addBook(book);
    }

    @Override
    public void viewAllBooks() {
        printСatalogBook(bookDAO.getAllBooks());
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
        printBooks(bookDAO.viewBook(nameBook));
    }

    @Override
    public void addComment() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название книги");
        String nameBook = reader.readLine();
        System.out.println("Введите коментарий к книге");
        String comment = reader.readLine();
        bookDAO.addComments(nameBook, comment);
    }

    @Override
    public void viewComments() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название книги");
        String nameBook = reader.readLine();
        System.out.println(bookDAO.viewComment(nameBook));
    }


    private void printСatalogBook(List<Genres> list) {
        for (Genres genres : list) {
            System.out.println("Жанр:" + genres.getNameGenre());
            for (Authors authors : genres.getAuthor()) {
                System.out.println("|----Автор:" + authors.getNameAuthor());
                for (Books book : authors.getBook()) {
                    System.out.println("     |-------Название книги:" + book.getNameBook());
                    System.out.print("             |--------------Коментарии:");
                    for (Comments comment : book.getComments()) {
                        System.out.print(comment.getComment());
                    }
                    System.out.println();
                }

            }
            System.out.println();

        }
    }

    private void printBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println("Название книги:" + book.getTitle());
            System.out.println("Автор книги:" + book.getAuthor());
            System.out.println("Жанр книги:" + book.getGenre());
        }
    }


}
