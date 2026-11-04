package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PatientAlertProcessor {

    @Autowired
    @Qualifier("smsService")
    private NotificationService defaultNotificationService;

    // Specific Channel Injection for emergency alerts using @Qualifier
    @Autowired
    @Qualifier("emergencyService")
    private NotificationService emergencyNotificationService;

    @Value("${hospital.name:General City Hospital}")
    private String hospitalName;

    @Value("${HOSPITAL_API_SECRET}")
    private String hospitalApiSecret;

    public void processDefaultAlert(String patientId, String message) {
        System.out.println("--- Hospital: " + hospitalName + " ---");
        defaultNotificationService.sendNotification(patientId, message);
    }

    public void processEmergencyAlert(String patientId, String message) {
        System.out.println("--- Hospital: " + hospitalName + " [API Key Loaded Securely] ---");
        emergencyNotificationService.sendNotification(patientId, message);
    }
}