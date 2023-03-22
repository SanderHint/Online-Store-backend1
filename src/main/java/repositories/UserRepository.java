package repositories;

import models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Sander Hintsov
 */
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByFullName(String fullName);

    Optional<User> findByEmail(String email);
}