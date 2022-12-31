package com.study.projectboard.controller;

import com.study.projectboard.config.SecurityConfig;
import com.study.projectboard.config.TestSecurityConfig;
import com.study.projectboard.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(TestSecurityConfig.class)
@WebMvcTest
class MainControllerTest {

    private final MockMvc mockMvc;

    @MockBean
    ArticleCommentController articleCommentController;

    @MockBean
    ArticleService articleService;

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