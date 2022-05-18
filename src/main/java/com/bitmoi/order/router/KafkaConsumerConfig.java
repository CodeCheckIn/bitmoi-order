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
//    @Value("{spring.kafka.consumer.auto-offset-reset}")
//    private String RESET_CONFIG;
//
//    @Bean
//    public ConsumerFactory<String, Object> getConsumerProps() {
//
//        JsonDeserializer<Object> deserializer = new JsonDeserializer<>(Object.class,false);
//        deserializer.setRemoveTypeHeaders(false);
//        deserializer.addTrustedPackages("*");
//        deserializer.setUseTypeMapperForKey(true);
//
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, KAFKA_GROUPID);
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
//        return new DefaultKafkaConsumerFactory<>(
//                props,
//                new StringDeserializer(),
//                deserializer);
//    }
//
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, Object> consumerListener() {
//        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(getConsumerProps());
//        return factory;
//    }
//
//
//}
