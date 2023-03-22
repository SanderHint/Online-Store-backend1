package implementations;

import exceptions.UserNotFoundException;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import services.UserService;

/**
 * @author Sander Hintsov
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userService.findUserByEmail(username);
            return new CustomUserDetails(user);
        } catch (UserNotFoundException e) {
            throw new UsernameNotFoundException(e.getLocalizedMessage());
        }

    }
}