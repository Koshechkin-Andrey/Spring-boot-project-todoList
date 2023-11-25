package com.example.todolist.service;

import com.example.todolist.dto.UserReadDto;
import com.example.todolist.mapper.UserMapper;
import com.example.todolist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserReadDto> findAll(){
        return userRepository.findAll().stream().map(userMapper::transferToDto).toList();
    }
}
