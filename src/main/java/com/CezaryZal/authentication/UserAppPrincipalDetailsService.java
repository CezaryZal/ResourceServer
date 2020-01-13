package com.CezaryZal.authentication;

import com.CezaryZal.entity.app.UserApp;
import com.CezaryZal.repository.UserAppRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;

@Service
public class UserAppPrincipalDetailsService implements UserDetailsService {

    private final UserAppRepository userAppRepository;

    @Autowired
    public UserAppPrincipalDetailsService(UserAppRepository userAppRepository) {
        this.userAppRepository = userAppRepository;
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String login) {
        UserApp user = userAppRepository.findByLoginName(login)
                .orElseThrow(() -> new AccountNotFoundException("User not found by loginName"));

        return new UserAppPrincipal(user);
    }
}
