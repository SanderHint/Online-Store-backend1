package handlers;

import org.springframework.data.domain.AuditorAware;
import utils.Constants;

import java.util.Optional;

/**
 * @author Sander Hintsov
 */
public class AuditAwareHandler implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() /*Set the value for CreatedBy & Lastmodified by*/ {
        return Optional.of(Constants.Audit.DEFAULT_AUDITOR);
    }
}