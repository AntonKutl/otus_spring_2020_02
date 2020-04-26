package ru.otus.dao;

import org.springframework.data.repository.CrudRepository;
import ru.otus.model.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, String> {

    Book findByNameBook(String nameBook);

    List<Book> findAll();

}
