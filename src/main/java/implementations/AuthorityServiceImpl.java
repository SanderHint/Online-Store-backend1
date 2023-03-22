package implementations;

import exceptions.AuthorityNotFoundException;
import models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.AuthorityRepository;
import services.AuthorityService;

import java.util.List;
import java.util.Optional;

/**
 * @author Sander Hintsov
 */
@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public List<Author> findAllAuthorities() {
        return authorityRepository.findAll();
    }

    @Override
    public Author findAuthorityByFirstName(String firstName) throws AuthorityNotFoundException {
        Optional<Author> optionalAuthority = authorityRepository.findByFirstName(firstName);

        if (optionalAuthority.isEmpty()) {
            throw new AuthorityNotFoundException(firstName);
        }

        return optionalAuthority.get();
    }

    @Override
    public void createAuthority(Author author) {

        author.setActive(true);
        authorityRepository.save(author);

    }
}