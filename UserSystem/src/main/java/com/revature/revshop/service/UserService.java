package com.revature.revshop.service;

import com.revature.revshop.dto.UserDTO;
import com.revature.revshop.model.User;
import com.revature.revshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Save or add a new user
    public UserDTO saveUser(UserDTO userDTO) {
        Optional<User> existingUser = userRepository.findByUsername(userDTO.getUsername());

        User user;
        if (existingUser.isPresent()) {
            user = existingUser.get();
            user.setUsername(userDTO.getUsername());
        } else {
            user = new User(userDTO.getUsername());
        }

        User savedUser = userRepository.save(user);
        return new UserDTO(savedUser.getId(), savedUser.getUsername());
    }

    // Update an existing user by ID
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUsername(userDTO.getUsername());

            User updatedUser = userRepository.save(user);
            return new UserDTO(updatedUser.getId(), updatedUser.getUsername());
        } else {
            throw new RuntimeException("User with ID " + id + " not found");
        }
    }

    // Get all users
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserDTO(user.getId(), user.getUsername()))
                .collect(Collectors.toList());
    }

    // Delete a user by ID
    public void deleteUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User with ID " + id + " not found");
        }
    }

    // Check if username exists
    public boolean checkIfExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    // Remove a user by username
    public void removeUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            userRepository.deleteByUsername(username);
        } else {
            throw new RuntimeException("Username not found");
        }
    }
}
