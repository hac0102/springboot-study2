package com.hac.springboot.study.web.dto.user;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private int userSrno;
    private String userNm;
    private String celpTlno;
    private String frstUserId;
    private LocalDateTime frstRegDate;
    private String lastChgUserId;
    private LocalDateTime lastChgDate;

    @Builder
    public UserResponseDto(String userNm){
        this.userNm = userNm;
    }
}
