package com.example.auth.mapper;

import com.example.auth.dto.UserDto;
import com.example.auth.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface IUserMapper {
    UserDto toDto (User user);
    List<UserDto> toDtoList (List<User>users);
    User toEntity (UserDto userDto);
}
