package com.example.todolist.integration;

import com.example.todolist.entity.Status;
import com.example.todolist.entity.Task;
import com.example.todolist.repository.TaskRepository;
import com.example.todolist.testcontainer.TestContainerRunner;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Sql({
        "classpath:sql/data.sql"
})
@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("test")
@RequiredArgsConstructor
@Transactional
public class TaskRepositoryIT extends TestContainerRunner {

    public final TaskRepository taskRepository;

    @Test
    void shouldReturnTaskByUserId(){
        List<Task> taskByUserId = taskRepository.findTaskByUserId(1L);
        System.out.println(taskByUserId);
    }

    @Test
    void shouldReturnTaskByStatusAndUserId(){
        List<String> actualResult = taskRepository.findTaskByStatusAndUserId(1L, Status.COMPLETED);
        Assertions.assertThat(actualResult).hasSize(1);
        System.out.println();
    }
}
