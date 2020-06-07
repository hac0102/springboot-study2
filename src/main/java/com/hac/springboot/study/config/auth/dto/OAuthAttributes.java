package com.hac.springboot.study.config.auth.dto;

import com.hac.springboot.study.web.dto.user.Role;
import com.hac.springboot.study.web.dto.user.UserDto;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String userNm;
    private String joinTyp;
    private String emailAddr;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String userNm, String emailAddr, String joinTyp) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.userNm = userNm;
        this.emailAddr = emailAddr;
        this.joinTyp = joinTyp;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        if("naver".equals(registrationId)) {
            return ofNaver("id", attributes);
        }

        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .userNm((String) attributes.get("name"))
                .emailAddr((String) attributes.get("email"))
                .joinTyp("sub".equals(userNameAttributeName) ? "google" : "naver")
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .userNm((String) response.get("name"))
                .emailAddr((String) response.get("email"))
                .joinTyp("sub".equals(userNameAttributeName) ? "google" : "naver")
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

//    public UserDto toDto() {
//        return UserDto.builder()
//                .userNm(userNm)
//                .emailAddr(emailAddr)
//                .joinTyp(joinTyp)
//                .role(Role.USER)
//                .build();
//    }

}
