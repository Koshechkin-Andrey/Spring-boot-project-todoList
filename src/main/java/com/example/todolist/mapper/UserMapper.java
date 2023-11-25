package com.example.todolist.mapper;

import com.example.todolist.dto.UserCreateEditDto;
import com.example.todolist.dto.UserReadDto;
import com.example.todolist.entity.User;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
@Component
public class UserMapper implements BaseMapper<User, UserReadDto>{

    @Override
    public UserReadDto transferToDto(User entity) {
        return UserReadDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .build();
    }

    @Override
    public User transferToEntity(UserReadDto userDto) {
        return null;
    }


    public User copy(User user, UserCreateEditDto userCreateEditDto){
        user.setEmail(user.getEmail());
        return user;
    }

}
