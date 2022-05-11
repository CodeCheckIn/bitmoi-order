//package com.bitmoi.order.router;
//
//import io.r2dbc.h2.H2ConnectionConfiguration;
//import io.r2dbc.h2.H2ConnectionFactory;
//import io.r2dbc.spi.ConnectionFactories;
//import io.r2dbc.spi.ConnectionFactory;
//import io.r2dbc.spi.ConnectionFactoryOptions;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
//import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
//import org.springframework.r2dbc.connection.R2dbcTransactionManager;
//import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
//import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
//import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
//import org.springframework.transaction.ReactiveTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import static io.r2dbc.spi.ConnectionFactoryOptions.*;
//
//@Configuration
////@EnableTransactionManagement
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
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        return ConnectionFactories.get(builder()
//                .option(DRIVER, "mysql")
//                .option(HOST, host)
//                .option(PORT, port)
//                .option(USER, user)
//                .option(PASSWORD, password)
//                .option(DATABASE, database)
//                .build());
//    }
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
////    @Override
////    @Bean
////    public ConnectionFactory connectionFactory() {
//////        return new H2ConnectionFactory(
//////                H2ConnectionConfiguration.builder()
//////                        //.inMemory("testdb")
//////                        .file("./testdb")
//////                        .username("user")
//////                        .password("password").build()
//////        );
////
//////        String url = "r2dbc:mysql://root:00000000@localhost:13306/msa";
//////        ConnectionFactory connectionFactory = ConnectionFactories.get(url);
//////        return connectionFactory;
////        return H2ConnectionFactory.inMemory("msa");
////    }
//
////    @Bean
////    ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
////        return new R2dbcTransactionManager(connectionFactory);
////    }
//
//
//
//    @Bean
//    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
//        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
//        initializer.setConnectionFactory(connectionFactory);
//        CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
//        populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
//        initializer.setDatabasePopulator(populator);
//        return initializer;
//    }
//
//
//
//}
