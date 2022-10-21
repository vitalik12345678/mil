package com.data.mil.service.impl;


import com.data.mil.dto.CreateUserDTO;
import com.data.mil.dto.JwtDTO;
import com.data.mil.dto.LoginDTO;
import com.data.mil.dto.UserProfileDTO;


import com.data.mil.model.User;
import com.data.mil.repository.AllergicReactionRepository;
import com.data.mil.repository.RoleRepository;
import com.data.mil.repository.UserRepository;

import com.data.mil.security.jwt.JwtUtils;
import com.data.mil.security.jwt.UserDetailsImpl;
import com.data.mil.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticateManager;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AllergicReactionRepository allergicReactionRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(AuthenticationManager authenticateManager, JwtUtils jwtUtils, UserRepository userRepository, RoleRepository roleRepository, AllergicReactionRepository allergicReactionRepository, PasswordEncoder passwordEncoder) {
        this.authenticateManager = authenticateManager;
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.allergicReactionRepository = allergicReactionRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public JwtDTO signin(LoginDTO loginDTO) {
        Authentication  authentication = authenticateManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);


        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        JwtDTO jwtDTO = new JwtDTO();
        jwtDTO.setLastName(userDetails.getLastName());
        jwtDTO.setToken(jwtUtils.generateJwtToken(authentication));
        jwtDTO.setFirstName(userDetails.getFirstName());
        jwtDTO.setRole(new ArrayList<>(userDetails.getAuthorities()));
        return jwtDTO;
    }

    //TODO: зберегти юзера алергію хронікал і holes та зберегти вагу
    @Override
    @Transactional
    public UserProfileDTO create(CreateUserDTO createUserDTO)
    {
        User user = new User();
       /* BeanUtils.copyProperties(createUserDTO, user);
        UserProFileDTO userProFileDTO = new UserProFileDTO();
        BeanUtils.copyProperties(user, userProFileDTO);
        user.setHeight(createUserDTO.getHeight());
        user.setPhoneNumber(createUserDTO.getPhoneNumber());
        Role role = new Role();
        role.setId(1l);
        role.setName("ROLE_USER");
        user.setRole(role);*/
        userRepository.save(user);
        return null;
    }

    @Override
    @Transactional
    public User get() {

       /* User user = userRepository.findById(66L).orElseThrow();
        Role DROleEntity = roleRepository.findByName("ROLE_USER").orElseThrow();
        Role role = roleRepository.findById(6L).orElseThrow();
        System.out.println( user.getRoles().getName() );
        System.out.println(role.getName());

        AllergicReaction allergicReaction = allergicReactionRepository.findByName("dasd").orElseThrow();
        System.out.println(allergicReaction.getId());
        user.setRoles(role);

        user.getAllergicReactionList().forEach(x->{
            System.out.println(x.getId());
        });*/
        return null;
    }
}
