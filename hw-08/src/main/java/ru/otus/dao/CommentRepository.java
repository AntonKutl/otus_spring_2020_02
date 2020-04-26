package ru.otus.dao;

import org.springframework.data.repository.CrudRepository;
import ru.otus.model.Comment;


public interface CommentRepository extends CrudRepository<Comment,String> {
}
