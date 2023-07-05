package com.hackathon.fire_sos.infra.firebase;

import com.google.firebase.messaging.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class FirebaseCloudMessageService {

    public String sendMessage(String deviceToken, String title, String body) throws FirebaseMessagingException{
        Message message = Message.builder()
                .setAndroidConfig(AndroidConfig.builder()
                        .setTtl(3600*1000)
                        .setPriority(AndroidConfig.Priority.HIGH)
                        .setRestrictedPackageName("com.example.hackathon")
                        .setDirectBootOk(true)
                        .setNotification(AndroidNotification.builder()
                                .setTitle(title)
                                .setBody(body)
                                .build())
                                .build())
                        .setToken(deviceToken)
                        .build();

        String response = FirebaseMessaging.getInstance().send(message);
        return response;
    }
}
