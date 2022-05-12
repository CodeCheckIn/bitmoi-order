package com.bitmoi.order.handler;

import com.bitmoi.order.domain.Order;
import com.bitmoi.order.kafka.KafkaProducerService;
import com.bitmoi.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

//    @Autowired
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


    // 매수 주문하기
    public Mono<ServerResponse> orderBid(ServerRequest request) {
        Mono<Order> orderMono = request.bodyToMono(Order.class)
                .flatMap(order -> {
//                    kafkaProducerService.saveBidMessage(order);
                    return orderService.orderBid(order);
                })
                .subscribeOn(Schedulers.parallel())
                .log("orderBid --------- ");

        return ok()
//                .contentType(APPLICATION_JSON)
                .body(orderMono, Order.class)
                .onErrorResume(error -> ServerResponse.badRequest().build())
                .log("orderBid ok --------- ");
    }

    // 매도 주문하기
    public Mono<ServerResponse> orderAsk(ServerRequest request) {
        Mono<Order> orderMono = request.bodyToMono(Order.class)
                .flatMap(order -> {
                    kafkaProducerService.saveBidMessage(order);
                    return orderService.orderAsk(order);
                })
                .subscribeOn(Schedulers.parallel())
                .log("orderAsk --------- ");

        return ok()
//                .contentType(APPLICATION_JSON)
                .body(orderMono, Order.class)
                .onErrorResume(error -> ServerResponse.badRequest().build())
                .log("orderAsk ok --------- ");
    }


    // 매수 & 매도 주문하기
//    public Mono<ServerResponse> orderBidAsk(ServerRequest request) {
//        Mono<Order> orderMono = request.bodyToMono(Order.class)
//                .flatMap(order -> {
//                    kafkaProducerService.saveBidMessage(order);
//                    if(order.getTypes() == "bid"){ //매수
//                        return orderService.orderBid(order);
//                    }else if(order.getTypes() == "ask"){
//                        return orderService.orderAsk(order);
//                    }
//                    return orderService.orderBid(order);
//                })
//                .subscribeOn(Schedulers.parallel())
//                .log("orderBidAsk --------- ");
//
//        return ok()
////                .contentType(APPLICATION_JSON)
//                .body(orderMono, Order.class)
//                .onErrorResume(error -> ServerResponse.badRequest().build())
//                .log("orderBidAsk ok --------- ");
//    }



    //주문 취소
    public Mono<ServerResponse> OrderCancel(ServerRequest request) {
        Integer orderid = Integer.valueOf(request.pathVariable("orderid"));
        Mono<Order> orderMono = orderService.OrderCancel(orderid);
        logger.debug("orderMono > " + String.valueOf(orderMono));
        logger.debug("orderid > " + String.valueOf(orderid));

        return ok()
                .contentType(APPLICATION_JSON)
                .body(orderMono, Order.class)
                .log("getOrderId ok --------- ");
    }


}
