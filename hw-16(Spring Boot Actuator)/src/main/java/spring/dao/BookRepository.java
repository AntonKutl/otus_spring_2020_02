package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.model.Book;

public interface BookRepository extends JpaRepository <Book, Long> {

    Book findByNameBook(String nameBook);

}
