package com.bitmoi.order.repository;

import com.bitmoi.order.domain.Wallet;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface WalletRepository extends R2dbcRepository<Wallet,Integer> {

    //주문 수량 변경
    @Modifying
    @Query("update bitmoi.wallet set quantity = :quantity where user_id = :id;")
    Mono<Wallet> updateQuantity(@Param("id") Integer orderid ,@Param("quantity") BigDecimal quantity);
}
