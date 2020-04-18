package ru.otus.service;

import org.springframework.stereotype.Service;
import ru.otus.dao.BookDAO;


import ru.otus.dao.CommentDAO;
import ru.otus.model.Book;
import ru.otus.model.Comment;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;
    private final CommentDAO commentDAO;

    public BookServiceImpl(BookDAO bookDAO, CommentDAO commentDAO) {
        this.bookDAO = bookDAO;
        this.commentDAO = commentDAO;
    }

    @Override
    public void addBook() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Book book = new Book();
        System.out.println("Введите название книги");
        book.setNameBook(reader.readLine());
        System.out.println("Введите ID автора");
        book.setAuthorsID(Long.valueOf(reader.readLine()));
        bookDAO.addBook(book);
    }

    @Override
    public void viewAllBooks() {
        printListBook(bookDAO.getAllBooks());
    }

    @Override
    public void deleteBook() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите ID удаляемой книги");
        long id = Long.valueOf(reader.readLine());
        bookDAO.deleteById(id);
    }

    @Override
    public void editingBook() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите ID редактируемой книги");
        long id = Long.valueOf(reader.readLine());
        System.out.println("Введите новое название книги");
        String nameBook = reader.readLine();
        bookDAO.editingBook(id, nameBook);
    }

    @Override
    public void viewBook() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название книги");
        String nameBook = reader.readLine();
        printBook(bookDAO.viewBook(nameBook));
    }

    @Override
    public void addComment() throws IOException {
        Comment comment=new Comment();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите ID книги");
        comment.setBookId(Long.valueOf(reader.readLine()));
        System.out.println("Введите коментарий к книге");
        comment.setComment(reader.readLine());
        commentDAO.addComments(comment);
    }

    @Override
    public void viewComments() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название книги");
        String nameBook = reader.readLine();
        Book book=bookDAO.viewBook(nameBook);
        printComment(book.getComments());
        //printComment(commentDAO.viewComment(id));
    }

    private void printListBook(List<Book> listBook){
        System.out.println("ID     Название книги");
        for (Book book:listBook) {
            System.out.println(book.getId()+"      "+book.getNameBook());
        }
    }

    private void printBook(Book book){
        System.out.println("ID     Название книги");
        System.out.println(book.getId()+"      "+book.getNameBook());
    }

    private void printComment(List<Comment> listComment){
        System.out.println("ID     Коментарии");
        for (Comment comment:listComment) {
            System.out.println(comment.getId()+"      "+comment.getComment());
        }
    }

}
