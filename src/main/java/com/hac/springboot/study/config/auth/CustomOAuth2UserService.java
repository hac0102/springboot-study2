package com.hac.springboot.study.config.auth;

import com.hac.springboot.study.config.auth.dto.OAuthAttributes;
import com.hac.springboot.study.domain.user.UserMapper;
import com.hac.springboot.study.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserMapper userMapper;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        UserDto user = saveOrUpdate(attributes);
//        httpSession.setAttribute("user", attributes.toDto());

        user = (UserDto) httpSession.getAttribute("user");
        return null;
    }

    private UserDto saveOrUpdate(OAuthAttributes attributes) {
//        long userSrno = userMapper.insertUserJoin(attributes.toDto());
//        System.out.println("zzzzzz :: " + userMapper.selectUserInfo(userSrno));
        return null;
//        userMapper.selectUserInfoDto();


    }
}
