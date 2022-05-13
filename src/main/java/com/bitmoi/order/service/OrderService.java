package com.bitmoi.order.service;

import com.bitmoi.order.domain.Orderbook;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {

    // 주문 전체 목록
    Flux<Orderbook> getOrderList();

    // 매매 주문하기
    Mono<Orderbook> orderBidnAsk(Orderbook orderbook);

    //주문 취소
    Mono<Orderbook> OrderCancel(Integer id);

}
