package com.data.mil.controller;

import com.data.mil.dto.auth.JwtDTO;
import com.data.mil.dto.auth.LoginDTO;
import com.data.mil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/")
    public JwtDTO finduser(@RequestBody LoginDTO loginDTO){
        return userService.signin(loginDTO);
    }

/*    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDTO loginRequest) {
        return ResponseEntity.ok(userService.signin(loginRequest));
    }*/

}