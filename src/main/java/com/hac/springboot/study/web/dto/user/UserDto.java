package com.hac.springboot.study.web.dto.user;

import com.hac.springboot.study.web.dto.team.TeamDto;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private long userSrno;
    private String userNm;
    private String emailAddr;
    private String joinTyp;
    private UserDetailDto userDetailDto;
    private TeamDto teamDto;
    private Role role;


    @Builder
    public UserDto(String userNm, String emailAddr, String joinTyp, Role role){
        this.userNm = userNm;
        this.emailAddr = emailAddr;
        this.joinTyp = joinTyp;
        this.role = role;
    }
}
