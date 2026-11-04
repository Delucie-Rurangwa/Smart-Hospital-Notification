package org.example;

import org.springframework.context.annotation.Primary;

@Primary
public class EmailNotificationService implements NotificationService{
    @Override
    public void sendNotification(String patientId, String message) {

    }
}
