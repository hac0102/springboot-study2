package com.hac.springboot.study.service.user;

import com.hac.springboot.study.domain.user.UserMapper;
import com.hac.springboot.study.web.dto.user.UserDto;
import com.hac.springboot.study.web.dto.user.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;

    public List<UserResponseDto> getUserInfoList() {
        return userMapper.selectUserInfoList();
    }

    public long insertUserJoin(UserDto userDto) {
        return userMapper.insertUserJoin(userDto);
    }

    public List<Map<String, Object>> getUserList() {
        List<Map<String, Object>> aa = new ArrayList<>();
        System.out.println("aaaaaa :: " + userMapper.selectUserList());
        System.out.println("bbbbbb :: " + userMapper.selectUserList2());


//        aa.add(userMapper.selectUserList());
        return userMapper.selectUserList();

    }
}

