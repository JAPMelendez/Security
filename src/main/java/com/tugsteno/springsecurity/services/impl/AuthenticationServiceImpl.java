package com.tugsteno.springsecurity.services.impl;

import com.tugsteno.springsecurity.dto.SignUpRequest;
import com.tugsteno.springsecurity.entities.Role;
import com.tugsteno.springsecurity.entities.User;
import com.tugsteno.springsecurity.repository.UserRepository;
import com.tugsteno.springsecurity.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User signup(SignUpRequest signUpRequest){

        User user = new User();

        user.setEmail(signUpRequest.getEmail());
        user.setFirstName(signUpRequest.getFirstName());
        user.setSecondName(signUpRequest.getSecondName());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(user);
    }
}
