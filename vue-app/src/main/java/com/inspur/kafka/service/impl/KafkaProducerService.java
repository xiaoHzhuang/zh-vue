package com.inspur.kafka.service.impl;

import com.inspur.kafka.service.IKafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class KafkaProducerService implements IKafkaProducerService {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void sendMessage(String normalMessage) {
        kafkaTemplate.send("testTopic", normalMessage);
    }
}
