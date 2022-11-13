package com.data.mil.controller;

import com.data.mil.dto.user.UserCreateDTO;
import com.data.mil.dto.user.UserEditDTO;
import com.data.mil.dto.user.UserProfileDTO;
import com.data.mil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<UserProfileDTO> create(@RequestBody UserCreateDTO userCreateDTO)
    {
        return ResponseEntity.ok( userService.create(userCreateDTO) );
    }

    @GetMapping("/")
    public ResponseEntity<UserProfileDTO> getCurrentUser(){
        return ResponseEntity.ok( userService.getCurrentUser() );
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserProfileDTO>> getAllPatient(){
        return ResponseEntity.ok( userService.getAllPatient() );
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('medic','admin')")
    public ResponseEntity<UserProfileDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok( userService.getUserById(id) );
    }

    @PutMapping("/")
    public ResponseEntity<UserProfileDTO> update(UserEditDTO userEditDTO) {
        return ResponseEntity.ok( userService.updateCurrentUser(userEditDTO) );
    }

}
