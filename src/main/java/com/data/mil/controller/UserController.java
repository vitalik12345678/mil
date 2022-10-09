package com.data.mil.controller;

import com.data.mil.dto.CreateUserDTO;
import com.data.mil.dto.UserProFileDTO;
import com.data.mil.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
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
    public UserProFileDTO create(@RequestBody CreateUserDTO createUserDTO)
    {
        return userService.create(createUserDTO);
    }
}
