package com.example.auth.service;

import com.example.auth.dto.LoginUserDto;
import com.example.auth.dto.RegisterUserDto;
import com.example.auth.entities.User;

public interface IAuthenticationService {
    User signup(RegisterUserDto registerUserDto);
    User authenticate(LoginUserDto loginUserDto);
}

