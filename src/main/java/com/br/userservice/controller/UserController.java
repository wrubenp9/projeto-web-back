package com.br.userservice.controller;

import com.br.userservice.controller.dto.UserDto;
import com.br.userservice.controller.request.UserLoginRequest;
import com.br.userservice.controller.request.UserRequest;
import com.br.userservice.model.User;
import com.br.userservice.repository.UserRepository;
import com.br.userservice.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserCreateUseCaseImpl userCreateUseCase;
    private final UserUpdateUseCaseImpl userUpdateUseCase;
    private final UserSearchUseCaseImpl userSearchUseCase;
    private final UserDeleteUseCaseImpl userDeleteUseCase;
    private final UserLoginImpl userLogin;

    @GetMapping("/user/all")
    public List<UserDto> user() {
        return userSearchUseCase.findAll();
    }

    @PostMapping("/user/create")
    public void userCreate(@RequestBody UserRequest request) {
        userCreateUseCase.execute(request);
    }

    @PutMapping("/user/{id}/update")
    public void userUpdate(@PathVariable UUID id, @RequestParam UUID idUserLogin, @RequestBody UserRequest request) {
        userUpdateUseCase.execute(idUserLogin, id, request);
    }

    @DeleteMapping("/user/delete")
    public void userDelete(@RequestParam UUID id){
        userDeleteUseCase.execute(id);
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody UserLoginRequest request) {
        return userLogin.execute(request);
    }
}
