package com.silo.backend.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.silo.backend.application.filter.JwtAuthorizationFilter;
import com.silo.backend.application.handler.OAuth2AuthenticationFailureHandler;
import com.silo.backend.application.handler.OAuth2AuthenticationSuccessHandler;
import com.silo.backend.service.CustomOAuth2UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {

    private final JwtAuthorizationFilter jwtAuthorizationFilter;
    private final OAuth2AuthenticationSuccessHandler oauthSuccessHandler;
    private final OAuth2AuthenticationFailureHandler oAuth2FailureHandler;
    private final CustomOAuth2UserService oAuth2UserService;
    private final CookieOAuth2AuthorizationRequestRepository authorizationRequestRepository;

    public static final String[] PUBLIC_URLS = {
        "/api/auth/**",
        "/api/user/register",
        "/v3/api-docs/**",
        "/swagger-ui/**",
        "/swagger/**"     
    };

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            //.cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(csrf -> csrf.disable())
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(request -> request
                .requestMatchers(PUBLIC_URLS).permitAll() // Allow access to public endpoints
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
                .userInfoEndpoint(config -> config.userService(oAuth2UserService))
                .successHandler(oauthSuccessHandler)
                .failureHandler(oAuth2FailureHandler)
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

            http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

            return http.build();
    }

   /*  @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(List.of("https://localhost:8099"));
        configuration.setAllowedMethods(List.of("GET", "POST", "DELETE", "PATCH", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setExposedHeaders(List.of("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    } */

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
