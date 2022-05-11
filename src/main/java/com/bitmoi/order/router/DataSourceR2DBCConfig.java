 package com.bitmoi.order.router;

 import io.r2dbc.spi.ConnectionFactory;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.core.io.ClassPathResource;
 import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
 import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
 import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

 @Configuration
 public class DataSourceR2DBCConfig {

//     @Value("${db.mysql.host}")
//     private String host;
//
//     @Value("${db.mysql.port}")
//     private int port;
//
//     @Value("${db.mysql.username}")
//     private String user;
//
//     @Value("${db.mysql.password}")
//     private String password;
//
//     @Value("${db.mysql.database}")
//     private String database;


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
//
//     @Bean
//     public DatabaseClient createDataBase(ConnectionFactory connection) {
//         return DatabaseClient.create(connection);
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
