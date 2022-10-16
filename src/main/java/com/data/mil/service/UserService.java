package com.data.mil.service;


import com.data.mil.dto.CreateUserDTO;
import com.data.mil.dto.LoginDTO;
import com.data.mil.dto.UserProFileDTO;
import com.data.mil.model.User;

public interface UserService {

 /*   String signin(LoginDTO loginDTO);*/

    UserProFileDTO create(CreateUserDTO createUserDTO);

    User get();

}
