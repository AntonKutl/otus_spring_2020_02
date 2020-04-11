package ru.otus.domane;

import lombok.Data;

@Data
public class Book {


    private String author;
    private String title;
    private String genre;

    public Book() {
    }

    public Book(String author, String title, String genre) {
        this.author = author;
        this.title = title;
        this.genre = genre;
    }
}
