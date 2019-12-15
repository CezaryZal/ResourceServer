package com.CezaryZal.manager.service;

import com.CezaryZal.entity.User;
import com.CezaryZal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(Long index) {
        return userRepository.findById(index);
    }
}
