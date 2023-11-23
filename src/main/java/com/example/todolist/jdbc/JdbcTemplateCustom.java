package com.example.todolist.jdbc;

import com.example.todolist.entity.User;

import java.util.List;

public interface JdbcTemplateCustom {

    int insertBatch(User... users);

    int deleteBatch(Long...ids);

    List<User> selectBatch();
}
