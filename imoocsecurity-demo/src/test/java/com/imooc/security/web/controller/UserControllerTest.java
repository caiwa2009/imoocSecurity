package com.imooc.security.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc= MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    @Test
    public void whenQuerySuccesss() throws Exception {
        mockMvc.perform(get("/rest/user")
                .param("username","haha")
                .param("size","10")//每页10条
                .param("page","2")//第二页
                .param("sort","username,desc")//用户名降序
        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
//              $.length()表示返回的集合的长度是3
                .andExpect(jsonPath("$.length()").value(2));
    }
}
