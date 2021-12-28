package com.hongki.boardproject.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class) //JUnit5에 내장된 실행자 외에 다른 실행자를 실행
@WebMvcTest(controllers = HelloController.class) //WEB에 집중할 수 있는 어노테이션
class HelloControllerTest {

    @Autowired //주입
    private MockMvc mvc; //WEB API를 테스트

    @Test
    public void helloTest() throws Exception{
        String hello = "hello Spring Boot!";

        // /hello를 받아왔을 때
        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) // HTTP Header의 상태코드
                .andExpect(content().string(hello)); // mvc.perform의 결과를 검증
    }

    @Test
    public void helloDtoTest() throws Exception {

        String name = "hongki";
        String nickname = "developer";

        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("nickname", nickname))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.nickname", is(nickname)));
    }
}