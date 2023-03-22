package services;

import exceptions.OrderLineNotFoundExceptions;
import models.OrderLine;

import java.util.List;

/**
 * @author Sander Hintsov
 */
public interface OrderLineService {

    /**
     * To create a new orderLine
     *
     * @param orderLine OrderLine
     */
    void createOrderLine(OrderLine orderLine);

    /**
     * To find a orderLine by ID
     *
     * @param id OrderLine ID
     * @return OrderLine
     */
    OrderLine findOrderLineById(Long id) throws OrderLineNotFoundExceptions;

    /**
     * To find all OrderLines
     *
     * @return a list of OrderLines
     */
    List<OrderLine> findAllOrderLines();

    /**
     * To delete a OrderLine by ID
     *
     * @param id OrderLine id
     */
    void deleteOrderLineById(Long id) throws OrderLineNotFoundExceptions;

    /**
     * To restore a OrderLine by ID
     *
     * @param id OrderLine id
     */
    void restoreOrderLineById(Long id) throws OrderLineNotFoundExceptions;
}
