package com.CezaryZal.manager.db.service;

import com.CezaryZal.entity.UserHc;
import com.CezaryZal.exceptions.UserNotFoundException;
import com.CezaryZal.repository.UserHcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserHcServiceImp implements UserHcService {

    private UserHcRepository userHcRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserHcServiceImp(UserHcRepository userHcRepository, PasswordEncoder passwordEncoder) {
        this.userHcRepository = userHcRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserHc findById(Long index) {
        return userHcRepository.findById(index)
                .orElseThrow(() -> new UserNotFoundException("User not found by id"));
    }

    public UserHc findByLoginName(String loginName) {
        return userHcRepository.findByLoginName(loginName)
                .orElseThrow(() -> new UserNotFoundException("User not found by loginName"));
    }

    public List<UserHc> findAll() {
        return (List<UserHc>) userHcRepository.findAll();
    }

    public UserHc addNewUser(UserHc userHc) {
        String passwordBcrypt = passwordEncoder.encode(userHc.getPassword());
        userHc.setPassword(passwordBcrypt);
        return userHcRepository.save(userHc);
    }

    public UserHc updateUser(UserHc userHc) {
        return userHcRepository.save(userHc);
    }

    public void deleteUser(Long index) {
        userHcRepository.deleteById(index);
    }


}
