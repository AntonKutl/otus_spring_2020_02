package ru.otus.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "authors")
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Authors(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    @Column(name = "name_author",nullable = false)
    private String nameAuthor;

    @OneToMany(targetEntity = Books.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "authors_id")
    private List<Books> book;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Authors)) return false;
        Authors authors = (Authors) o;
        return Objects.equals(nameAuthor, authors.nameAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameAuthor);
    }
}
