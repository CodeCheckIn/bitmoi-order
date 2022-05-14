package com.bitmoi.order.service;

import com.bitmoi.order.domain.Orderbook;
import com.bitmoi.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    //매매 전체 목록
    @Override
    public Flux<Orderbook> getOrderList(){
        return this.orderRepository.findAll();
    }

    //매매 주문하기
    @Override
    public Mono<Orderbook> orderBidnAsk(Orderbook orderbook){
        return this.orderRepository.save(orderbook);
    }

    //주문 취소
    @Override
    public Mono<Orderbook> OrderCancel(Integer id){
        orderRepository.updateisExecute(id);
        return this.orderRepository.findById(id);
    }


}
