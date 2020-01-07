package com.CezaryZal.manager.db.service;

import com.CezaryZal.entity.UserToHc;
import com.CezaryZal.exceptions.UserNotFoundException;
import com.CezaryZal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserToHc findById(Long index) {
        return userRepository.findById(index)
                .orElseThrow(() -> new UserNotFoundException("User not found by id"));
    }

    public UserToHc findByLoginName(String loginName) {
        return userRepository.findByLoginName(loginName)
                .orElseThrow(() -> new UserNotFoundException("User not found by loginName"));
    }

    public List<UserToHc> findAll() {
        return (List<UserToHc>) userRepository.findAll();
    }

    public UserToHc addNewUser(UserToHc userToHc) {
        String passwordBcrypt = passwordEncoder.encode(userToHc.getPassword());
        userToHc.setPassword(passwordBcrypt);
        return userRepository.save(userToHc);
    }

    public UserToHc updateUser(UserToHc userToHc) {
        return userRepository.save(userToHc);
    }

    public void deleteUser(Long index) {
        userRepository.deleteById(index);
    }


}
