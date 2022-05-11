//package com.bitmoi.order.router;
//
//import io.r2dbc.spi.ConnectionFactories;
//import io.r2dbc.spi.ConnectionFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
//import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
//import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
//import org.springframework.r2dbc.connection.R2dbcTransactionManager;
//import org.springframework.r2dbc.core.DatabaseClient;
//import org.springframework.transaction.ReactiveTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@EnableR2dbcRepositories
//public class ApplicationConfig extends AbstractR2dbcConfiguration {
//
//    @Value("localhost")
//    private String host;
//
//    @Value("${spring.r2dbc.port}")
//    private int port;
//
//    @Value("${spring.r2dbc.username}")
//    private String user;
//
//    @Value("${spring.r2dbc.password}")
//    private String password;
//
//    @Value("msa")
//    private String database;
//
//
////    private final ConnectionFactory connectionFactory;
////    private final DatabaseClient databaseClient;
////    private final R2dbcEntityTemplate r2dbcEntityTemplate;
////
////    public ApplicationConfig(ConnectionFactory connectionFactory, DatabaseClient databaseClient, R2dbcEntityTemplate r2dbcEntityTemplate) {
////        this.connectionFactory = connectionFactory;
////        this.databaseClient = databaseClient;
////        this.r2dbcEntityTemplate = r2dbcEntityTemplate;
////    }
//
////    DatabaseClient.create(connectionFactory);
////    R2dbcEntityTemplate(datadaseClient);
//
////    @Bean
////    public ConnectionFactory connectionFactory() {
////        return ConnectionFactories.get(builder()
////                .option(DRIVER, "mysql")
////                .option(HOST, host)
////                .option(PORT, port)
////                .option(USER, user)
////                .option(PASSWORD, password)
////                .option(DATABASE, database)
////                .build());
////    }
//
//
//    @Override
//    @Bean("customR2ConnectionFactory")
//    @Primary
//    public ConnectionFactory connectionFactory() {
//        String url = "r2dbc:mysql://bitmoi:bitmoi6!@localhost:3306/msa";
//        ConnectionFactory connectionFactory = ConnectionFactories.get(url);
//        return connectionFactory;
//    }
//
//
////    @Bean
////    public H2ConnectionFactory connectionFactory() {
////        return new H2ConnectionFactory(
////                H2ConnectionConfiguration.builder()
////                        .url("mem:msa;DB_CLOSE_DELAY=-1;")
////                        .username("sa")
////                        .build()
////        );
////    }
//
//
//    @Bean
//    ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
//        return new R2dbcTransactionManager(connectionFactory);
//    }
//
//
////    @Bean
////    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
////        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
////        initializer.setConnectionFactory(connectionFactory);
////        CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
////        populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
////        initializer.setDatabasePopulator(populator);
////        return initializer;
////    }
//
//
//}
