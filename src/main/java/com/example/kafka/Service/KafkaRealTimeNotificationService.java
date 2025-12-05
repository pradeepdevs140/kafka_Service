package com.example.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.example.kafka.modal.Message;



@Service
public class KafkaRealTimeNotificationService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaRealTimeNotificationService.class);

    @KafkaListener(
            topics = "Driver-Location",
            groupId = "demo-group"
    )
    public void listen(
            @Payload Message message,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
            @Header(KafkaHeaders.OFFSET) long offset
    ) {

        logger.info("Message Received → topic: {}, partition: {}, offset: {}",
                topic, partition, offset);

        logger.info("Message Content → {}", message);

        try {
            processRealTimeNotification(message);
            logger.info("Message processed successfully.");
        }
        catch (Exception e) {
            logger.error("Message processing failed → {}", e.getMessage());
        }
    }

    public void processRealTimeNotification(Message message) {
        try {
            // Simulate processing time
            Thread.sleep(100);
        } 
        catch (InterruptedException error) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Processing interrupted", error);
        }
    }
}
