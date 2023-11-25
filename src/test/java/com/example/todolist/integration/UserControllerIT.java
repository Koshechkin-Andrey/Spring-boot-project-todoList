package com.example.todolist.integration;

import com.example.todolist.testcontainer.TestContainerRunner;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@RequiredArgsConstructor
public class UserControllerIT extends TestContainerRunner {

    private final MockMvc mockMvc;


    @Test
    void findAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.view().name("/users"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("users"));

    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1"))
                .andExpect(MockMvcResultMatchers.view().name("/user"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

    }

    @Test
    void createPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/registration"))
                .andExpectAll(
                        MockMvcResultMatchers.view().name("/registration"),
                        MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/registration")
                        .param("email", "vasya@gmail.com"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/users"));
    }

    @Test
    void delete() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/1/delete"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/users"));
    }

}
