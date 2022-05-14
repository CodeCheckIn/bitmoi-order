package com.bitmoi.order.repository;

import com.bitmoi.order.domain.Orderbook;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Mono;

public interface OrderRepository extends R2dbcRepository<Orderbook,Integer> {

    //주문 취소
    @Modifying
    @Query("UPDATE bitmoi.orderbook set state='cancel' where orderbook_id=:id")
    Mono<Orderbook> updateisExecute(@Param("id") Integer orderbookid);

}
