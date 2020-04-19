package otus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import otus.model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
