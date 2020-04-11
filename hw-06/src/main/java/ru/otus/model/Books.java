package ru.otus.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@Table(name = "books")
public class Books {


    public Books(String nameBook) {
        this.nameBook = nameBook;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_book", nullable = false)
    private String nameBook;

    @OneToMany(targetEntity = Comments.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private List<Comments> comments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Books)) return false;
        Books books = (Books) o;
        return Objects.equals(nameBook, books.nameBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameBook);
    }
}
