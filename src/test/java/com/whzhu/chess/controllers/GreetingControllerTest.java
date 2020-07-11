package com.whzhu.chess.controllers;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {

  @Autowired private MockMvc mockMvc;

  @Test
  public void noParamGreetingShouldReturnDefaultMessage() throws Exception {
    this.mockMvc
        .perform(MockMvcRequestBuilders.get("/greeting").accept(MediaType.APPLICATION_JSON))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("Hello, World!"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
  }

  @Test
  public void paramGreetingShouldReturnTailoredMessage() throws Exception {
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.get("/greeting")
                .accept(MediaType.APPLICATION_JSON)
                .param("name", "Spring Community"))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("Hello, Spring Community!"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2L));
  }
}
