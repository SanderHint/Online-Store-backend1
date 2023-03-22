package exceptions;

/**
 * @author Sander Hintsov
 */
public class CategoryNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    public CategoryNotFoundException(Long id) {
        super(String.format("Category not found for id : %d" , id));
    }
}