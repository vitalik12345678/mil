package com.data.mil.security.jwt;

import com.data.mil.exception.NotExistsException;
import com.data.mil.model.User;
import com.data.mil.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private static final String USER_DONT_FIND = "User didn't found ";

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow( () -> {
            throw new NotExistsException(USER_DONT_FIND + username); //TODO: Change exception
        });
        return UserDetailsImpl.build(user);
    }
}
