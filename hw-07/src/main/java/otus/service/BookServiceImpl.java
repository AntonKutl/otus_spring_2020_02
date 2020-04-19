package otus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import otus.dao.BookRepository;
import otus.dao.CommentRepository;
import otus.model.Book;
import otus.model.Comment;

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
        System.out.println("Введите ID автора");
        book.setAuthorsID(Long.valueOf(reader.readLine()));
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
        long id = Long.valueOf(reader.readLine());
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void editingBook() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите ID редактируемой книги");
        long id = Long.valueOf(reader.readLine());
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

    @Override
    public void addComment() throws IOException {
        Comment comment=new Comment();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите ID книги");
        comment.setBookId(Long.valueOf(reader.readLine()));
        System.out.println("Введите коментарий к книге");
        comment.setComment(reader.readLine());
        commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void viewComments() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название книги");
        String nameBook = reader.readLine();
        Book book=bookRepository.findByNameBook(nameBook);
        printComment(book.getComments());
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
