package com.tugsteno.springsecurity.dto;

import lombok.Data;

@Data
public class SignUpRequest {

    private String firstName;

    private String secondName;

    private String email;

    private String password;
}
