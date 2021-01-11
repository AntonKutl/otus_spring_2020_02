package spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.dao.AuthorRepository;
import spring.dao.BookRepository;
import spring.model.Author;
import spring.model.Book;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/api/authors")
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @DeleteMapping("/api/books/{id}")
    public void delete(@PathVariable(name = "id") long id){
        bookRepository.deleteById(id);
    }

    @PostMapping(value = "/api/book")
    public ResponseEntity<?> save(@RequestBody Book book) {
        bookRepository.save(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/api/books/{id}")
    public void edit(@PathVariable(name = "id") long id, @RequestBody String nameBook) {
        Optional<Book> bookOptional=bookRepository.findById(id);
        Book book=bookOptional.get();
        book.setNameBook(nameBook);
    }

}
