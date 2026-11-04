package org.example;

import org.springframework.stereotype.Component;

@Component("emergencyService")
public class EmergencyUrgentNotificationService implements  NotificationService {
    @Override
    public void sendNotification(String patientId, String message) {

    }
}
