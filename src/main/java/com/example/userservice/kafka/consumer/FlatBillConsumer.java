package com.example.userservice.kafka.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FlatBillConsumer {

    private static final Logger logger = LoggerFactory.getLogger(FlatBillConsumer.class);

    @KafkaListener(topics = "billTopic", groupId = "bill-group")
    public void consume(String message) {
        logger.info("Consumed message "+ message);
    }
}
