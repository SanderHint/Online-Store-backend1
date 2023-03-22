package configurations;

import handlers.AuditAwareHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Sander Hintsov
 */
@Configuration
@EnableJpaAuditing
public class AuditConfiguration {
    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditAwareHandler();
    }
}