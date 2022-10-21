package com.data.mil.controller;

import com.data.mil.dto.CreateUserDTO;
import com.data.mil.dto.UserProfileDTO;
import com.data.mil.model.User;
import com.data.mil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    @PreAuthorize("hasAnyRole('medic','admin')")
    public String create(@RequestBody CreateUserDTO createUserDTO)
    {
        return userService.get();
    }
}
