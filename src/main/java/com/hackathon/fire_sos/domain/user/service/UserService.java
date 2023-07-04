package com.hackathon.fire_sos.domain.user.service;

import com.hackathon.fire_sos.domain.user.controller.dto.request.UserLoginRequest;
import com.hackathon.fire_sos.domain.user.controller.dto.request.UserSignupRequest;
import com.hackathon.fire_sos.domain.user.controller.dto.response.LoginResponse;
import com.hackathon.fire_sos.domain.user.entity.User;
import com.hackathon.fire_sos.domain.user.entity.UserRole;
import com.hackathon.fire_sos.domain.user.repository.UserRepository;
import com.hackathon.fire_sos.domain.user.service.exception.PassWordCheckMismatchException;
import com.hackathon.fire_sos.domain.user.service.exception.PasswordMismatchException;
import com.hackathon.fire_sos.domain.user.service.exception.UserAlreadyExistException;
import com.hackathon.fire_sos.domain.user.service.exception.UserNotFoundException;
import com.hackathon.fire_sos.global.config.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Point;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    private final JwtTokenProvider jwtTokenProvider;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void signup(UserSignupRequest request){

        if(!request.getPassword().equals(request.getPasswordCheck())){
            throw PassWordCheckMismatchException.EXCEPTION;
        }

        validateDuplicateUser(request);

        String password = passwordEncoder.encode(request.getPassword());

        User user = User.builder()
                .accountId(request.getAccountId())
                .password(password)
                .userRole(UserRole.ROLE_USER)
                .build();

        userRepository.save(user);

    }

    public LoginResponse login(UserLoginRequest request){

        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw PasswordMismatchException.EXCEPTION;
        }

        user.changeDeviceToken(request.getDeviceToken());

        return jwtTokenProvider.createToken(user.getAccountId());

    }

    private void validateDuplicateUser(UserSignupRequest request){

        if(userRepository.existsByAccountId(request.getAccountId())){
            throw UserAlreadyExistException.EXCEPTION;
        }
    }


}
