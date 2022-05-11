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


    //매도 주문하기
    @Override
    public Mono<Order> orderAsk(Order order){
        return this.orderRepository.save(order);
    }


    //시장가로 매수 주문하기
//    @Override
//    public Mono<Order> orderBidNow(Order order){
//        //시장가 주문 여부 true
//        order.setIsmarketprice(1);
//
//        return this.orderRepository.save(order);
//    }


    //주문 취소
    @Override
    public Mono<Order> getOrderId(Integer id){
        //주문 상태 취소로 변경
        //setTypes("cancel")

        return this.orderRepository.findById(id);
    }




}
