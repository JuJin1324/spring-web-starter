package starter.springweb.external.client.apppush;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Yoo Ju Jin(jujin@100fac.com)
 * Created Date : 2023/05/17
 * Copyright (C) 2023, Centum Factorial all rights reserved.
 */

@Slf4j
@Component
class FcmAppPushClient implements AppPushClient {
    private static final String FIREBASE_CONFIG_PATH = "firebase/firebase-adminsdk-key.json";

    private FirebaseMessaging firebaseMessaging;

    public FcmAppPushClient() {
        try {
            GoogleCredentials googleCredentials =
                    GoogleCredentials.fromStream(new ClassPathResource(FIREBASE_CONFIG_PATH).getInputStream());
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(googleCredentials)
                    .build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                log.info("[External Service: Push] Firebase client has been initialized.");
            }
            this.firebaseMessaging = FirebaseMessaging.getInstance();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void sendData(List<String> pushTokens, PushData data) {
        try {
            MulticastMessage message = MulticastMessage.builder()
                    .addAllTokens(pushTokens)
                    .putAllData(data.toMap())
                    .setAndroidConfig(AndroidConfig.builder().setPriority(AndroidConfig.Priority.HIGH).build())
                    .build();
            BatchResponse response = this.firebaseMessaging.sendMulticast(message);

            // TODO: 전송에 실패한 Response 처리
            response.getResponses().stream()
                    .filter(Predicate.not(SendResponse::isSuccessful))
                    .forEach(sendResponse -> log.error("failedResponse exception:", sendResponse.getException()));
        } catch (JsonProcessingException | FirebaseMessagingException e) {
            // TODO: 커스텀 예외 처리
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendNotification(List<String> pushTokens, PushNotification notification) {
        try {
            MulticastMessage message = MulticastMessage.builder()
                    .setNotification(Notification.builder()
                            .setTitle(notification.getTitle())
                            .setBody(notification.getContent())
                            .setImage(notification.getImageUrl())
                            .build())
                    .setAndroidConfig(AndroidConfig.builder().setPriority(AndroidConfig.Priority.HIGH).build())
                    .build();
            BatchResponse response = this.firebaseMessaging.sendMulticast(message);

            // TODO: 전송에 실패한 Response 처리
            response.getResponses().stream()
                    .filter(Predicate.not(SendResponse::isSuccessful))
                    .forEach(sendResponse -> log.error("failedResponse exception:", sendResponse.getException()));
        } catch (FirebaseMessagingException e) {
            // TODO: 커스텀 예외 처리
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendNotification(List<String> pushTokens, PushNotification notification, PushData data) {
        try {
            MulticastMessage message = MulticastMessage.builder()
                    .addAllTokens(pushTokens)
                    .setNotification(Notification.builder()
                            .setTitle(notification.getTitle())
                            .setBody(notification.getContent())
                            .setImage(notification.getImageUrl())
                            .build())
                    .putAllData(data.toMap())
                    .setAndroidConfig(AndroidConfig.builder().setPriority(AndroidConfig.Priority.HIGH).build())
                    .build();
            BatchResponse response = this.firebaseMessaging.sendMulticast(message);

            // TODO: 전송에 실패한 Response 처리
            response.getResponses().stream()
                    .filter(Predicate.not(SendResponse::isSuccessful))
                    .forEach(sendResponse -> log.error("failedResponse exception:", sendResponse.getException()));
        } catch (JsonProcessingException | FirebaseMessagingException e) {
            // TODO: 커스텀 예외 처리
            throw new RuntimeException(e);
        }
    }
}
