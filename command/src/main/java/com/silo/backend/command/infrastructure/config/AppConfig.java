package com.silo.backend.command.infrastructure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;

import com.silo.backend.command.domain.service.auth.FacebookOAuth2Authentication;
import com.silo.backend.command.domain.service.auth.GoogleOAuth2Authentication;
import com.silo.backend.command.domain.service.auth.OAuth2Service;
import com.silo.backend.command.infrastructure.persistence.jpa.UserRegistrationRepository;
import com.silo.backend.command.infrastructure.persistence.jpa.UserRepository;

@Configuration
public class AppConfig {

    @Autowired
    UserRegistrationRepository userRegistrationJpaRepository;

    @Autowired
    UserRepository userJpaRepository;

    @Autowired
    Environment env;

    @Autowired
    AppProperties appProperties;

    @Bean
    String recoveryLink() {
        return appProperties.getGui().getRecoveryRoute();
    }

    @Bean
    String confirmationLink() {
        return appProperties.getGui().getConfirmationRoute();
    }

    @Bean
    @Qualifier("facebookClientRegistration")
    ClientRegistration facebookClientRegistration() {
        String clientRootProperty = "spring.security.oauth2.client.registration.facebook";
        String clientId = env.getProperty(clientRootProperty + ".client-id");
        String clientSecret = env.getProperty(clientRootProperty + ".client-secret");
        return CommonOAuth2Provider.FACEBOOK.getBuilder("facebook")
                .clientId(clientId).clientSecret(clientSecret).build();
    }

    @Bean
    @Qualifier("googleClientRegistration")
    ClientRegistration googleClientRegistration() {
        String clientRootProperty = "spring.security.oauth2.client.registration.facebook";
        String clientId = env.getProperty(clientRootProperty + ".client-id");
        String clientSecret = env.getProperty(clientRootProperty + ".client-secret");
        return CommonOAuth2Provider.FACEBOOK.getBuilder("facebook")
                .clientId(clientId).clientSecret(clientSecret).build();
    }

    @Bean
    @Qualifier("facebookOAuth2Service")
    OAuth2Service facebookOAuth2Service(FacebookOAuth2Authentication facebookOAuth2Authentication, UserRepository userRepository) {
        return new OAuth2Service(facebookOAuth2Authentication, userRepository);
    }

    @Bean
    @Qualifier("googleOAuth2Service")
    OAuth2Service googleOAuth2Service(GoogleOAuth2Authentication googleOAuth2Authentication, UserRepository userRepository) {
        return new OAuth2Service(googleOAuth2Authentication, userRepository);
    }
}
