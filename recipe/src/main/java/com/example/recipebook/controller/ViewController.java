package com.example.recipebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	 @GetMapping("/index")
	    public String index() {
	    	System.out.println("index");
	            return "index";  
	    }
	 @GetMapping("/login")
	    public String login() {
	    	System.out.println("login");
	            return "login";  
	    }
	 @GetMapping("/register")
	    public String register() {
	    	System.out.println("register");
	            return "register";  
	    }
	 @GetMapping("/recipes")
	    public String recipes() {
	    	System.out.println("recipes");
	            return "recipes";  
	    }

}
