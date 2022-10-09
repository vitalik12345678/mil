package com.data.mil.service.impl;


import com.data.mil.dto.CreateUserDTO;
import com.data.mil.dto.LoginDTO;
import com.data.mil.dto.UserProFileDTO;
import com.data.mil.model.Role;
import com.data.mil.model.User;
import com.data.mil.repository.UserRepository;
import com.data.mil.security.jwt.JwtUtils;
import com.data.mil.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticateManager;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;

    public UserServiceImpl(AuthenticationManager authenticate, JwtUtils jwtUtils, UserRepository userRepository) {
        this.authenticateManager = authenticate;
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
    }


    @Override
    public String signin(LoginDTO loginDTO) {
        Authentication authentication = authenticateManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
       // List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return jwtUtils.generateJwtToken(authentication);
    }

    //TODO: зберегти юзера алергію хронікал і holes та зберегти вагу
    @Override
    public UserProFileDTO create(CreateUserDTO createUserDTO)
    {
        User user = new User();
        BeanUtils.copyProperties(createUserDTO, user);
        UserProFileDTO userProFileDTO = new UserProFileDTO();
        BeanUtils.copyProperties(user, userProFileDTO);
        user.setHeight(createUserDTO.getHeight());
        user.setPhoneNumber(createUserDTO.getPhoneNumber());
        Role role = new Role();
        role.setId(1l);
        role.setName("ROLE_USER");
        user.setRole(role);
        userRepository.save(user);
        return userProFileDTO;
    }
}
