package com.example.todolist.repository;

import com.example.todolist.entity.Task;
import com.example.todolist.entity.User;
import com.example.todolist.jdbc.JdbcTemplateCustom;
import com.example.todolist.predicate.TaskFilterRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JdbcTemplateCustom, TaskFilterRepository {


    Optional<User> findByUsername(String username);
}
