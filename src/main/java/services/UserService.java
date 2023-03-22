package services;

import exceptions.UserNotFoundException;
import models.User;

import java.util.List;

/**
 * @author Sander Hintsov
 */
public interface UserService {
    /**
     * To find all users
     *
     * @return a list of User
     */
    List<User> findAllUsers();

    /**
     * To find user by email
     *
     * @param email email
     * @return User
     */
    User findUserByEmail(String email) throws UserNotFoundException;

    /**
     * To create a new User
     *
     * @param user User
     */
    void createUser(User user);
}