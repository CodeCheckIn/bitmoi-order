package com.bitmoi.order.service;

import com.bitmoi.order.domain.Order;
import reactor.core.publisher.Mono;

public interface OrderService {

    Mono<Order> getOrder();
}
