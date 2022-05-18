//package com.bitmoi.order.kafka;
//
//import com.bitmoi.order.domain.Orderbook;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.messaging.MessageHeaders;
//import org.springframework.messaging.handler.annotation.Headers;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class KafkaConsumerService {
//    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);
//
//    @KafkaListener(topics = "bitmoi-order", groupId = "bitmoi"
//            , containerFactory = "consumerListener"
//    )
//    public void consumeOrder( Orderbook orderbook) {
//        //@Headers MessageHeaders messageHeaders,
//        logger.info(String.format("------- consumeOrder Orderbook message -> %s", orderbook));
//        System.out.println("------- consumeOrder orderbook > " + orderbook);
////        System.out.println("messageHeaders > " + messageHeaders);
//    }
//
//
//    @KafkaListener(topics = "bitmoi-order", groupId = "bitmoi")
//    public void consume(@Headers MessageHeaders headers, @Payload(required = false) Object payload) {
//        System.out.println("CONSUME HEADERS : " + headers.toString());
//        System.out.println("CONSUME PAYLOAD : " + payload);
//        headers.keySet().forEach(key -> {
//            System.out.println("key >"+key +" , get(key) > "+ headers.get(key));
//        });
//    }
//
//
//}