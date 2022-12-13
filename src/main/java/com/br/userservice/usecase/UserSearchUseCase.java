package com.br.userservice.usecase;

import com.br.userservice.controller.dto.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserSearchUseCase {

    List<UserDto> findAll();

    UserDto findById(UUID id);
}
