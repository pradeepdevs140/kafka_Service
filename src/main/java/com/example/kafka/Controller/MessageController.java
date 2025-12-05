package com.example.kafka.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.dto.MessageRequest;
import com.example.kafka.service.KafkaProducerService;

@RestController
@RequestMapping("/api/user")
public class MessageController {
	@Autowired
	private KafkaProducerService kafkaProducerService;
	
	@GetMapping("/checkhealth")
	public ResponseEntity<String> check(){
		return ResponseEntity.ok("Kafka runnning....");
		}
	
@PostMapping("/sendmessage")
public ResponseEntity<String> sendMessage(@RequestBody MessageRequest message){
	String messageId = UUID.randomUUID().toString();
	kafkaProducerService.send(messageId , message.getMessagecontent(), message.getSender());
	return ResponseEntity.ok("Messgae send with id ");
	
}

}
