
package com.onlinecourse.coursemanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinecourse.coursemanagement.entity.User;
import com.onlinecourse.coursemanagement.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException(
                        "User not found with id: " + id));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException(
                "User not found with id: " + id);
        }

        userRepository.deleteById(id);
    }
}
