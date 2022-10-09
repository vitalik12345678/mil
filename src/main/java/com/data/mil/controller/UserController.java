package com.data.mil.controller;

import com.data.mil.dto.CreateUserDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @RequestMapping("/")
    public void create(@RequestBody CreateUserDTO createUserDTO)
    {

    }
}
