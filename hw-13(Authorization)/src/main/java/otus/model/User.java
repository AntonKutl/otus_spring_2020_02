package otus.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "usertable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_user", nullable = false)
    private String nameUser;

    @Column(name = "password_user", nullable = false)
    private String passwordUser;

    @Column(name = "name_role", nullable = false)
    private String role;
}
