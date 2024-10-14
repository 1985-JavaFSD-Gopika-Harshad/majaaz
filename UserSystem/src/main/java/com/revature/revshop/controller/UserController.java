package com.revature.revshop.controller;

import com.revature.revshop.dto.UserDTO;
import com.revature.revshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUser = userService.saveUser(userDTO);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/exists")
    public ResponseEntity<String> checkUsername(@RequestParam String username) {
        if (userService.checkIfExists(username)) {
            return ResponseEntity.ok("Username exists.");
        } else {
            return ResponseEntity.badRequest().body("Username not found.");
        }
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeUsername(@RequestParam String username) {
        try {
            userService.removeUser(username);
            return ResponseEntity.ok("Username removed successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
