package com.CezaryZal.manager.db.service;

import com.CezaryZal.entity.User;
import com.CezaryZal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long index) throws NameNotFoundException {
        return userRepository.findById(index)
                .orElseThrow(() -> new NameNotFoundException("The User sought does not exist"));
    }

    public User findByLoginName(String loginName) throws NameNotFoundException {
        return userRepository.findByLoginName(loginName)
                .orElseThrow(() -> new NameNotFoundException("The User sought does not exist"));
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
