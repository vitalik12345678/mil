package com.data.mil.service;


import com.data.mil.dto.user.UserCreateDTO;
import com.data.mil.dto.auth.JwtDTO;
import com.data.mil.dto.auth.LoginDTO;
import com.data.mil.dto.user.UserEditDTO;
import com.data.mil.dto.user.UserProfileDTO;

import java.util.List;

public interface UserService {

    UserProfileDTO create(UserCreateDTO userCreateDTO);
    UserProfileDTO getCurrentUser();
    UserProfileDTO getUserById(Long id);

    JwtDTO signin(LoginDTO loginDTO);

    List<UserProfileDTO> getAllPatient();

    UserProfileDTO updateCurrentUser(UserEditDTO userEditDTO);
}
