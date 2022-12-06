package com.br.userservice.usecase;

import com.br.userservice.controller.request.UserRequest;

public interface UserCreateUseCase {
    void execute(UserRequest request);
}
