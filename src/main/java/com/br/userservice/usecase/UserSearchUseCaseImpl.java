package com.br.userservice.usecase;

import com.br.userservice.controller.dto.UserDto;
import com.br.userservice.controller.mapper.UserMapper;
import com.br.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSearchUseCaseImpl implements UserSearchUseCase {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> findAll() {
        return UserMapper.toListDto(userRepository.findAll());
    }
}
