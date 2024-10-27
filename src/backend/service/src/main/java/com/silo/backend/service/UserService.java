package com.silo.backend.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.silo.backend.domain.enums.AuthProviderEnum;
import com.silo.backend.domain.enums.RoleEnum;
import com.silo.backend.domain.model.dto.CaptchaResponse;
import com.silo.backend.domain.model.dto.MailRequest;
import com.silo.backend.domain.model.entity.user.Role;
import com.silo.backend.domain.model.entity.user.User;
import com.silo.backend.domain.model.entity.user.oauth2.OAuth2UserInfo;
import com.silo.backend.domain.repository.UserRepository;
import com.silo.backend.infrastructure.CrudService;
import com.silo.backend.infrastructure.ErrorMessage;
import com.silo.backend.infrastructure.exception.ApiRequestException;
import com.silo.backend.infrastructure.exception.EmailException;
import com.silo.backend.infrastructure.exception.PasswordConfirmationException;
import com.silo.backend.infrastructure.exception.PasswordException;

import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements CrudService<User, String> {
    
    private final UserRepository userRepository;
    private final EmailingService emailService;
    private final RestTemplate restTemplate;
    private final PasswordEncoder passwordEncoder;

    @Value("${hostname}")
    private String hostname;
    
    @Value("${recaptcha.secret}")
    private String secret;

    @Value("${recaptcha.url}")
    private String captchaUrl;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> get(String id) {
        return userRepository.findById(id);
    }

    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void create(User entity) {
       userRepository.save(entity);
    }

    @Transactional
    public String registerUser(User user, String captcha, String password2) throws MessagingException {
        String url = String.format(captchaUrl, secret, captcha);
        restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponse.class);

        if (user.getPassword() != null && !user.getPassword().equals(password2)) {
            throw new PasswordException(ErrorMessage.PASSWORDS_DO_NOT_MATCH);
        }

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new EmailException(ErrorMessage.EMAIL_IN_USE);
        }

        user.setActive(false);
        user.setRoles(Collections.singleton(RoleEnum.USER));
        user.setProvider(AuthProviderEnum.LOCAL);
        user.setActivationCode(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        sendEmail(user, "Activation code", "registration-template", "registrationUrl", "/activate/" + user.getActivationCode());
        return "User successfully registered.";
    }

    @Override
    public void update(User entity) {
        userRepository.save(entity);
    }

    public User update(String email, User user) {
        User userFromDb = userRepository.findByEmail(email)
                .orElseThrow(() -> new ApiRequestException(ErrorMessage.EMAIL_NOT_FOUND, HttpStatus.NOT_FOUND));
        userFromDb.setFirstName(user.getFirstName());
        userFromDb.setLastName(user.getLastName());
        return userRepository.save(userFromDb);
    }

    @Transactional
    public String activateUser(String code) {
        User user = userRepository.findByActivationCode(code)
                .orElseThrow(() -> new ApiRequestException(ErrorMessage.ACTIVATION_CODE_NOT_FOUND, HttpStatus.NOT_FOUND));
        user.setActivationCode(null);
        user.setActive(true);
        userRepository.save(user);
        return "User successfully activated.";
    }

       @Transactional
    public User registerOauth2User(String provider, OAuth2UserInfo oAuth2UserInfo) {
        User user = new User();
        user.setEmail(oAuth2UserInfo.getEmail());
        user.setFirstName(oAuth2UserInfo.getFirstName());
        user.setLastName(oAuth2UserInfo.getLastName());
        user.setActive(true);
        user.setRoles(Collections.singleton(RoleEnum.USER));
        user.setProvider(AuthProviderEnum.valueOf(provider.toUpperCase()));
        return userRepository.save(user);
    }

    @Transactional
    public User updateOauth2User(User user, String provider, OAuth2UserInfo oAuth2UserInfo) {
        user.setFirstName(oAuth2UserInfo.getFirstName());
        user.setLastName(oAuth2UserInfo.getLastName());
        user.setProvider(AuthProviderEnum.valueOf(provider.toUpperCase()));
        return userRepository.save(user);
    }

    public String getEmailByPasswordResetCode(String code) {
        return userRepository.getEmailByPasswordResetCode(code)
                .orElseThrow(() -> new ApiRequestException(ErrorMessage.INVALID_PASSWORD_CODE, HttpStatus.BAD_REQUEST));
    }

    @Transactional
    public String sendPasswordResetCode(String email) throws MessagingException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ApiRequestException(ErrorMessage.EMAIL_NOT_FOUND, HttpStatus.NOT_FOUND));
        user.setPasswordResetCode(UUID.randomUUID().toString());
        userRepository.save(user);

        sendEmail(user, "Password reset", "password-reset-template", "resetUrl", "/reset/" + user.getPasswordResetCode());
        return "Reset password code is send to your E-mail";
    }

    @Transactional
    public String passwordReset(String email, String password, String password2) {
        if (!StringUtils.hasText(password2)) {
            throw new PasswordConfirmationException(ErrorMessage.EMPTY_PASSWORD_CONFIRMATION);
        }
        if (password != null && !password.equals(password2)) {
            throw new PasswordException(ErrorMessage.PASSWORDS_DO_NOT_MATCH);
        }
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ApiRequestException(ErrorMessage.EMAIL_NOT_FOUND, HttpStatus.NOT_FOUND));
        user.setPassword(passwordEncoder.encode(password));
        user.setPasswordResetCode(null);
        userRepository.save(user);
        return "Password successfully changed!";
    }

    @Override
    public void delete(String id) {
       userRepository.deleteById(id);
    }

    private void sendEmail(User user, String subject, String template, String urlAttribute, String urlPath) throws MessagingException {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("firstName", user.getFirstName());
        attributes.put(urlAttribute, "http://" + hostname + urlPath);

        //emailService.sendMail(user.getEmail(), subject, template, attributes);
        emailService.sendMail(MailRequest.builder().toEmail(user.getEmail()).subject(subject).message(template).build() );
    }   
    
}
