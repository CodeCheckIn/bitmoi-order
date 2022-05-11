//package com.bitmoi.order.router;
//
//import io.r2dbc.h2.H2ConnectionConfiguration;
//import io.r2dbc.h2.H2ConnectionFactory;
//import io.r2dbc.h2.H2ConnectionOption;
//import io.r2dbc.spi.ConnectionFactories;
//import io.r2dbc.spi.ConnectionFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
//import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
//import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
//import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
//import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
//import org.springframework.r2dbc.core.DatabaseClient;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableR2dbcRepositories
//@EnableTransactionManagement
//@RequiredArgsConstructor
//public class R2dbcConfig extends AbstractR2dbcConfiguration {
//   //localhost9093접속->jdbc:h2:mem:msa 유저 sa 연결(embeded h2)
//   @Override
//   public ConnectionFactory connectionFactory() {
//       return new H2ConnectionFactory(H2ConnectionConfiguration.builder()
//               .inMemory("msa")
//               .property(H2ConnectionOption.DB_CLOSE_DELAY, "-1") // DB연결이 닫혀도 유지되도록 설정
//               .username("sa")
//               .build());
//   }
//
//
//   @Bean
//   public ConnectionFactoryInitializer h2DbInitializer() {
//       ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
//       ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
//
//       CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
//       populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema1.sql")));
//
////        resourceDatabasePopulator.addScript(new ClassPathResource("schema1.sql"));
//
//       initializer.setConnectionFactory(connectionFactory());
//       initializer.setDatabasePopulator(resourceDatabasePopulator);
//       initializer.setDatabasePopulator(populator);
//       return initializer;
//   }
//
////    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
////
////            ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
////            initializer.setConnectionFactory(connectionFactory);
////
////            CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
////            populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema1.sql")));
////            populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("data.sql")));
////            initializer.setDatabasePopulator(populator);
////
////            return initializer;
////        }
//
//
//}
