package com.br.userservice.usecase;

import com.br.userservice.controller.dto.UserDto;
import com.br.userservice.controller.request.UserLoginRequest;

public interface UserLogin {
    UserDto execute(UserLoginRequest request);
}
