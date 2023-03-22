package repositories;

import models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Sander Hintsov
 */
public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findByDescription(String description);

}