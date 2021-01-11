package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByNameAuthor(String nameAuthor);
}
