package com.tugsteno.springsecurity.services;

import com.tugsteno.springsecurity.dto.SignUpRequest;
import com.tugsteno.springsecurity.entities.User;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest);
}
