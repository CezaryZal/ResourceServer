package com.CezaryZal.manager.health.calendar.service;

import com.CezaryZal.entity.health.calendar.UserAuthentication;
import com.CezaryZal.repository.UserHcAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@Service
public class UserHcAuthServiceImp implements UserHcAuthService {

    private UserHcAuthRepository userHcAuthRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserHcAuthServiceImp(UserHcAuthRepository userHcAuthRepository, PasswordEncoder passwordEncoder) {
        this.userHcAuthRepository = userHcAuthRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserAuthentication findById(Long index) throws AccountNotFoundException {
        return userHcAuthRepository.findById(index)
                .orElseThrow(() -> new AccountNotFoundException("User not found by id"));
    }

    public UserAuthentication findByLoginName(String loginName) throws AccountNotFoundException {
        return userHcAuthRepository.findByLoginName(loginName)
                .orElseThrow(() -> new AccountNotFoundException("User not found by loginName"));
    }

    public boolean isExistsUserAuthenticationByLoginName(String loginName){
        return userHcAuthRepository.existsUserAuthenticationByLoginName(loginName);
    }

    public List<UserAuthentication> findAll() {
        return (List<UserAuthentication>) userHcAuthRepository.findAll();
    }

    public UserAuthentication addNewUser(UserAuthentication userAuthentication) {
        String passwordBcrypt = passwordEncoder.encode(userAuthentication.getPassword());
        userAuthentication.setPassword(passwordBcrypt);
        return userHcAuthRepository.save(userAuthentication);
    }

    public UserAuthentication updateUser(UserAuthentication userAuthentication) {
        return userHcAuthRepository.save(userAuthentication);
    }

    public void deleteUser(Long index) {
        userHcAuthRepository.deleteById(index);
    }


}
