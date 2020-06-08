package otus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import otus.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByNameAuthor(String nameAuthor);
}
