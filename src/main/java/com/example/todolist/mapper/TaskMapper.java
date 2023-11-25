package com.example.todolist.mapper;

import com.example.todolist.dto.TaskCreateEditDto;
import com.example.todolist.dto.TaskReadDto;
import com.example.todolist.entity.Status;
import com.example.todolist.entity.Task;
import com.example.todolist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskMapper implements BaseMapper<Task, TaskReadDto>{

    private final UserRepository userRepository;
    @Override
    public TaskReadDto transferToDto(Task entity) {
        return TaskReadDto.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .status(entity.getStatus().name())
                .dateOfCreation(entity.getDateOfCreation())
                .build();
    }

    @Override
    public Task transferToEntity(TaskReadDto userDto) {
        return null;
    }


    public Task createMapper(TaskCreateEditDto taskCreateEditDto){
        return Task.builder()
                .description(taskCreateEditDto.getDescription())
                .dateOfCreation(taskCreateEditDto.getDate())
                .user(userRepository.findById(taskCreateEditDto.getUserId()).orElseThrow())
                .status(Status.valueOf("IN_PROGRESS"))
                .build();
    }
}
