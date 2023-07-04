package com.hackathon.fire_sos.global.config.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.fire_sos.global.config.FilterConfig;
import com.hackathon.fire_sos.global.config.security.auth.CustomUserDetailService;
import com.hackathon.fire_sos.global.config.security.jwt.JwtResolver;
import com.hackathon.fire_sos.global.config.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{

    private final JwtTokenProvider jwtTokenProvider;

    private final JwtResolver jwtResolver;

    private final ObjectMapper objectMapper;

    private final CustomUserDetailService userDetailService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf().disable()
                .exceptionHandling()

                .and()
                .headers()
                .frameOptions()
                .sameOrigin()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()

                .and()
                .apply(new FilterConfig(jwtTokenProvider, jwtResolver, objectMapper, userDetailService))

                .and().build();
    }

}
