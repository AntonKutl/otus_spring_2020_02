package otus.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import otus.model.Book;
import reactor.core.publisher.Flux;


import java.util.List;

public interface BookRepository extends ReactiveCrudRepository<Book, String> {

    Book findByNameBook(String nameBook);

    Flux<Book> findAll();

}
