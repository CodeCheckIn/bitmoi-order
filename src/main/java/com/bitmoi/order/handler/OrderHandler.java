package com.bitmoi.order.handler;

import com.bitmoi.order.domain.Order;
//import com.bitmoi.order.kafka.KafkaProducerService;
import com.bitmoi.order.kafka.KafkaProducerService;
import com.bitmoi.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class OrderHandler {

    private final Logger logger = LoggerFactory.getLogger(OrderHandler.class);

    @Autowired
    private final OrderService orderService;
    private final KafkaProducerService kafkaProducerService;

    // 매매 주문 목록
    public Mono<ServerResponse> getOrderList(ServerRequest request) {
        Flux<Order> orderFlux = orderService.getOrderList();
        return ok()
                .contentType(APPLICATION_JSON)
                .body(orderFlux, Order.class)
                .log("getOrderbookList ok --------- ");

    }


//    public Mono<ServerResponse> orderBid1(ServerRequest request) {
//        Mono<Order> PostMono = request.bodyToMono(Order.class);
////        kafkaProducerService.sendBidMessage("order");
//
//        // orderService.orderBid(OrderMono);
//        return PostMono.just(PostMono)
//                .flatMap(order ->
//                ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
//                        .bodyValue(order));
//    }



    // 매수 주문하기
    public Mono<ServerResponse> orderBid(ServerRequest request) {
        Mono<Order> orderMono = request.bodyToMono(Order.class)
                .flatMap(order -> {
//                    order.setIsmarketprice(1);
                    kafkaProducerService.saveBidMessage1(order);
                    kafkaProducerService.sendBidMessage("order");

                    return orderService.orderBid(order);
                })
                .subscribeOn(Schedulers.parallel())
                .log("orderBid --------- ");

        kafkaProducerService.sendBidMessage("order");

        return ok()
//                .contentType(APPLICATION_JSON)
                .body(orderMono, Order.class)
                .onErrorResume(error -> ServerResponse.badRequest().build())
                .log("orderBid ok --------- ");
    }



    //주문 취소
    public Mono<ServerResponse> getOrderId(ServerRequest request) {
        Integer orderid = Integer.valueOf(request.pathVariable("orderid"));
//        Mono<Order> orderMono = request.bodyToMono(Order.class);
        Mono<Order> orderMono = orderService.getOrderId(orderid);
//        Order order = new Order(id,"cancle");
        logger.debug("orderMono > " + String.valueOf(orderMono));
        logger.debug("orderid > " + String.valueOf(orderid));

        return ok()
                .contentType(APPLICATION_JSON)
                .body(orderMono, Order.class)
                .log("getOrderId ok --------- ");
    }


}
