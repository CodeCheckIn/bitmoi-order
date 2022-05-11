 package com.bitmoi.order.router;

 import io.r2dbc.spi.ConnectionFactories;
 import io.r2dbc.spi.ConnectionFactory;
 import io.r2dbc.spi.ConnectionFactoryOptions;
 import org.springframework.beans.factory.annotation.Value;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.core.io.ClassPathResource;
 import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
 import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
 import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

 import static io.r2dbc.spi.ConnectionFactoryOptions.*;

 @Configuration
 public class DataSourceR2DBCConfig {

//     @Value("localhost")
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


//     @Bean
//     public ConnectionFactory connectionFactory(){
//         return ConnectionFactories.get(ConnectionFactoryOptions.builder()
//                 .option(DRIVER,"mysql")
//                 .option(HOST,host)
//                 .option(PORT, port)
//                 .option(USER,user)
//                 .option(PASSWORD, password)
//                 .option(DATABASE, database)
//                 .build());
//     }

//     @Bean
//     ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
//         ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
//         initializer.setConnectionFactory(connectionFactory);
////         initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema1.sql")));
//         return initializer;
//     }


     @Bean
     public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
         ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
         initializer.setConnectionFactory(connectionFactory);
         CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
         populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
         initializer.setDatabasePopulator(populator);
         return initializer;
     }

 }
