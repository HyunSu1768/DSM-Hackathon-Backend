package com.hackathon.fire_sos.domain.user.service;


import com.hackathon.fire_sos.domain.user.entity.User;
import com.hackathon.fire_sos.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User currentUser(){
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByAccountId(userId)
                .orElseThrow(()-> new EntityNotFoundException("찾을 수 없는 유저 입니다."));
    }
}
