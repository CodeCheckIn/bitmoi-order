package com.bitmoi.order.service;

import com.bitmoi.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


//        public Mono<Board> getBoardOne(String boardid) {
//        return this.boardRepository.findById(boardid);
//    }


}
