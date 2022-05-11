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

    //매매 전체 목록
    @Override
    public Flux<Order> getOrderList(){
        return this.orderRepository.findByOrderidList();
    }


    //매수 주문하기
    @Override
    public Mono<Order> orderBid(Order order){
        return this.orderRepository.save(order);
    }


    @Override
    public Mono<Order> orderBid1(Order order){

        Integer userId = order.getUserid();
        Integer coinId = order.getCoinid();
        Float price = order.getPrice();
        Float quantity = order.getQuantity();
        String types = order.getTypes();

        return this.orderRepository.saveAllByOrder(userId,coinId,price,quantity,types);
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
    public Mono<Order> OrderCancel(Integer id){
        return this.orderRepository.updateisExecute(id);
    }




}
