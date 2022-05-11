package com.bitmoi.order.repository;

import com.bitmoi.order.domain.Order;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderRepository extends ReactiveCrudRepository<Order,Integer> {

    @Query("select * from msa.order")
    Flux<Order> findByOrderidList();

    //매매별 주문 확인하기
//    @Query("select * from order where types = :types")
//    Flux<Order> findOrderByTypes(String types);

//    @Modifying
//    @Query("UPDATE order set isexcute=:isexcute where orderid=:orderid")
//    Mono<Order> updateisExcute(Integer isexcure, Integer orderid);

}
