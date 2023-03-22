package services;

import exceptions.AuthorityNotFoundException;
import models.Author;

import java.util.List;

/**
 * @author Sander Hintsov
 */
public interface AuthorityService {
    /**
     * To find all authorities
     *
     * @return a list of authorities
     */
    List<Author> findAllAuthorities();

    /**
     * To find authority by firstName
     *
     * @param firstName Authority firstName
     * @return Authority
     */
    Author findAuthorityByFirstName(String firstName) throws AuthorityNotFoundException;

    /**
     * To create a new authority
     *
     * @param author Authority
     */
    void createAuthority(Author author);

}