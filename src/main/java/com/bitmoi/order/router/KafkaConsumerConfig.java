//package com.bitmoi.order.router;
//
//import com.bitmoi.order.domain.Orderbook;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@EnableKafka
//public class KafkaConsumerConfig {
//    @Value("${spring.kafka.consumer.bootstrap-servers}")
//    private String BOOTSTRAP_SERVER;
//
//    @Value("${spring.kafka.consumer.group-id}")
//    private String KAFKA_GROUPID;
//
//    @Bean
//    public ConsumerFactory<String, Orderbook> getConsumerProps() {
//
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
//        configs.put(ConsumerConfig.GROUP_ID_CONFIG, KAFKA_GROUPID);
//
//        return new DefaultKafkaConsumerFactory<>(
//                configs,
//                new StringDeserializer(),
////                new JsonDeserializer<>(Object.class)),
//        new ErrorHandlingDeserializer(new JsonDeserializer<>(Orderbook.class)))
//                ;
//    }
//
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, Orderbook> consumerListener() {
//        ConcurrentKafkaListenerContainerFactory<String, Orderbook> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(getConsumerProps());
//        return factory;
//    }
//
//
//}
