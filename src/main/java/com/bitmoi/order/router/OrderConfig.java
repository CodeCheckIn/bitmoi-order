package com.bitmoi.order.router;

import com.bitmoi.order.handler.OrderHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class OrderConfig {

    @Bean
    public RouterFunction<ServerResponse> route(OrderHandler handler) {
        return RouterFunctions
                .route(GET("/orderbook"), handler::getOrderList) //
                .andRoute(POST("/order/bid"), handler::orderBid) //
//                .andRoute(POST("/order/cancel/{orderid}").and(accept(MediaType.APPLICATION_JSON)), handler::getOrderId) //

//                .route()
//                .GET("/orderbook", handler::getOrderList)
//                .POST("/order/bid",handler::orderBid)
////                .POST("/order/ask", accept(MediaType.APPLICATION_JSON), handler::orderAsk)
//                .POST("/order/cancel/{orderid}", request -> handler.getOrderId(request))
//                .build()
                ;


    }
}
