package com.bitmoi.order.service;

import com.bitmoi.order.domain.Order;
import jdk.jfr.FlightRecorder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {

    // 주문 전체 목록
    Flux<Order> getOrderList();

    // 매수 주문하기 (시장가)
    Mono<Order> orderBid(Order order);

    // 매도 주문하기
    Mono<Order> orderAsk(Order order);


    // 시장가로 매수 주문하기
//    Mono<Order> orderBidNow(Order order);


    //주문 취소
    Mono<Order> getOrderId(Integer id);
}
