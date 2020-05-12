package ru.otus.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.dao.AuthorRepository;
import ru.otus.spring.dao.BookRepository;
import ru.otus.spring.model.Author;
import ru.otus.spring.model.Book;

import java.util.List;

@RestController
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/api/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @DeleteMapping ("/api/books/{id}")
    public void delete(@PathVariable(name = "id") long id){
        bookRepository.deleteById(id);
    }






    /*@GetMapping("/edit")
    public String editPage(@RequestParam("id") long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow(NotFoundException::new);
        model.addAttribute("book", book);
        return "edit";
    }
    
    @PostMapping("/edit")
    public String editBook(Book book, Model model) {
        bookRepository.save(book);
        return viewListBook(model);
    }

    @GetMapping("/delete")
    public String deletePage(@RequestParam("id") long id, Model model) {
        bookRepository.deleteById(id);
        return viewListBook(model);
    }

    @PostMapping("/save")
    public String savePerson(Book book, Model model) {
        bookRepository.save(book);
        return viewListBook(model);
    }

    private String viewListBook(Model model){
        List<Book> books = bookRepository.findAll();
        List<Author> authors=authorRepository.findAll();
        model.addAttribute("books", books);
        model.addAttribute("authors",authors);
        return "list";
    }
*/
}
