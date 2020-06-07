package com.hac.springboot.study.domain.user;

import com.hac.springboot.study.web.dto.user.UserDto;
import com.hac.springboot.study.web.dto.user.UserResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    List<UserResponseDto> selectUserInfoList();

    long insertUserJoin(UserDto userDto);

    UserDto selectUserInfo(long userSrno);

    List<Map<String, Object>> selectUserList();

    List<UserDto> selectUserList2();
}
