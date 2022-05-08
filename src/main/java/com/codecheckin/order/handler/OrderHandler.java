package com.codecheckin.order.handler;


import com.codecheckin.order.domain.Order;
import com.codecheckin.order.repository.OrderRepository;
import com.codecheckin.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.management.monitor.MonitorNotification;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class OrderHandler {

    private final OrderRepository orderRepository;


    // 매매 주문 목록
    public Mono<ServerResponse> getOrderbookList(ServerRequest request){

        Flux<Order> orderFlux = request.bodyToFlux(Order.class);


        return ok()
                .contentType(APPLICATION_JSON)
                .body(orderFlux, Order.class).log("getOrderbookList is : ");
    }


    // 매수 주문하기
    public Mono<ServerResponse> orderBid(ServerRequest request){
        Mono<Order> orderMono = request.bodyToMono(Order.class);

        return ok()
                .contentType(APPLICATION_JSON)
                .body(orderMono, Order.class).log("orderBid is : ");
    }



    //주문 취소
    public Mono<ServerResponse> getOrderId(ServerRequest request){
        Integer id = Integer.valueOf(request.pathVariable("id"));
        Mono<Order> orderMono = request.bodyToMono(Order.class);
//        Order order = new Order(id,"cancle");

        return ok()
                .contentType(APPLICATION_JSON)
                .body(orderMono, Order.class).log("getOrderId is : ");
    }





}
