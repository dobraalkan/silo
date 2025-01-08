package com.silo.backend.command.domain.service.auth;

import com.silo.backend.command.domain.model.entity.OAuth2Principal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.stereotype.Service;

@Service
public class FacebookOAuth2Authentication extends AbstractOAuth2Authentication implements OAuth2Authentication {

    public FacebookOAuth2Authentication(
            @Qualifier("facebookClientRegistration") 
            ClientRegistration clientRegistration,
            CustomOAuth2UserService customOAuth2UserService) {
        super(clientRegistration, customOAuth2UserService);
    }

    @Override
    public OAuth2Principal authenticate(String anAccessCode) {
        return super.authenticateUser(anAccessCode);
    }
}
