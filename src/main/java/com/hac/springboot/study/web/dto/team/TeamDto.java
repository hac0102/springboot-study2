package com.hac.springboot.study.web.dto.team;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class TeamDto {
    private long teamSrno;
    private String teamName;
    private String teamDesc;
}
