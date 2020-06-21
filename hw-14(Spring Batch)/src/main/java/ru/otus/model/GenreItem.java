package ru.otus.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "genres")
public class GenreItem {

    @Id
    private String id;

    @Field
    private String nameGenre;

    @DBRef(lazy = true)
    private List<AuthorItem> author;
}
