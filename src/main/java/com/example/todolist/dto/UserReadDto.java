package com.example.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserReadDto {

    private Long id;
    private String username;

    private List<TaskReadDto> taskReadDtoList = new ArrayList<>();
}
