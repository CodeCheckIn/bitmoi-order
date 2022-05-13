package com.bitmoi.order.repository;

import com.bitmoi.order.domain.Orderbook;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
@Repository
public interface OrderRepository extends ReactiveCrudRepository<Orderbook,Integer> {

    //매매별 주문 확인하기
//    @Query("select * from order where types = :types")
//    Flux<Order> findOrderByTypes(String types);

    //주문 취소
    @Modifying
    @Query("UPDATE msa.order set state='cancel' where orderid=:id")
    Mono<Orderbook> updateisExecute(@Param("id") Integer orderid);

}
