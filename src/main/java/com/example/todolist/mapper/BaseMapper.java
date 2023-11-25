package com.example.todolist.mapper;

import org.springframework.stereotype.Component;

public interface BaseMapper <F, T>{

    T transferToDto(F entity);

    F transferToEntity(T userDto);
}
