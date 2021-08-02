package br.com.ia.developerchallenge.webservice.configuration.security;

import br.com.ia.developerchallenge.webservice.repositories.interfaces.IUserRepository;
import br.com.ia.developerchallenge.webservice.util.Converters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
            .disable()
            .authorizeRequests()
            .mvcMatchers(HttpMethod.POST, "/user")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .and()
            .logout()
            .and()
            .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, IUserRepository repository) throws Exception {
        repository.findAll().forEach(user->{
            try {
                auth.inMemoryAuthentication()
                    .withUser(user.getLogin())
                    .password(passwordEncoder().encode(user.getPassword()))
                    .roles(Converters.BooleanToUserRole(user.isAdmin()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
    }

}