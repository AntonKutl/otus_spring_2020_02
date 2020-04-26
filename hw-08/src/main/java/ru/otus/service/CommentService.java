package ru.otus.service;

import java.io.IOException;

public interface CommentService {

    void addComment() throws IOException;

    void viewComments() throws IOException;
}
