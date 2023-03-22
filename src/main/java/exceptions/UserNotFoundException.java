package exceptions;

/**
 * @author Sander Hintsov
 */
public class UserNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String email) {
        super(String.format("User not found for email : %s!" , email));
    }

}