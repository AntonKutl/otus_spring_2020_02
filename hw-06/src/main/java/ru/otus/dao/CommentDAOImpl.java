package ru.otus.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class CommentDAOImpl implements CommentDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addComments(Comment comment) {
        em.persist(comment);
    }

    @Override
    public List<Comment> viewComment(long id) {
        Query query = em.createQuery("SELECT b.comments FROM Book b WHERE b.id=:id");
        query.setParameter("id", id);
        return query.getResultList();
    }
}
