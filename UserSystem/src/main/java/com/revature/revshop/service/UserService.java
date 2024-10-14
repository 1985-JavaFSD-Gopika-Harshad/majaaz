package com.revature.revshop.service;

import com.revature.revshop.dto.UserDTO;
import com.revature.revshop.model.User;
import com.revature.revshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


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

    
    public boolean checkIfExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public void removeUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            userRepository.deleteByUsername(username);
        } else {
            throw new RuntimeException("Username not found");
        }
    }
}
