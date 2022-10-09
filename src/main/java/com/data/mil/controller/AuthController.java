package com.data.mil.controller;

import com.data.mil.dto.LoginDTO;
import com.data.mil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDTO loginRequest) {
        return ResponseEntity.ok(userService.signin(loginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserProfileDTO> registerUser(@RequestBody UserCreateDTO signUpRequest) {
        return  ResponseEntity.ok( userService.createUser(signUpRequest));
    }
}