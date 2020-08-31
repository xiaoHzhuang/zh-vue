package com.inspur.kafka.controller;

import com.inspur.kafka.service.IKafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafkaProducer")
public class KafkaProducerController {

    @Autowired
    private IKafkaProducerService KafkaProducerService;

    // 发送消息
    @GetMapping("/normal/{message}")
    public void sendMessage(@PathVariable("message") String normalMessage) {
          KafkaProducerService.sendMessage(normalMessage);
    }

}