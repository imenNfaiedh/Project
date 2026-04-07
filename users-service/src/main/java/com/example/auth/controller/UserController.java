package com.example.auth.controller;

import com.example.auth.dto.PageResponse;
import com.example.auth.dto.UserDto;
import com.example.auth.entities.User;
import com.example.auth.mapper.IUserMapper;
import com.example.auth.service.serviceImpl.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;
    private final IUserMapper userMapper;

    public UserController(UserService userService, IUserMapper userMapper) {
        this.userService = userService;
        this.userMapper =  userMapper;
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        UserDto userDto = userMapper.toDto(currentUser);

        return ResponseEntity.ok(userDto);
    }

    @GetMapping("")
    public ResponseEntity<PageResponse<UserDto>> getAllUser(Pageable pageable) {
        return ResponseEntity.ok(userService.getAllUser(pageable));
    }
}
