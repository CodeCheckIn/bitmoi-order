package com.bitmoi.order.handler;


import com.bitmoi.order.domain.Order;
import com.bitmoi.order.kafka.KafkaProducerService;
import com.bitmoi.order.repository.OrderRepository;
import com.bitmoi.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class OrderHandler {

    private final OrderService orderService;
    private final KafkaProducerService kafkaProducerService;

    // 매매 주문 목록
    public Mono<ServerResponse> getOrderList(ServerRequest request){
        Flux<Order> orderFlux = request.bodyToFlux(Order.class);

        return ok()
                .contentType(APPLICATION_JSON)
                .body(orderFlux, Order.class)
                .log("getOrderbookList ok --------- ");
    }


    // 매수 주문하기
    public Mono<ServerResponse> orderBid(ServerRequest request){
        Mono<Order> orderMono = request.bodyToMono(Order.class)
                .log("orderBid --------- ");

//        Order orderbid = new Order();

       kafkaProducerService.sendBidMessage("order");
//        kafkaProducerService.saveBidMessage1("",orderService.orderBid(order));

        return ok()
                .contentType(APPLICATION_JSON)
                .body(orderMono, Order.class)
                .log("orderBid ok --------- ");
    }


    //주문 취소
    public Mono<ServerResponse> getOrderId(ServerRequest request){
        Long orderid = Long.valueOf(request.pathVariable("orderid"));
//        Mono<Order> orderMono = request.bodyToMono(Order.class);
        Mono<Order> orderMono = orderService.getOrderId(orderid);
//        Order order = new Order(id,"cancle");

        return ok()
                .contentType(APPLICATION_JSON)
                .body(orderMono, Order.class)
                .log("getOrderId ok --------- ");
    }



}
