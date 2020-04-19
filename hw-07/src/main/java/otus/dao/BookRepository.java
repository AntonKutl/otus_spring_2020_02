package otus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import otus.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository <Book, Long> {

    Book findByNameBook(String nameBook);

}
