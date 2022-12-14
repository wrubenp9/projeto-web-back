package com.br.userservice.usecase;

import com.br.userservice.controller.request.UserRequest;
import com.br.userservice.model.User;
import com.br.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserUpdateUseCaseImpl implements UserUpdateUseCase {

    private final UserRepository userRepository;


    @Override
    public void execute(UUID id, UserRequest request) {

        Optional<User> user = userRepository.findById(id);

        try {
            if (user.isPresent()) {

                var userEntity = user.get();

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
