package com.bitmoi.order.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
    private static final String TOPIC_BID = "order-bid";
    private static final String TOPIC_ASK = "order-ask";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendBidMessage(String message) {
        logger.info(String.format("Producing Bid message -> %s", message));
        this.kafkaTemplate.send(TOPIC_BID, message);
    }

    public void sendAskMessage(String message) {
        logger.info(String.format("Producing Ask message -> %s", message));
        this.kafkaTemplate.send(TOPIC_ASK, message);
    }


}
