package otus.dao;

import org.springframework.data.repository.CrudRepository;
import otus.model.Comment;


public interface CommentRepository extends CrudRepository<Comment,String> {
}
