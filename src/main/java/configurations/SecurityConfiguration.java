package configurations;

import implementations.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static utils.Constants.Security.AUTHORITY_ADMIN;

import static utils.Constants.Security.AUTHORITY_USER;

/**
 * @author Sander Hintsov
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService () {
        return new CustomUserDetailsService();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userDetailsService());
        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        String role = "ROLE_";
        String admin = AUTHORITY_ADMIN.replace(role, "");
        String teacher = AUTHORITY_USER.replace(role, "");


        httpSecurity.authorizeRequests()
                .antMatchers("/", "/user/signup/**")
                .permitAll()
                .antMatchers("/user")
                .hasRole(admin)
                .antMatchers("/**")
                .hasAnyRole(admin)
                .antMatchers("/**")
                .hasAnyRole(teacher)
                .and()
                .httpBasic()
                .and()
                .formLogin()
                .and()
                .logout().permitAll(false).logoutSuccessUrl("/")
                .and()
                .csrf().disable();
    }
}