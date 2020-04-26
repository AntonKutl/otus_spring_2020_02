package ru.otus.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Document(collection = "comments")
public class Comment {

    @Id
    private String id;

    @Field
    private String comment;

    @Field
    private String bookId;

}
