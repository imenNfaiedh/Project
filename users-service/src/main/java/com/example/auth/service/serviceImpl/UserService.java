package com.example.auth.service.serviceImpl;

import com.example.auth.Repository.IUserRepository;
import com.example.auth.dto.PageResponse;
import com.example.auth.dto.UserDto;
import com.example.auth.entities.User;
import com.example.auth.mapper.IUserMapper;
import com.example.auth.service.IUserService;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.*;
import java.util.List;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final IUserMapper userMapper;

    public UserService(IUserRepository userRepository, IUserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper=userMapper;
    }


    @Override
    public PageResponse<UserDto> getAllUser(Pageable pageable) {
        Page<UserDto> page = userRepository.findAll(pageable)
                .map(userMapper::toDto);

        return new PageResponse<>(page);
    }
}
