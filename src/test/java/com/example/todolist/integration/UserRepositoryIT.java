package com.example.todolist.integration;


import com.example.todolist.entity.User;
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
    void findAll(){
        List<User> actualResult = userRepository.findAll();
        Assertions.assertThat(actualResult).hasSize(3);
    }

}
