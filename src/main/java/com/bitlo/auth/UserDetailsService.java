package com.bitlo.auth;

import com.bitlo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private Map<String, String> user = new HashMap<>();

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

/*
    @PostConstruct
    public void init() {
        user.put("mev", passwordEncoder.encode("123"));
        user.put("beder", passwordEncoder.encode("123"));
    }
*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.bitlo.model.User user = userRepository.findByUsername(username);

        if (user != null) {
            return new User(user.getUsername(),user.getPassword(), new ArrayList<>());
        }
        throw new UsernameNotFoundException(username);
    }
}
