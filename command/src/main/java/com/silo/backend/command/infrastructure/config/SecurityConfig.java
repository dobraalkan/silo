package com.silo.backend.command.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.silo.backend.command.infrastructure.persistence.CookieOAuth2AuthorizationRequestRepository;
import com.silo.backend.command.infrastructure.security.OAuth2AuthenticationFailureHandler;
import com.silo.backend.command.infrastructure.security.OAuth2AuthenticationSuccessHandler;
import com.silo.backend.command.infrastructure.springboot.TokenAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final TokenAuthenticationFilter tokenAuthenticationFilter;
    private final OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;
    private final OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;
    private final CookieOAuth2AuthorizationRequestRepository authorizationRequestRepository;

    public static final String[] WHITE_LIST = {
        "/api/auth/**",
        "/api/user/register",
        "/v3/api-docs/**",
        "/swagger-ui/**",
        "/swagger/**"     
    };

    @Bean
     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            //.cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(csrf -> csrf.disable())
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(request -> request
                .requestMatchers(WHITE_LIST).permitAll() // Allow access to public endpoints
                .requestMatchers("/api/application").hasAuthority("ADMIN")
                .anyRequest().authenticated() // All other requests need to be authenticated
                )
            .formLogin(login -> login
                        .usernameParameter("email")
                        .passwordParameter("pwd")
                        .loginPage("/user/login")
                        .failureUrl("/user/login?false")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
            )
            .oauth2Login(configure -> 
                configure.authorizationEndpoint(config ->
                    config.authorizationRequestRepository(authorizationRequestRepository)
                    .baseUri("/oauth2/authorize")
                )
                //.userInfoEndpoint(config -> config.userService(oAuth2UserService))
                .successHandler(oAuth2AuthenticationSuccessHandler)
                .failureHandler(oAuth2AuthenticationFailureHandler)
            )
            .logout(logout -> logout
                        .logoutUrl("/user/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessUrl("/user/login")
            )
            .exceptionHandling(exceptionHandling -> exceptionHandling
                .defaultAuthenticationEntryPointFor(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED), new AntPathRequestMatcher("/api/**"))
            );

            http.addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

            return http.build();
    }

}
