//package com.bitmoi.order.router;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@EnableKafka
//@Configuration
//public class KafkaConsumerConfig {
//    @Value("${spring.kafka.consumer.bootstrap-servers}")
//    private String BOOTSTRAP_SERVER;
//
//    @Value("${spring.kafka.consumer.group-id}")
//    private String KAFKA_GROUPID;
//
//    //    @Bean
////    ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
////        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
////        factory.setConcurrency(1);
//////        factory.setConsumerFactory(new DefaultKafkaConsumerFactory(getConfig()));
////        factory.setBatchListener(true);
////        return factory;
////    }
//
//    @Bean
//    public Map<String, Object> getConsumerProps() {
//        return new HashMap<>() {{
//            put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
//            put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//            put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//            put(ConsumerConfig.GROUP_ID_CONFIG, KAFKA_GROUPID);
//        }};
//    }
//}
