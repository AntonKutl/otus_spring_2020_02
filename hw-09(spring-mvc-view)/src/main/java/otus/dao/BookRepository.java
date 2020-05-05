package otus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import otus.model.Book;

public interface BookRepository extends JpaRepository <Book, Long> {

    Book findByNameBook(String nameBook);

}
