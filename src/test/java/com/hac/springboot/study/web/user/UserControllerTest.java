package com.hac.springboot.study.web.user;


import com.hac.springboot.study.domain.user.UserMapper;
import com.hac.springboot.study.service.user.UserService;
import com.hac.springboot.study.web.dto.user.UserResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void 사용자정보리스트가_리턴된다() throws Exception {
        //given
        mvc.perform(get("/user/info/list"))
                .andDo(print())
                .andExpect(status().isOk());

        //when
        List<UserResponseDto> userList = userService.getUserInfoList();

        //then
        assertThat(userList.get(0).getUserNm()).isEqualTo("하창진");
    }
}

