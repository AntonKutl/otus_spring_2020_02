package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {

}
