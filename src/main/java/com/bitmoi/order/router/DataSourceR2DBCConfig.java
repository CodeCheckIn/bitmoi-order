package com.bitmoi.order.router;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import lombok.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableR2dbcRepositories
@EnableTransactionManagement
public class DataSourceR2DBCConfig extends AbstractR2dbcConfiguration {

//    String url = "r2dbcs:mysql://user:user@localhost:3306/test";
//    ConnectionFactory connectionFactory = ConnectionFactories.get(url);
//    DatabaseClient client = DatabaseClient.create(connectionFactory);

    @NonNull
    @Override
    @Bean("customR2ConnectionFactory")
    @Primary
    public ConnectionFactory connectionFactory() {
        String url = "r2dbc:mysql://bitmoi:bitmoi6!@localhost:3306/msa?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Seoul";
        ConnectionFactory connectionFactory = ConnectionFactories.get(url);
        return connectionFactory;
    }

    

//    @Override
//    @Bean("customR2ConnectionFactory")
//    @Primary
//    public ConnectionFactory connectionFactory() {
//        return ConnectionFactories.get("r2dbc:mysql://root:password_insert@127.0.0.1:3306/my_db?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Seoul");
//    }

    @Bean
    ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
        return new R2dbcTransactionManager(connectionFactory);
    }

}
