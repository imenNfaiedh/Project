package com.example.auth.service;

import com.example.auth.dto.PageResponse;
import com.example.auth.dto.UserDto;
import com.example.auth.entities.User;
import org.springframework.data.domain.*;

import java.util.List;

public interface IUserService {

     PageResponse<UserDto> getAllUser(Pageable pageable);
}
