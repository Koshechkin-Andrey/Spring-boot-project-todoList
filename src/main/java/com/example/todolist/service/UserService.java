package com.example.todolist.service;

import com.example.todolist.dto.UserCreateEditDto;
import com.example.todolist.dto.UserReadDto;
import com.example.todolist.mapper.UserCreatEditMapper;
import com.example.todolist.mapper.UserMapper;
import com.example.todolist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserCreatEditMapper userCreatEditMapper;

    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream().map(userMapper::transferToDto).toList();
    }

    public Optional<UserReadDto> findById(Long id) {
        return userRepository.findById(id).map(userMapper::transferToDto);
    }

    @Transactional
    public UserReadDto create(UserCreateEditDto userCreateEditDto) {
        return Optional.of(userCreateEditDto)
                .map(userCreatEditMapper::transferToEntity)
                .map(userRepository::saveAndFlush)
                .map(userMapper::transferToDto).orElseThrow();
    }
}
