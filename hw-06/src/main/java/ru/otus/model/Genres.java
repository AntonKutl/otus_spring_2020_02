package ru.otus.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@Table(name = "genres")
public class Genres {

    public Genres(String nameGenre) {
        this.nameGenre = nameGenre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_genre", nullable = false)
    private String nameGenre;

    @OneToMany(targetEntity = Authors.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "genres_id")
    private List<Authors> author;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genres)) return false;
        Genres genres = (Genres) o;
        return Objects.equals(nameGenre, genres.nameGenre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameGenre);
    }
}
