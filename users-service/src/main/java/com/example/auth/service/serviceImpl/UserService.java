package com.example.auth.service.serviceImpl;

import com.example.auth.Repository.IUserRepository;
import com.example.auth.dto.UserDto;
import com.example.auth.entities.User;
import com.example.auth.mapper.IUserMapper;
import com.example.auth.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final IUserMapper userMapper;

    public UserService(IUserRepository userRepository, IUserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper=userMapper;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        return userMapper.toDtoList(users);
    }
}
