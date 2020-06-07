package com.hac.springboot.study.web;

import com.hac.springboot.study.service.user.UserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @GetMapping("/hello")


    public String hello(){
        RestTemplate rt = new RestTemplate();

        return "hello";
    }

}
