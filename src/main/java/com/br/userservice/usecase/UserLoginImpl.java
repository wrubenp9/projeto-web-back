package com.br.userservice.usecase;

import com.br.userservice.controller.dto.UserDto;
import com.br.userservice.controller.mapper.UserMapper;
import com.br.userservice.controller.request.UserLoginRequest;
import com.br.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserLoginImpl implements UserLogin{

    private final UserRepository userRepository;
    @Override
    public UserDto execute(UserLoginRequest request) {
        var user = userRepository.findByEmail(request.getEmail());

        try {
            if (user.isPresent()) {
                if (Objects.equals(user.get().getSenha(), request.getSenha())) {
                    var userEntity = user.get();
                    return UserMapper.toDto(userEntity);
                } else {
                    //todo - exception
                    System.out.println("Senha invalida");
                }
            } else {
                //todo - exception
                System.out.println("Não existe usuário com esse email");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
