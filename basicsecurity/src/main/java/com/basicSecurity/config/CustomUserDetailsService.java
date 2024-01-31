package com.basicSecurity.config;

import com.basicSecurity.entity.User;
import com.basicSecurity.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userByUsername = userRepo.findUserByUsername(username);

        if (userByUsername == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(userByUsername.getUsername())
                .password(passwordEncoder.encode(userByUsername.getPassword()))
                .build();
    }
}
