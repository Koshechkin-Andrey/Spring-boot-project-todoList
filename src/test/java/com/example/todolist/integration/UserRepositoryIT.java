package com.example.todolist.integration;


import com.example.todolist.entity.Task;
import com.example.todolist.entity.User;
import com.example.todolist.predicate.TaskFilter;
import com.example.todolist.repository.UserRepository;
import com.example.todolist.testcontainer.TestContainerRunner;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@Sql({
        "classpath:sql/data.sql"
})
@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("test")
@RequiredArgsConstructor
public class UserRepositoryIT extends TestContainerRunner {

    private final UserRepository userRepository;

    @Test
    void findAllByFilter(){
        TaskFilter filter = new TaskFilter("COMPLETED");
        List<Task> allByTaskFilter = userRepository.findAllByTaskFilter(filter);
        System.out.println(allByTaskFilter);
    }
    @Test
    void findAll(){
        List<User> actualResult = userRepository.findAll();
        Assertions.assertThat(actualResult).hasSize(3);
    }

    @Test
    void JdbcDeleteBatch(){
        List<User> all = userRepository.findAll();
        System.out.println(all.size());

        int i = userRepository.deleteBatch(1L, 2L);
        Assertions.assertThat(i).isEqualTo(2);

        List<User> all2= userRepository.findAll();
        System.out.println(all2.size());
    }

    @Test
    void JdbcInsertBatch(){
        List<User> actualResult = userRepository.findAll();
        Assertions.assertThat(actualResult).hasSize(3);

        User user1= User.builder()
                .email("user1@gmail.com")
                .build();

        User user2 = User.builder()
                .email("user2@Gmail.com")
                .build();
        userRepository.insertBatch(user1, user2);

        List<User> actualResult2 = userRepository.findAll();
        Assertions.assertThat(actualResult2).hasSize(5);
    }
    @Test
    void findAllSelectBatchTemplate(){
        List<User> users = userRepository.selectBatch();
        Assertions.assertThat(users).hasSize(3);
        Assertions.assertThat(users.get(0).getEmail()).isEqualTo("alex@gmail.com");
    }
}
