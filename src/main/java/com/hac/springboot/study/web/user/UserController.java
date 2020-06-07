package com.hac.springboot.study.web.user;

import com.hac.springboot.study.service.user.UserService;
import com.hac.springboot.study.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/info/list")
    private Map<String, Object> getUserInfoList(){
        Map<String, Object> map = new HashMap<>();
        map.put("data", userService.getUserInfoList());
        return map;
    }

    @GetMapping("/userlist")
    private Map<String, Object> getUserList(){
        Map<String, Object> map = new HashMap<>();
        map.put("data", userService.getUserList());
        return map;
    }


    @PostMapping("/user/join")
    private void userJoin(@RequestBody UserDto userReqDto){
        userService.insertUserJoin(userReqDto);
    }
}
