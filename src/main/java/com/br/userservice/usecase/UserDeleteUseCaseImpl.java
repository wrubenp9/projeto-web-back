package com.br.userservice.usecase;

import com.br.userservice.model.User;
import com.br.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDeleteUseCaseImpl implements UserDeleteUseCase {

    private final UserRepository userRepository;

    @Override
    public void execute(Integer id) {
        var user = userRepository.findById(id);
        try {
            if (user.isPresent()) {
                User userEntity = user.get();
                userRepository.deleteById(userEntity.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
