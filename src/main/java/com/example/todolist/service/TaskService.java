package com.example.todolist.service;

import com.example.todolist.dto.TaskCreateEditDto;
import com.example.todolist.dto.TaskReadDto;
import com.example.todolist.mapper.TaskMapper;
import com.example.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public List<TaskReadDto> findAllTaskByUserId(Long id){
        return taskRepository.findTaskByUserId(id).stream().map(taskMapper::transferToDto).toList();
    }

    @Transactional
    public TaskReadDto createTask(TaskCreateEditDto taskCreateEditDto){
        return Optional.of(taskCreateEditDto)
                .map(taskMapper::createMapper)
                .map(taskRepository::saveAndFlush)
                .map(taskMapper::transferToDto).orElseThrow();
    }
}
