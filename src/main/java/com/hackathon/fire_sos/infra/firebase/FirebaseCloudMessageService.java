package com.hackathon.fire_sos.infra.firebase;

import com.google.firebase.messaging.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class FirebaseCloudMessageService {

    public String sendMessage(String deviceToken) throws FirebaseMessagingException{
        Message message = Message.builder()
                .setAndroidConfig(AndroidConfig.builder()
                        .setTtl(3600*1000)
                        .setPriority(AndroidConfig.Priority.HIGH)
                        .setRestrictedPackageName("com.example.hackathon")
                        .setDirectBootOk(true)
                        .setNotification(AndroidNotification.builder()
                                .setTitle("제목")
                                .setBody("테스트")
                                .build())
                                .build())
                        .setToken(deviceToken)
                        .build();

        String response = FirebaseMessaging.getInstance().send(message);
        return response;
    }
}
