package com.example.todolist.integration;

import com.example.todolist.testcontainer.TestContainerRunner;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@RequiredArgsConstructor
public class TaskControllerIT  extends TestContainerRunner {

    private final MockMvc mockMvc;

    @Test
    void findTaskByUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/task/1"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.model().attributeExists("task"))
                .andExpect(MockMvcResultMatchers.view().name("/task"));
    }
}
