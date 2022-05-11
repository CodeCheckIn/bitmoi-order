package com.bitmoi.order.kafka;

import com.bitmoi.order.domain.Order;
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

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate1;



    //
    public void saveBidMessage(Order order){
        logger.info(String.format("saveBidMessage created -> %s", order));
        this.kafkaTemplate1.send(TOPIC_BID,order);
    }


    public void sendAskMessage(String message) {
        logger.info(String.format("Producing Ask message -> %s", message));
        this.kafkaTemplate.send(TOPIC_ASK, message);
    }




    @Autowired
    public KafkaProducerService(KafkaTemplate<String, Order> kafkaTemplate1) {
        this.kafkaTemplate = kafkaTemplate;
    }
    //
    //    public void sendMessage(String message) {
    //
    //        Order order = Order.builder()
    //                .yyyymmdd("2021-01-01")
    //                .skuCd("10300000033")
    //                .fieldName("ipgoNo")
    //                .diff(100)
    //                .build();
    //
    //        // Send a message
    //        kafkaTemplate.send(TOPIC, order);
    //    }

}
