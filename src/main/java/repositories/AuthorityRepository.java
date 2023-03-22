package repositories;

import models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Sander Hintsov
 * */

@Repository
public interface AuthorityRepository extends JpaRepository<Author,Long> {
    Optional<Author> findByFirstName(String firstName);
}