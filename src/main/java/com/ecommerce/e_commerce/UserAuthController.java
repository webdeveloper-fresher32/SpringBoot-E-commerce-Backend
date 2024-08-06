package com.ecommerce.e_commerce;


import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@Validated
public class UserAuthController {
    private static final Logger logger = LoggerFactory.getLogger(UserAuthController.class);

    @Autowired
    private UserService service;

    @GetMapping("/")
    public  String greet(){
        return  "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserModel user) {
        logger.info("Registering user: {}", user);
        if (service.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body("username already exits");
        }
        if (service.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("email already exits");
        }
        service.saveUser(user);
        return ResponseEntity.ok("User register successfully");
    }


    @PostMapping(value = "/login",consumes = "application/json",produces = "application/json")
    public ResponseEntity<?> loginUser(@RequestBody UserModel user) {
        logger.info("Attempting login for email: {}", user.getEmail());

        Optional<UserModel> userOptional = service.findByEmail(user.getEmail());

        if (userOptional.isPresent() && user.getPassword().equals(userOptional.get().getPassword())) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.badRequest().body("Invalid email or password");
    }

}
