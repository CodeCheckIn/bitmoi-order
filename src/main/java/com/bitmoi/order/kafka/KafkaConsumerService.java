//package com.bitmoi.order.kafka;
//
//import com.bitmoi.order.domain.Orderbook;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class KafkaConsumerService {
//    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);
//
//    @KafkaListener(topics = "bitmoi-order", groupId = "bitmoi", containerFactory = "consumerListener")
//    public void consumeOrder(Orderbook orderbook) {
//        logger.info(String.format("consumeOrder Orderbook message -> %s", orderbook));
//        System.out.println("orderbook > "+orderbook);
//    }
//
//
//    @KafkaListener(topics = "order-bid", groupId = "bitmoi")
//    public void consumeBid(String message) {
//        logger.info(String.format("Consumed Bid message -> %s", message));
//    }
//
//    @KafkaListener(topics = "order-ask", groupId = "bitmoi")
//    public void consumeAsk(String message) {
//        logger.info(String.format("Consumed Ask message -> %s", message));
//    }
//
//
//}