package ru.otus.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Document(collection = "authors")
public class AuthorItem {

    @Id
    private String id;

    @Field
    private String nameAuthor;

    @DBRef
    private GenreItem genre;

    @DBRef(lazy = true)
    private List<BookItem> book;
}
