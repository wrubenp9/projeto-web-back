package com.br.userservice.controller;

import com.br.userservice.controller.dto.UserDto;
import com.br.userservice.controller.request.UserLoginRequest;
import com.br.userservice.controller.request.UserRequest;
import com.br.userservice.model.User;
import com.br.userservice.repository.UserRepository;
import com.br.userservice.usecase.UserCreateUseCaseImpl;
import com.br.userservice.usecase.UserLoginImpl;
import com.br.userservice.usecase.UserSearchUseCaseImpl;
import com.br.userservice.usecase.UserUpdateUseCaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private final UserCreateUseCaseImpl userCreateUseCase;
    private final UserUpdateUseCaseImpl userUpdateUseCase;
    private final UserSearchUseCaseImpl userSearchUseCase;
    private final UserLoginImpl userLogin;

    @GetMapping("/user/all")
    public List<UserDto> user() {
        return userSearchUseCase.findAll();
    }

    @GetMapping("/user/one")
    public Optional<User> userOne(@RequestParam Integer id) {
        return userRepository.findById(id);
    }

    @PostMapping("/user/create")
    public void userCreate(@RequestBody UserRequest request) {
        userCreateUseCase.execute(request);
    }

    @PutMapping("/user/{id}/update")
    public void userCreate(@PathVariable Integer id, @RequestParam Integer idUserLogin, @RequestBody UserRequest request) {
        userUpdateUseCase.execute(idUserLogin, id, request);
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody UserLoginRequest request) {
        return userLogin.execute(request);
    }
}