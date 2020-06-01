package otus.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import otus.dao.BookRepository;
import otus.model.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
public class BookRestController {

    private final BookRepository bookRepository;

    @Autowired
    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/api/book")
    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @DeleteMapping("/api/book/{id}")
    public Mono<Void> delete(@PathVariable(name = "id") String id){
        return bookRepository.deleteById(id);
    }

    @PostMapping(value = "/api/book")
    public Mono<Book> save(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/api/book/{id}")
    public Mono<Book> find(@PathVariable(name = "id") String id){
        return bookRepository.findById(id);
    }


/*    @PutMapping("/api/book/{id}")
    public Mono<Void> edit(@PathVariable(name = "id") String id, @RequestBody String nameBook) {
        Mono<Book> bookMono=bookRepository.findById(id);
        Book book=bookMono.doFirst(1);
        book.setNameBook(nameBook);
        System.out.println("hgggggggggggggggg");
        return null;
    }*/
}
