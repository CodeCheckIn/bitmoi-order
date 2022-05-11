package com.bitmoi.order.router;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@EnableTransactionManagement
@EnableR2dbcRepositories
public class ApplicationConfig extends AbstractR2dbcConfiguration{
    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
//        return new H2ConnectionFactory(
//                H2ConnectionConfiguration.builder()
//                        //.inMemory("testdb")
//                        .file("./testdb")
//                        .username("user")
//                        .password("password").build()
//        );

        String url = "r2dbc:mysql://root:00000000@localhost:13306/msa";
        ConnectionFactory connectionFactory = ConnectionFactories.get(url);
        return connectionFactory;
//        return H2ConnectionFactory.inMemory("msa");
    }

    @Bean
    ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
        return new R2dbcTransactionManager(connectionFactory);
    }



//     @NotNull
//     private Flux<Order> insertOrderFlux(OrderService service, List<String> orderList) {
//         return Flux.fromIterable(orderList)
//                 .map(String::toLowerCase)
//                 .map(Order::new)
//                 .flatMap(order -> {
//                     return service.orderBid((Order) order);
//                 });
//     }


}
