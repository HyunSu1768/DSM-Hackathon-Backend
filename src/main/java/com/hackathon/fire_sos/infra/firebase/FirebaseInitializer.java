package com.hackathon.fire_sos.infra.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Configuration
public class FirebaseInitializer {

    @PostConstruct
    public void initialize() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("/Users/buhyeonsu/Desktop/Coding/Backend/fire_SOS/src/main/resources/firebase/service-account-file.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setProjectId("soss-2ec9c")
                .build();

        FirebaseApp.initializeApp(options);
    }
}