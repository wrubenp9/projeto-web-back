package com.br.userservice.controller;

import com.br.userservice.controller.dto.UserDto;
import com.br.userservice.controller.request.UserRequest;
import com.br.userservice.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserCreateUseCaseImpl userCreateUseCase;
    private final UserUpdateUseCaseImpl userUpdateUseCase;
    private final UserSearchUseCaseImpl userSearchUseCase;
    private final UserDeleteUseCaseImpl userDeleteUseCase;

    @GetMapping("/user/{id}")
    public UserDto findById(@PathVariable UUID id) {
        return userSearchUseCase.findById(id);
    }

    @GetMapping("/user/all")
    public List<UserDto> userAll() {
        return userSearchUseCase.findAll();
    }

    @PostMapping("/user/create")
    public void userCreate(@RequestBody UserRequest request) {
        userCreateUseCase.execute(request);
    }

    @PutMapping("/user/update/{id}")
    public void userUpdate(@PathVariable UUID id, @RequestBody UserRequest request) {
        userUpdateUseCase.execute(id, request);
    }
    @DeleteMapping("/user/delete/{id}")
    public void userDelete(@PathVariable UUID id){
        userDeleteUseCase.execute(id);
    }
}
