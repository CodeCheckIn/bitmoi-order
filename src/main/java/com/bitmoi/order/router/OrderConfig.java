package com.bitmoi.order.router;

import com.bitmoi.order.handler.OrderHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
@EnableWebFlux
public class OrderConfig {

    @Bean
    public RouterFunction<ServerResponse> route(OrderHandler handler) {
        return RouterFunctions
                .route()
                .GET("/orderbook", handler::getOrderList) // 매매 목록 확인
                .POST("/orders", handler::orderBidnAsk) // 매매 주문
                .POST("/order/cancel/{orderid}", handler::OrderCancel) // 주문 취소
                .build();
    }
}
