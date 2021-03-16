package com.springsecurity.ch2.ex1.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@AllArgsConstructor
public class InMemoryUserDetailsService implements UserDetailsService {

    private List<UserDetails> users;

    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
        return this.users.stream().filter(
                user -> user.getUsername().equals(userName)).findFirst().orElseThrow(
                () -> new UsernameNotFoundException(String.format("User %s not found", userName)));

    }
}
