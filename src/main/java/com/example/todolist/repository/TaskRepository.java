package com.example.todolist.repository;

import com.example.todolist.entity.Status;
import com.example.todolist.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {


  List<Task> findTaskByUserId(Long id);

  @Query("select t.description, t.status FROM Task t join fetch User u " +
          "ON u.id=t.user.id where u.id=:id and t.status=:status")
  List<String>findTaskByStatusAndUserId(@Param("id") Long id, @Param("status") Status status);
}
