package ru.otus.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.model.Book;

public interface BookRepository extends JpaRepository <Book, Long> {

    Book findByNameBook(String nameBook);

}
