package implementations;

import exceptions.UserNotFoundException;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.UserRepository;
import services.UserService;

import java.util.List;
import java.util.Optional;

/**
 * @author Sander Hintsov
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByEmail(String email) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()){
            throw new UserNotFoundException(email);
        }

        return optionalUser.get();
    }

    @Override
    public void createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        userRepository.save(user);

    }
}