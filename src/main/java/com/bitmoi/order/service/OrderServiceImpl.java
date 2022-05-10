package com.bitmoi.order.service;

import com.bitmoi.order.domain.Order;
import com.bitmoi.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //주문 전체 목록
    @Override
    public Flux<Order> getOrderList(){
        return this.orderRepository.findAll();
    }


    //매수 주문하기
    @Override
    public Mono<Order> orderBid(Order order){
        return this.orderRepository.save(order);
    }


    //주문 취소
    @Override
    public Mono<Order> getOrderId(Long id){
        return this.orderRepository.findById(id);
    }




}
