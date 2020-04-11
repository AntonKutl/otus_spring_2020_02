package ru.otus.shell;


import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.service.BookService;

import java.io.IOException;

@ShellComponent
public class ApplicationEventsCommands {

    private final BookService bookService;

    public ApplicationEventsCommands(BookService bookService) {
        this.bookService = bookService;
    }

    @ShellMethod(key = {"viewAllBooks", "vab"}, value = "View all books")
    public void viewAll() throws IOException {
        bookService.viewAllBooks();
    }

    @ShellMethod(key = {"addBook", "ab"}, value = "Add book")
    public void addBook() throws IOException {
        bookService.addBook();
    }

    @ShellMethod(key = {"deleteBook", "db"}, value = "Delete book")
    public void deleteBook() throws IOException {
        bookService.deleteBook();
    }

    @ShellMethod(key = {"editingBook", "eb"}, value = "Editing book")
    public void editingBook() throws IOException {
        bookService.editingBook();
    }

    @ShellMethod(key = {"viewBook", "vb"}, value = "View book")
    public void viewBook() throws IOException {
        bookService.viewBook();
    }

    @ShellMethod(key = {"addComment", "ac"}, value = "Add Comment")
    public void addComment() throws IOException {
        bookService.addComment();
    }

    @ShellMethod(key = {"viewComment", "vc"}, value = "viewComment")
    public void viewComment() throws IOException {
        bookService.viewComments();
    }

}
