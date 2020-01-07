package com.CezaryZal.manager.db.service;

import com.CezaryZal.entity.UserToHc;
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

    public UserToHc findById(Long index) {
        return userHcRepository.findById(index)
                .orElseThrow(() -> new UserNotFoundException("User not found by id"));
    }

    public UserToHc findByLoginName(String loginName) {
        return userHcRepository.findByLoginName(loginName)
                .orElseThrow(() -> new UserNotFoundException("User not found by loginName"));
    }

    public List<UserToHc> findAll() {
        return (List<UserToHc>) userHcRepository.findAll();
    }

    public UserToHc addNewUser(UserToHc userToHc) {
        String passwordBcrypt = passwordEncoder.encode(userToHc.getPassword());
        userToHc.setPassword(passwordBcrypt);
        return userHcRepository.save(userToHc);
    }

    public UserToHc updateUser(UserToHc userToHc) {
        return userHcRepository.save(userToHc);
    }

    public void deleteUser(Long index) {
        userHcRepository.deleteById(index);
    }


}
