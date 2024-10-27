package com.silo.backend.domain.model.entity.user.oauth2;

import java.util.Map;
import javax.naming.AuthenticationException;

import com.silo.backend.domain.enums.AuthProviderEnum;

import lombok.SneakyThrows;

public class OAuth2UserFactory {

    @SneakyThrows
    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(AuthProviderEnum.GOOGLE.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProviderEnum.FACEBOOK.toString())) {
            return new FacebookOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProviderEnum.GITHUB.toString())) {
            return new GithubOAuth2UserInfo(attributes);
        } else {
            throw new AuthenticationException();
        }
    }
}
