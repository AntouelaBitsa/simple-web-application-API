package com.simple.web.application.SimpleWebApplicationAPI.Controller;

import com.simple.web.application.SimpleWebApplicationAPI.Entity.Users;
import com.simple.web.application.SimpleWebApplicationAPI.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    @Autowired
    private UsersService userService;

    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody Users user){
        String successMessage = null;
        String errorMessage = null;

        try{
            System.out.println("[Controller - Debug01: registerUser()]: " + user.toString());
            Users registeredUser = userService.registerUser(user);
            successMessage = "User Registered successfully with ID: " + registeredUser.getUserID();
            return new ResponseEntity<>(successMessage, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("[Controller - Debug03: registerUser()]: " + e.getMessage());
            errorMessage = "Error occurred while registering user: " + e.getMessage();
            return new ResponseEntity<>(successMessage, HttpStatus.OK);
        }

    }
}
