package com.CezaryZal.manager.db.service;

import com.CezaryZal.entity.User;
import com.CezaryZal.exceptions.IncorrectLoginOrPasswordSecurityException;
import com.CezaryZal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long index) {
        return userRepository.findById(index)
                .orElseThrow(() -> new IncorrectLoginOrPasswordSecurityException("Login or password incorrectly entered"));
    }

    public User findByLoginName(String loginName) {
        return userRepository.findByLoginName(loginName)
                .orElseThrow(() -> new IncorrectLoginOrPasswordSecurityException("Login or password incorrectly entered"));
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long index) {
        userRepository.deleteById(index);
    }
}
