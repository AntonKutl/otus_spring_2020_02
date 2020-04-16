package ru.otus.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;


@Repository
public class BookDAOjdbc implements BookDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void addBook(Book book) {
        em.persist(book);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        em.remove(em.find(Book.class,id));
    }

    @Override
    public List<Book> getAllBooks() {
        return em.createQuery("SELECT e FROM Book e ", Book.class).getResultList();
    }

    @Override
    @Transactional
    public void editingBook(long id, String newNameBook) {
        Book book=em.find(Book.class,id);
        book.setNameBook(newNameBook);
        em.merge(book);
    }

    @Override
    public Book viewBook(String nameBook) {
        Query query = em.createQuery("SELECT b FROM Book b JOIN FETCH b.comments WHERE b.nameBook=:nameBook",Book.class);
        query.setParameter("nameBook", nameBook);
        return (Book) query.getSingleResult();
    }
}


