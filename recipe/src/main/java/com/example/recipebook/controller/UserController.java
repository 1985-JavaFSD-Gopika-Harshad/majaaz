package com.example.recipebook.controller;

import com.example.recipebook.model.User;
import com.example.recipebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Handle user login
    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        Optional<User> user = userService.loginUser(username, password);
        if (user.isPresent()) {
            session.setAttribute("loggedInUser", user.get());
            return "redirect:/recipes"; // Redirect to the recipes page after successful login
        } else {
            model.addAttribute("error", "Invalid username or password"); // Set error message for login failure
            return "login"; // Return to the login page
        }
    }

    // Handle user registration
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        if (userService.findUserByUsername(user.getUsername()).isPresent()) {
            model.addAttribute("error", "Username already exists"); // Set error message if username exists
            return "register"; // Return to the registration page
        }
        userService.registerUser(user); // Register the new user
        return "redirect:/login"; // Redirect to the login page after successful registration
    }

    // Handle user logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidate the session to log out the user
        return "redirect:/login"; // Redirect to the login page after logout
    }
}
