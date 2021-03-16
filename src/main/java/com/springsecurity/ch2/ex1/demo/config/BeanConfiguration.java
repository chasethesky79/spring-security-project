package com.springsecurity.ch2.ex1.demo.config;

import com.springsecurity.ch2.ex1.demo.model.User;
import com.springsecurity.ch2.ex1.demo.service.InMemoryUserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class BeanConfiguration {

    @Value("${loginUser.userName}")
    String userName;

    @Value("${loginUser.password}")
    String password;

    @Value("${loginUser.authorities")
    String authorities;

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsService(List.of(new User("John", "12345",
                "read")));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
