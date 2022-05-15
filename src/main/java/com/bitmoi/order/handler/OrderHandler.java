package com.bitmoi.order.handler;

import com.bitmoi.order.domain.Orderbook;
import com.bitmoi.order.domain.Wallet;
import com.bitmoi.order.kafka.KafkaProducerService;
import com.bitmoi.order.service.OrderService;
import com.bitmoi.order.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.math.BigDecimal;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class OrderHandler {

    private final Logger logger = LoggerFactory.getLogger(OrderHandler.class);

    private final OrderService orderService;
    private final WalletService walletService;
    private final KafkaProducerService kafkaProducerService;

    // 매매 주문 목록
    public Mono<ServerResponse> getOrderList(ServerRequest request) {
        logger.info("매매 주문 목록");
        Flux<Orderbook> orderFlux = orderService.getOrderList();
        return ok()
                .contentType(APPLICATION_JSON)
                .body(orderFlux, Orderbook.class)
                .log("getOrderbookList ok --------- ");
    }


    //public Mono<ServerResponse> orderBidnAsk(ServerRequest request) {
    //        Mono<Order> orderMono = request.bodyToMono(Order.class)
    //                .flatMap(order -> orderService.orderBidnAsk(order))
    //                .subscribeOn(Schedulers.parallel())
    //                .doOnSuccess(res -> kafkaProducerService.sendOrderMessage(res)
    //                );
    //
    //        return ok()
    //                .contentType(APPLICATION_JSON)
    //                .body(orderMono, Order.class)
    //                .onErrorResume(error -> ServerResponse.badRequest().build())
    //                .log("orderBidnAsk ok --------- ");
    //    }


    // 매매 주문하기
    public Mono<ServerResponse> orderBidnAsk(ServerRequest request) {
        logger.info("매매 주문하기");
        Mono<Orderbook> orderMono = request.bodyToMono(Orderbook.class)
                .flatMap(order -> orderService.orderBidnAsk(order))
                .flatMap(orderbook -> {
                    return walletQuan(orderbook);
                })
                .subscribeOn(Schedulers.parallel())
                .doOnSuccess(res -> kafkaProducerService.sendOrderMessage(res));

        return ok()
                .contentType(APPLICATION_JSON)
                .body(orderMono, Object.class)
                .onErrorResume(error -> ServerResponse.badRequest().build())
                .log("orderBidnAsk ok --------- ");
    }


    //주문 취소
    public Mono<ServerResponse> OrderCancel(ServerRequest request) {
        logger.info("주문 취소");
        Integer orderid = Integer.valueOf(request.pathVariable("orderbookid"));
        Mono<Orderbook> orderMono = orderService.OrderCancel(orderid)
                .subscribeOn(Schedulers.parallel())
                .doOnSuccess(res -> kafkaProducerService.sendOrderMessage(res));

        return ok()
                .contentType(APPLICATION_JSON)
                .body(orderMono, Orderbook.class)
                .onErrorResume(error -> ServerResponse.badRequest().build())
                .log("getOrderId ok --------- ");
    }


    private Mono<Orderbook> walletQuan(Orderbook orderbook) {
        logger.info("지갑 Waiting_qty 업데이트");
        return (Mono<Orderbook>) walletService.getWallet(orderbook.getUserid(), orderbook.getCoinid())
                .flatMap(n -> {
                    int val = n.getQuantity().subtract(n.getWaiting_qty()).compareTo(orderbook.getQuantity().multiply(orderbook.getPrice()));

                    BigDecimal wal = n.getQuantity().subtract(n.getWaiting_qty());
                    BigDecimal order_quan = orderbook.getQuantity().multiply(orderbook.getPrice());
                    BigDecimal wallet_qty = n.getWaiting_qty().add(order_quan);
                    System.out.println("wal > " + wal + " ,order_quan >  " + order_quan + " , wallet_qty > " + wallet_qty);

                    if (val >= 0) { //order quantity가 더 적은경우
                        System.out.println("val1 > " + n + orderbook.getUserid());
                        n.setWaiting_qty(wallet_qty);
                        return walletService.updateWaitQuantity(n);
                    }
                    return Mono.just(new Orderbook());
                })
                .map(m -> orderbook);
    }


}
