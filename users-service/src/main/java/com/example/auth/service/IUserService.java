package com.example.auth.service;

import com.example.auth.dto.UserDto;
import com.example.auth.entities.User;

import java.util.List;

public interface IUserService {
    public List<User> allUsers();

    public List<UserDto> getAllUser();
}
