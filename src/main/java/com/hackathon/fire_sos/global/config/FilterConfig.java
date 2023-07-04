package com.hackathon.fire_sos.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.fire_sos.global.config.security.auth.CustomUserDetailService;
import com.hackathon.fire_sos.global.config.security.jwt.JwtFilter;
import com.hackathon.fire_sos.global.config.security.jwt.JwtResolver;
import com.hackathon.fire_sos.global.config.security.jwt.JwtTokenProvider;
import com.hackathon.fire_sos.global.error.GlobalExceptionFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtTokenProvider jwtTokenProvider;

    private final JwtResolver jwtResolver;

    private final ObjectMapper objectMapper;

    private final CustomUserDetailService userDetailService;

    @Override
    public void configure(HttpSecurity http) {
        JwtFilter jwtTokenFilter = new JwtFilter(jwtResolver, jwtTokenProvider, userDetailService);
        GlobalExceptionFilter globalExceptionFilter = new GlobalExceptionFilter(objectMapper);

        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(globalExceptionFilter, JwtFilter.class);
    }
}
