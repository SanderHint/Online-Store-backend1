package exceptions;


/**
 * @author Sander Hintsov
 */
public class AuthorityNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public AuthorityNotFoundException(String firstName) {
        super(String.format("Authority not found for firstName : %s" , firstName));
    }
}