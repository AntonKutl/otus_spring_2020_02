package otus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import otus.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByNameUser(String nameUser);
}
