package com.CezaryZal.security;

import com.CezaryZal.entity.UserToHc;
import com.CezaryZal.exceptions.UserNotFoundException;
import com.CezaryZal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserToHc user = userRepository.findByLoginName(login)
                .orElseThrow(() -> new UserNotFoundException("User not found by id by loginName"));

        return new UserPrincipal(user);
    }
}
