package com.br.userservice.controller.mapper;

import com.br.userservice.controller.dto.UserDto;
import com.br.userservice.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

@Component
public class UserMapper {
    public static UserDto toDto(User user) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(user, UserDto.class);
    }

    public static List<UserDto> toListDto(List<User> users) {
        return users.stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

}
