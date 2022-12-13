package com.br.userservice.usecase;

import com.br.userservice.controller.request.UserRequest;
import com.br.userservice.model.User;
import com.br.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserCreateUseCaseImpl implements UserCreateUseCase {

    private final UserRepository userRepository;

    @Override
    public void execute(UserRequest request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        try {
            if (user.isEmpty()) {
                User userEntity = new User();

                userEntity.setNome(request.getNome());
                userEntity.setSobrenome(request.getSobrenome());
                userEntity.setEmail(request.getEmail());
                userEntity.setSenha(request.getSenha());
                userEntity.setType(request.getType());

                userRepository.save(userEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
