package com.inspur.kafka.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface IKafkaProducerService {

    void sendMessage(@PathVariable("message") String normalMessage);
}
