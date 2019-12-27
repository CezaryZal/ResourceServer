package com.CezaryZal.manager.db.service;

import com.CezaryZal.entity.User;
import com.CezaryZal.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long index) {
        return userRepository.findById(index)
                .orElseThrow(() -> new RuntimeException("Poszukiwany użtykownik nie istnieje"));
    }

    public User findByLoginName(String loginName){
        return userRepository.findByLoginName(loginName)
                .orElseThrow(() -> new RuntimeException("Poszukiwany użtykownik nie istnieje"));
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
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
