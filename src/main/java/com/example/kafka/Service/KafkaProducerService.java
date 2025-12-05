package com.example.kafka.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.example.kafka.modal.Message;


@Service
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    private static final String TOPIC = "Driver-Location";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void send(String messageId, String messageContent, String sender) {
        Message message = new Message(messageId, messageContent, sender);
        sendMessage(message);
    }

    public void sendMessage(Message message) {

        logger.info("Sending message to topic: {}", TOPIC);

        CompletableFuture<SendResult<String, Object>> future =
                kafkaTemplate.send(TOPIC, message.getId(), message);

        future.whenComplete((result, exception) -> {

            if (exception != null) {
                logger.error("Failed to send message: {}", exception.getMessage());
            } else {
                logger.info("Message sent successfully! Offset: {}",
                        result.getRecordMetadata().offset());
            }
        });
    }
}
