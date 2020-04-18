package ru.otus.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDAOjdbc implements BookDAO {
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public BookDAOjdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public void insertBook(Book book) {
        String sql = "INSERT INTO genres (nameGenre) VALUES (:nameGenre);" +
                "INSERT INTO authors(genresId, nameAuthor) VALUES (LAST_INSERT_ID(),:nameAuthor);" +
                "INSERT INTO books (authorsId, nameBook) VALUES (LAST_INSERT_ID(), :nameBook);";

        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("nameGenre", book.getGenre());
        in.addValue("nameAuthor", book.getAuthor());
        in.addValue("nameBook", book.getTitle());

        namedParameterJdbcOperations.update(sql, in)
        ;
    }

    @Override
    public void deleteBook(String nameBook) {
        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("nameBook", nameBook);
        String sql = "DELETE FROM books WHERE nameBook = :nameBook";
        namedParameterJdbcOperations.update(sql, in);
        }


    @Override
    public List<Book> getAllBooks() {
        String sql = "select genres.nameGenre,authors.nameAuthor,books.nameBook from books, authors, genres WHERE genres.id=authors.genresId AND authors.id=books.authorsId";
        return namedParameterJdbcOperations.query(sql, new BookMaper());
    }

    @Override
    public void editingBook(String oldNameBook, String book) {
        String sql = "UPDATE books SET nameBook=:nameBook WHERE nameBook=:oldNameBook";
        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("nameBook", book);
        in.addValue("oldNameBook", oldNameBook);
        namedParameterJdbcOperations.update(sql, in);
    }

    @Override
    public Book viewBook(String nameBook) {
        String sqlBook = "select genres.nameGenre,authors.nameAuthor,books.nameBook from books, authors, genres WHERE " +
                "genres.id=(select genresId from authors WHERE id=(select authorsId from books WHERE nameBook=:nameBook))" +
                " AND authors.id=(select authorsId from books WHERE nameBook=:nameBook) AND nameBook=:nameBook";
        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("nameBook", nameBook);

        return namedParameterJdbcOperations.queryForObject(sqlBook, in, new BookMaper());
    }


    private static class BookMaper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            Book book = new Book();
            book.setAuthor(resultSet.getString("nameAuthor"));
            book.setGenre(resultSet.getString("nameGenre"));
            book.setTitle(resultSet.getString("nameBook"));
            return book;
        }
    }


}
