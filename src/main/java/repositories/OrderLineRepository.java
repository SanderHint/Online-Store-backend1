package repositories;

import models.Order;
import models.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Sander Hintsov
 */
@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine,Long> {

    Optional<OrderLine> findById(Long id);

    List<OrderLine> findAllByOrder(Order order);


}