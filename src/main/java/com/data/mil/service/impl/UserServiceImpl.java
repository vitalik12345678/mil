package com.data.mil.service.impl;

import com.data.mil.dto.LoginDTO;
import com.data.mil.security.jwt.JwtUtils;
import com.data.mil.security.jwt.UserDetailsImpl;
import com.data.mil.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticateManager;
    private final JwtUtils jwtUtils;

    public UserServiceImpl(AuthenticationManager authenticate, JwtUtils jwtUtils) {
        this.authenticateManager = authenticate;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public String signin(LoginDTO loginDTO) {
        Authentication authentication = authenticateManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
       // List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return jwtUtils.generateJwtToken(authentication);
    }
}
