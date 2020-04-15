package ru.otus.dao;

import ru.otus.model.Comment;

import java.util.List;

public interface CommentDAO {

    void addComments(Comment comment);

    List<Comment> viewComment(long id);
}
