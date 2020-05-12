package ru.otus.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByNameAuthor(String nameAuthor);
}
