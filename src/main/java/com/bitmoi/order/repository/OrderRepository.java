package com.bitmoi.order.repository;

import com.bitmoi.order.domain.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

//ReactiveCrudRepository
@Repository
public interface OrderRepository extends ReactiveCrudRepository<Order,Integer> {

//    @Modifying
//    @Query("UPDATE order set isexcute=:isexcute where orderid=:orderid")
//    Mono<Order> updateisExcute(Integer isexcure, Integer orderid);

}
