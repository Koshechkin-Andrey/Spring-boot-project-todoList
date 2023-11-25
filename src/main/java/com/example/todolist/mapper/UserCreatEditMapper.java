package com.example.todolist.mapper;

import com.example.todolist.dto.UserCreateEditDto;
import com.example.todolist.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserCreatEditMapper implements BaseMapper<User,UserCreateEditDto>{


    @Override
    public UserCreateEditDto transferToDto(User entity) {
        return UserCreateEditDto.builder()
                .email(entity.getEmail())
                .build();
    }

    @Override
    public User transferToEntity(UserCreateEditDto userDto) {
        return User.builder()
                .email(userDto.getEmail())
                .build();
    }


}
