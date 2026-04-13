package com.example.auth.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUserCreatedEvent(String email, String role) {

        String message = "USER_CREATED:" + email + ":" + role;

        kafkaTemplate.send("user-events", message);

        System.out.println("Event sent -> " + message);
    }
}