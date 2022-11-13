package com.data.mil.service.impl;


import com.data.mil.dto.user.UserCreateDTO;
import com.data.mil.dto.auth.JwtDTO;
import com.data.mil.dto.auth.LoginDTO;
import com.data.mil.dto.user.UserEditDTO;
import com.data.mil.dto.user.UserProfileDTO;


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
    private static final String USER_NOT_EXISTS = "User doesn't exist";
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
    @Transactional
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

    @Override
    @Transactional(readOnly = true)
    public List<UserProfileDTO> getAllPatient() {
        return userRepository.findAllByRole(findRoleByName(USER))
                .stream()
                .map(user -> {
                    UserProfileDTO userProfileDTO = customModelMapper.convertToDTO(user, new UserProfileDTO());
                    userProfileDTO.setRole(user.getRole().getName());
                    return userProfileDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserProfileDTO updateCurrentUser(UserEditDTO userEditDTO) {

        return null;
    }

    //TODO: зберегти юзера алергію хронікал і holes та зберегти вагу
    @Override
    @Transactional
    public UserProfileDTO create(UserCreateDTO userCreateDTO)
    {
        if (userRepository.existsByEmailOrPhoneNumber(userCreateDTO.getEmail(), userCreateDTO.getPhoneNumber())){
            throw new AlreadyExistsException(String.format(USER_EXIST, userCreateDTO.getPhoneNumber(), userCreateDTO.getEmail()));
        }

        User user = customModelMapper.convertToEntity(userCreateDTO,new User());
        user.setRole(findRoleByName(USER));
        user.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        List<AllergicReaction> allergicReactionList = userCreateDTO.getAllergicReactionDTO()
                .stream()
                .map( allergicReactionDTO -> {
                  AllergicReaction allergicReaction = customModelMapper.convertToEntity(allergicReactionDTO, new AllergicReaction());
                  allergicReaction.setUser(user);
                  return allergicReaction;
                }).collect(Collectors.toList());
        List<Holes> holesList = userCreateDTO.getHolesDTO()
                .stream()
                .map( holesDTO -> {
                   Holes hole =  customModelMapper.convertToEntity(holesDTO, new Holes());
                   hole.setUser(user);
                   return hole;
                }).collect(Collectors.toList());
        List<ChronicleDisease> chronicleDiseaseList = userCreateDTO.getChronicleDTO()
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
    @Transactional(readOnly = true)
    public UserProfileDTO getCurrentUser() {

        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = findUserById(userDetails.getId());
        UserProfileDTO userProfileDTO = customModelMapper.convertToDTO(user, new UserProfileDTO());
        userProfileDTO.setRole(user.getRole().getName());
        return userProfileDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public UserProfileDTO getUserById(Long id) {
        User user = findUserById(id);
        UserProfileDTO userProfileDTO = customModelMapper.convertToDTO( user , new UserProfileDTO() );
        userProfileDTO.setRole(user.getRole().getName());
        return userProfileDTO;
    }

    private Role findRoleByName(String name){
        return roleRepository.findByName(name).orElseThrow(() ->{ throw new NotExistsException(ROLE_NOT_EXIST);});
    }

    private User findUserById(Long id){
        return userRepository.findById(id).orElseThrow( () -> {throw new NotExistsException(USER_NOT_EXISTS);});
    }
}
