package com.hac.springboot.study.web.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class UserDetailDto {
        private long userDtlSrno;
        private String userAddr;
        private int userAge;
        private String userGender;
}
