package com.miusaatega.batchjob.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserDetailsService {

    List<User> users = new ArrayList<User>(){
        {
            add(new User("admin", "admin",
                    new ArrayList<GrantedAuthority>(){
                        {
                            add(new SimpleGrantedAuthority("ADMIN"));
                        }
                    }));
        }
    };

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return users.stream().filter(u -> u.getUsername().equals(s)).findFirst().orElse(null);
    }
}