package com.bitmoi.order.service;

import com.bitmoi.order.domain.Wallet;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface WalletService {

    // 대기수량 업데이트
    Mono<Wallet> updateQuantity(Integer userid, Integer coinid, BigDecimal quantity);

    Mono<Wallet> updateWaitQuantity(Wallet wallet);


    //수량 가져오기
    Mono<Wallet> getQuantity(Integer orderid, Integer coinid);

    //
    Mono<Wallet> getWallet(Integer orderid, Integer coinid);


}
