package com.OAuth.service;

import com.OAuth.bean.AuthUser;

import com.OAuth.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        // it will be called at access token generation time
        Optional<AuthUser> optUser = userRepository.findByUsername(userName);
        if (optUser.isPresent()) {
            AuthUser user = optUser.get();
            List<GrantedAuthority> authorities = user.getGrantedAuthorities()
                    .stream().map(roles -> new SimpleGrantedAuthority(roles.getAuthority()))
                    .collect(Collectors.toList());
            return new User(user.getUsername(), user.getPasswordb(), authorities);
        }
        throw new RuntimeException("user not exist");
    }
}
