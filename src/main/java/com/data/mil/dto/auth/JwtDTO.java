package com.data.mil.dto.auth;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;


import java.util.List;

@Getter
@Setter
public class JwtDTO{

    private String token;
    private String firstName;
    private String lastName;
    private List<GrantedAuthority> role;

}
