package com.bitmoi.order.repository;

import com.bitmoi.order.domain.Wallet;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface WalletRepository extends R2dbcRepository<Wallet,Integer> {

    //waiting_qty 수량 변경
    @Modifying
    @Query("update bitmoi.wallet set waiting_qty = :quantity where user_id = :userid and coin_id = :coinid;")
    Mono<Wallet> updateWaitQuantity(@Param("userid") Integer userid, @Param("coinid") Integer coinid, @Param("quantity") BigDecimal quantity);

    // 해당 지갑 내용 가져오기
    @Query("select * from bitmoi.wallet where user_id = :userid and coin_id = :coinid;")
    Mono<Wallet> getWallet(@Param("userid") Integer orderid, @Param("coinid") Integer coinid);

}
