package com.cg.config;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.dto.UserData;

@Service
public class JPAUserDetailService implements UserDetailsService {

    @Autowired
    private UserDataRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<UserData> opt  = repo.findById(username);
        if (opt.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        UserData userData = opt.get();
        String [] roles= userData.getRoles().split(",");
        UserDetails userDetails = User.builder().username(userData.getUsername()).password(userData.getPassword()).roles(roles).build();
        
        return userDetails;
    }
    
}