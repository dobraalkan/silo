package com.silo.backend.command.infrastructure.http.oauth2.user;

import java.util.Map;

import com.silo.backend.command.domain.model.entity.user.User;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(User.AuthProvider.GOOGLE.toString().toLowerCase())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(User.AuthProvider.FACEBOOK.toString().toLowerCase())) {
            return new FacebookOAuth2UserInfo(attributes);
        } else {
            throw new IllegalArgumentException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
