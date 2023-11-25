package com.example.todolist.controller;

import com.example.todolist.dto.TaskCreateEditDto;
import com.example.todolist.service.TaskService;
import com.example.todolist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RequestMapping("/task")
@RequiredArgsConstructor
@Controller
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;
/*
    @GetMapping("/{id}")
    public String findTaskByUserId(@PathVariable("id") Long id, Model model) {
        return userService.findById(id)
                .map(it -> {
                    model.addAttribute("task", taskService.findAllTaskByUserId(it.getId()));
                    return "/task";
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }*/


    @GetMapping("/{id}")
    public String findTaskByUserId(@PathVariable("id") Long id, Model model) {
        return Optional.of(taskService.findAllTaskByUserId(id))
                .map(it -> {
                    model.addAttribute("task",it);
                    return "/task";
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
    @GetMapping("/registrationTask")
    public String createPage(){
        return "/registrationTask";
    }


    @PostMapping("/registrationTask")
    public String create(TaskCreateEditDto taskCreateEditDto){
        taskService.createTask(taskCreateEditDto);
        return "/users/{id}";
    }

}
