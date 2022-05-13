package com.bitmoi.order.handler;

import com.bitmoi.order.domain.Orderbook;
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
        Flux<Orderbook> orderFlux = orderService.getOrderList();
        return ok()
                .contentType(APPLICATION_JSON)
                .body(orderFlux, Orderbook.class)
                .log("getOrderbookList ok --------- ");
    }


    // 매매 주문하기
    public Mono<ServerResponse> orderBidnAsk(ServerRequest request) {
        Mono<Orderbook> orderMono = request.bodyToMono(Orderbook.class)
                .flatMap(order -> orderService.orderBidnAsk(order))
                .subscribeOn(Schedulers.parallel())
                .doOnSuccess(res -> kafkaProducerService.sendOrderMessage(res)
                );

        return ok()
                .contentType(APPLICATION_JSON)
                .body(orderMono, Orderbook.class)
                .onErrorResume(error -> ServerResponse.badRequest().build())
                .log("orderBidnAsk ok --------- ");
    }


    //주문 취소
    public Mono<ServerResponse> OrderCancel(ServerRequest request) {
        Integer orderid = Integer.valueOf(request.pathVariable("orderid"));
        Mono<Orderbook> orderMono = orderService.OrderCancel(orderid)
                .subscribeOn(Schedulers.parallel())
                .doOnSuccess(res -> kafkaProducerService.sendOrderMessage(res)
                );

        return ok()
                .contentType(APPLICATION_JSON)
                .body(orderMono, Orderbook.class)
                .onErrorResume(error -> ServerResponse.badRequest().build())
                .log("getOrderId ok --------- ");
    }


}
