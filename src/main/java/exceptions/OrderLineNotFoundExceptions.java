package exceptions;

/**
 * @author Sander Hintsov
 */
public class OrderLineNotFoundExceptions extends Exception{
    private static final long serialVersionUID = 1L;

    public OrderLineNotFoundExceptions(Long id){
        super(String.format("Cart not found for id : %d ", id));

    }
}