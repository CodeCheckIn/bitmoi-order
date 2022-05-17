package com.bitmoi.order.kafka;

import com.bitmoi.order.domain.Orderbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
    private static final String TOPIC_ORDER = "bitmoi-order";

    @Autowired
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    //주문 관련된 메시지
    public void sendOrderMessage(Orderbook data) {
        Message<Orderbook> order_message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, TOPIC_ORDER)
                .build();

//        Orderbook orderbook = Orderbook.builder()
//                .userid(data.getUserid())
//                .coinid(data.getCoinid())
//                .build();
        logger.info("!!sendOrderMessage send to topic={}, message={},", TOPIC_ORDER, data);
        kafkaTemplate.send(order_message);
    }


}
