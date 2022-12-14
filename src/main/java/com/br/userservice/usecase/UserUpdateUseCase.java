package com.br.userservice.usecase;

import com.br.userservice.controller.request.UserRequest;

import java.util.UUID;

public interface UserUpdateUseCase {
    void execute(UUID id, UserRequest request);
}
