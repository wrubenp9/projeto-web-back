package com.br.userservice.usecase;

import com.br.userservice.controller.request.UserRequest;
import com.br.userservice.model.User;
import com.br.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserUpdateUseCaseImpl implements UserUpdateUseCase {

    private final UserRepository userRepository;


    @Override
    public void execute(Integer idUserLogin, Integer id, UserRequest request) {

        Optional<User> user = userRepository.findById(id);
        Optional<User> userLogin = userRepository.findById(idUserLogin);

        try {
            if (user.isPresent() && userLogin.isPresent()) {

                var userEntity = user.get();
                if (Objects.equals(userLogin.get().getTipo(), "admin")) {
                    userEntity.setNome(request.getNome());
                    userEntity.setSobrenome(request.getSobrenome());
                    userEntity.setEmail(request.getEmail());
                    userEntity.setSenha(request.getSenha());
                    userEntity.setTipo(request.getTipo());

                } else {
                    userEntity.setNome(request.getNome());
                    userEntity.setSobrenome(request.getSobrenome());
                    userEntity.setSenha(request.getSenha());
                }

                userRepository.save(userEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
