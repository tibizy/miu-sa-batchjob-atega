package com.miusaatega.batchjob.services;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    List<User> users = new ArrayList<>() {
        {
            add(new User("admin", "admin",
                    new ArrayList<>() {
                        {
                            add(new SimpleGrantedAuthority("ADMIN"));
                        }
                    }));
            add(new User("user", "user",
                    new ArrayList<>() {
                        {
                            add(new SimpleGrantedAuthority("USER"));
                        }
                    }));
        }
    };

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return users.stream().filter(u -> u.getUsername().equals(s)).findFirst().orElse(null);
    }
}