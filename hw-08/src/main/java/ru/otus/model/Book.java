package ru.otus.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor

@Document(collection = "books")
public class Book {

    public Book(String nameBook, String author, String genre) {
        this.nameBook = nameBook;
        this.author = author;
        this.genre = genre;
    }

    @Id
    private String id;

    @Field
    private String nameBook;

    @Field
    private String author;

    @Field
    private String genre;

    @DBRef
    private List<Comment> comments;
}
