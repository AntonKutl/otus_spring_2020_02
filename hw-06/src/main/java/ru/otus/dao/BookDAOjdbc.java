package ru.otus.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.domane.Book;
import ru.otus.model.Authors;
import ru.otus.model.Books;
import ru.otus.model.Comments;
import ru.otus.model.Genres;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class BookDAOjdbc implements BookDAO {


    @PersistenceContext
    private EntityManager em;

    @Override
    public void addBook(Book book) {
        Genres genres = new Genres(book.getGenre());
        Authors authors = new Authors(book.getAuthor());
        Books books = new Books(book.getTitle());

        List<Books> listBook = new ArrayList<>();
        List<Authors> listAuthors = new ArrayList<>();

        listBook.add(books);
        authors.setBook(listBook);

        listAuthors.add(authors);
        genres.setAuthor(listAuthors);

        Query query = em.createQuery("SELECT g FROM Genres g WHERE g.nameGenre=:nameGenre");
        query.setParameter("nameGenre", book.getGenre());
        List<Genres> genresList = query.getResultList();

        if (genresList.size() == 0) {
            em.persist(genres);
        } else {
            genres = genresList.get(0);
            listAuthors = genres.getAuthor();

            if (!listAuthors.contains(authors)) {
                listAuthors.add(authors);
            } else {
                authors = listAuthors.get(listAuthors.indexOf(new Authors(book.getAuthor())));
                listBook = authors.getBook();
                listBook.add(new Books(book.getTitle()));
            }

        }


    }

    @Override
    public void deleteBook(String nameBook) {
        Query query = em.createQuery("delete from Books s where s.nameBook = :nameBook");
        query.setParameter("nameBook", nameBook);
        query.executeUpdate();
    }

    @Override
    public List<Genres> getAllBooks() {
        return em.createQuery("SELECT e FROM Genres e", Genres.class).getResultList();
    }

    @Override
    public void editingBook(String oldNameBook, String nameBook) {
        Query query = em.createQuery("UPDATE Books b SET b.nameBook = :nameBook WHERE b.nameBook=:oldNameBook");
        query.setParameter("nameBook", nameBook);
        query.setParameter("oldNameBook", oldNameBook);
        query.executeUpdate();
    }

    @Override
    public List<Book> viewBook(String nameBook) {
        Query query = em.createQuery("SELECT NEW ru.otus.domane.Book" +
                "((SELECT a.nameAuthor FROM Authors a JOIN a.book b WHERE b.nameBook=:nameBook)," +
                "(SELECT b.nameBook FROM Books b WHERE b.nameBook=:nameBook), " +
                "(SELECT g.nameGenre FROM Genres g JOIN g.author a JOIN a.book b WHERE b.nameBook=:nameBook )) " +
                "FROM Genres g ");
        query.setParameter("nameBook", nameBook);
        return query.getResultList();
    }

    @Override
    public void addComments(String nameBook, String comment) {
        Query query = em.createQuery("SELECT b FROM Books b WHERE b.nameBook=:nameBook");
        query.setParameter("nameBook", nameBook);
        List<Books> book = query.getResultList();
        Comments commentBook = new Comments();
        commentBook.setComment(comment);
        book.get(0).getComments().add(commentBook);
    }

    @Override
    public List<Comments> viewComment(String nameBook) {
        Query query = em.createQuery("SELECT b.comments FROM Books b WHERE b.nameBook=:nameBook");
        query.setParameter("nameBook", nameBook);
        return query.getResultList();
    }

}


