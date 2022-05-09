package com.bitmoi.order.router;

import com.bitmoi.order.handler.OrderHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class OrderConfig {

    @Bean
    public RouterFunction<ServerResponse> route(OrderHandler handler) {
        return RouterFunctions.route()
                .GET("/orderbook", handler::getOrderbookList)
//                .POST("/order/bid", handler::orderBid)
//                .POST("/order/bid", handler::orderAsk)
//                .POST("/order/cancel/", request -> handler.getOrderId(request))
                .build();
    }
}
