package com.br.userservice.usecase;

import com.br.userservice.controller.dto.UserDto;
import com.br.userservice.controller.mapper.UserMapper;
import com.br.userservice.model.User;
import com.br.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserSearchUseCaseImpl implements UserSearchUseCase {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> findAll() {
        return UserMapper.toListDto(userRepository.findAll());
    }

    @Override
    public UserDto findById(UUID id) {
        var user = userRepository.findById(id);

        return user.map(UserMapper::toDto).orElse(null);
    }
}
