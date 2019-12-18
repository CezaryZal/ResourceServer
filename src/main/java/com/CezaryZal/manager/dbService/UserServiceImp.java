package com.CezaryZal.manager.dbService;

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

    public Optional<User> findById(Long index) {
        return userRepository.findById(index);
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
