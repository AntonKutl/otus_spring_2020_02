package ru.otus.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@NoArgsConstructor
@Document(collection = "books")
public class BookItem {

    @Id
    private String id;

    @Field
    private String nameBook;

    @DBRef
    private AuthorItem author;

}
