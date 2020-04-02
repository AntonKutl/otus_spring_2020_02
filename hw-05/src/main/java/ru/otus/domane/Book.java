package ru.otus.domane;

import java.util.Objects;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return " | " + title + " | " + genre + " | " + author + " | ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) &&
                Objects.equals(title, book.title) &&
                Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, genre);
    }
}
