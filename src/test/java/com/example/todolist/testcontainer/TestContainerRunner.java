package com.example.todolist.testcontainer;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

public class TestContainerRunner {

    private static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:16.0");

    @BeforeAll
    static void containerStart() {
        container.start();
    }


    @DynamicPropertySource
    static void redisProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);

    }
}
