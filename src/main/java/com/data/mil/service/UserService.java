package com.data.mil.service;


import com.data.mil.dto.CreateUserDTO;
import com.data.mil.dto.JwtDTO;
import com.data.mil.dto.LoginDTO;
import com.data.mil.dto.UserProfileDTO;
import com.data.mil.model.User;

public interface UserService {

    UserProfileDTO create(CreateUserDTO createUserDTO);

    String get();

    JwtDTO signin(LoginDTO loginDTO);

}
