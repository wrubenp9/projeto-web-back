package com.br.userservice.usecase;

import com.br.userservice.controller.dto.UserDto;

import java.util.List;

public interface UserSearchUseCase {

    List<UserDto> findAll();
}
