package com.CezaryZal.authentication;

import com.CezaryZal.entity.UserApp;
import com.CezaryZal.exceptions.UserNotFoundException;
import com.CezaryZal.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserAppRepository userAppRepository;

    @Autowired
    public UserPrincipalDetailsService(UserAppRepository userAppRepository) {
        this.userAppRepository = userAppRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserApp user = userAppRepository.findByLoginName(login)
                .orElseThrow(() -> new UserNotFoundException("User not found by id by loginName"));

        return new UserPrincipal(user);
    }
}
