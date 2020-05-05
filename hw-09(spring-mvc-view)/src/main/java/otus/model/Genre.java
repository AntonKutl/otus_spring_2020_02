package otus.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_genre", nullable = false)
    private String nameGenre;

    @OneToMany(targetEntity = Author.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "genres_id")
    private List<Author> author;
}
