package com.example.todolist.predicate;

import com.example.todolist.entity.Task;

import java.util.List;

public interface TaskFilterRepository {

    List<Task> findAllByTaskFilter(TaskFilter filter);
}
