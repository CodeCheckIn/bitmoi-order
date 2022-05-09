package com.bitmoi.order.handler;


import com.bitmoi.order.domain.Order;
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


    // 매매 주문 목록
    public Mono<ServerResponse> getOrderList(ServerRequest request){
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

//    public Mono<ServerResponse> insertBoard(ServerRequest request) {
//        Mono<Board> communityMono = request.bodyToMono(Board.class)
//                .flatMap(board -> boardService.insertCommunity(board))
//                .log("CommunityMono is : ");
//        producerService.sendMessage("create board");
//
//        return ok()
//                .contentType(APPLICATION_JSON)
//                .body(communityMono, Board.class).log("insertCommunity is : ");
//    }



    //주문 취소
    public Mono<ServerResponse> getOrderId(ServerRequest request){
        Long orderid = Long.valueOf(request.pathVariable("orderid"));
//        Mono<Order> orderMono = request.bodyToMono(Order.class);
        Mono<Order> orderMono = orderService.getOrderId(orderid);
//        Order order = new Order(id,"cancle");

        return ok()
                .contentType(APPLICATION_JSON)
                .body(orderMono, Order.class).log("getOrderId is : ");
    }





}
