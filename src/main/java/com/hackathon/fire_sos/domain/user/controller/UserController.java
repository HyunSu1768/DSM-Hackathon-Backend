package com.hackathon.fire_sos.domain.user.controller;

import com.hackathon.fire_sos.domain.user.controller.dto.request.UserLoginRequest;
import com.hackathon.fire_sos.domain.user.controller.dto.request.UserSignupRequest;
import com.hackathon.fire_sos.domain.user.controller.dto.response.LoginResponse;
import com.hackathon.fire_sos.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public void singup(@RequestBody UserSignupRequest request){
        userService.signup(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody UserLoginRequest request){
        return userService.login(request);
    }

}
