package com.study.projectboard.controller;

import com.study.projectboard.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(SecurityConfig.class)
@WebMvcTest
class MainControllerTest {

    private final MockMvc mockMvc;

    @Autowired
    public MainControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void testRedirection() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is3xxRedirection());
    }
}