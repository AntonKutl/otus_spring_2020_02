package ru.otus.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CommentDAOImpl implements CommentDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void addComments(Comment comment) {
        em.persist(comment);
    }
}
