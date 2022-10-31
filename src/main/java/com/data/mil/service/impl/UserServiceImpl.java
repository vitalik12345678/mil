package com.data.mil.service.impl;


import com.data.mil.dto.CreateUserDTO;
import com.data.mil.dto.JwtDTO;
import com.data.mil.dto.LoginDTO;
import com.data.mil.dto.UserProfileDTO;


import com.data.mil.enums.GenderEnum;
import com.data.mil.exception.AlreadyExistsException;
import com.data.mil.exception.NotExistsException;
import com.data.mil.model.*;
import com.data.mil.model_mapper.CustomModelMapper;
import com.data.mil.repository.AllergicReactionRepository;
import com.data.mil.repository.RoleRepository;
import com.data.mil.repository.UserRepository;

import com.data.mil.security.jwt.JwtUtils;
import com.data.mil.security.jwt.UserDetailsImpl;
import com.data.mil.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticateManager;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AllergicReactionRepository allergicReactionRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomModelMapper customModelMapper;
    private static final String USER_EXIST = "User with same phone %s or email %s already exists ";
    private static final String ROLE_NOT_EXIST = "Role doesn't exist";
    private static final String USER = "user";

    @Autowired
    public UserServiceImpl(AuthenticationManager authenticateManager, JwtUtils jwtUtils, UserRepository userRepository, RoleRepository roleRepository, AllergicReactionRepository allergicReactionRepository, PasswordEncoder passwordEncoder, CustomModelMapper customModelMapper) {
        this.authenticateManager = authenticateManager;
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.allergicReactionRepository = allergicReactionRepository;
        this.passwordEncoder = passwordEncoder;
        this.customModelMapper = customModelMapper;
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
        if (userRepository.existsByEmailOrPhoneNumber(createUserDTO.getEmail(),createUserDTO.getPhoneNumber())){
            throw new AlreadyExistsException(String.format(USER_EXIST,createUserDTO.getPhoneNumber(),createUserDTO.getEmail()));
        }

        User user = customModelMapper.convertToEntity(createUserDTO,new User());
        user.setRole(findRoleByName(USER));
        List<AllergicReaction> allergicReactionList = createUserDTO.getAllergicReactionDTO()
                .stream()
                .map( allergicReactionDTO -> {
                  AllergicReaction allergicReaction = customModelMapper.convertToEntity(allergicReactionDTO, new AllergicReaction());
                  allergicReaction.setUser(user);
                  return allergicReaction;
                }).collect(Collectors.toList());
        List<Holes> holesList = createUserDTO.getHolesDTO()
                .stream()
                .map( holesDTO -> {
                   Holes hole =  customModelMapper.convertToEntity(holesDTO, new Holes());
                   hole.setUser(user);
                   return hole;
                }).collect(Collectors.toList());
        List<ChronicleDisease> chronicleDiseaseList = createUserDTO.getChronicleDTO()
                .stream()
                        .map( chronicleDTO -> {
                          ChronicleDisease chronicleDisease =  customModelMapper.convertToEntity(chronicleDTO, new ChronicleDisease());
                          chronicleDisease.setUser(user);
                          return chronicleDisease;
                        }).collect(Collectors.toList());
        user.setAllergicReactionList(allergicReactionList);
        user.setHoleList(holesList);
        user.setChronicleDiseaseList(chronicleDiseaseList);
        userRepository.save(user);

        return customModelMapper.convertToDTO(user,new UserProfileDTO());
    }

    @Override
    @Transactional
    public String get() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Long lon = new Long(67);
        User user = userRepository.findById(lon).orElseThrow( () ->{throw new RuntimeException("USERBAD");});
      /*  Role role = roleRepository.findById(6L).orElseThrow();
        System.out.println( user.getRole().getName() );
        System.out.println(role.getName());

        AllergicReaction allergicReaction = allergicReactionRepository.findByName("dasd").orElseThrow();
        System.out.println(allergicReaction.getId());
        user.setRole(role);

        user.getAllergicReactionList().forEach(x->{
            System.out.println(x.getId());
        });*/
        return user.getPhoneNumber();
    }

    private Role findRoleByName(String name){
        return roleRepository.findByName(name).orElseThrow(() ->{ throw new NotExistsException(ROLE_NOT_EXIST);});
    }
}
