package com.bitmoi.order.repository;

import com.bitmoi.order.domain.Order;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderRepository extends ReactiveCrudRepository<Order,Integer> {

    @Query("select * from msa.order")
    Flux<Order> findByOrderidList();

    @Query("insert into msa.order (userId,coinId,price,quantity,types) values (:userid,:coinid,:price,:quantity,:types )")
    Mono<Order> saveAllByOrder(@Param("userid") Integer userId, @Param("coinid") Integer coinId
            ,@Param("price") Float price ,@Param("quantity") Float quantity, @Param("types") String types );

//userId,coinId,price,quantity,types


    //매매별 주문 확인하기
//    @Query("select * from order where types = :types")
//    Flux<Order> findOrderByTypes(String types);

    //주문 취소
    @Modifying
    @Query("UPDATE msa.order set types='cancel' where orderid=:id")
    Mono<Order> updateisExecute(@Param("id") Integer orderid);

}
