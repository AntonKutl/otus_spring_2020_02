package ru.otus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.dao.BookRepository;
import ru.otus.dao.CommentRepository;
import ru.otus.model.Book;
import ru.otus.model.Comment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CommentServiceImpl implements CommentService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void addComment() throws IOException {
        Comment comment=new Comment();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите ID книги");
        comment.setBookId(reader.readLine());
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

    private void printComment(List<Comment> listComment){
        System.out.println("ID     Коментарии");
        for (Comment comment:listComment) {
            System.out.println(comment.getId()+"      "+comment.getComment());
        }
    }
}
