package com.example.todolist;

import com.example.todolist.entity.Task;
import com.example.todolist.repository.TaskRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TodoListApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TodoListApplication.class, args);
        TaskRepository bean = context.getBean(TaskRepository.class);

    }

}
