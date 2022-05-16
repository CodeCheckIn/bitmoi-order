package com.bitmoi.order.service;

import com.bitmoi.order.domain.Wallet;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface WalletService {

    // 대기수량 업데이트
    Mono<Wallet> updateWaitQuantity(Wallet wallet);

    // 해당 지갑 내용 가져오기
    Mono<Wallet> getWallet(Integer orderid, Integer coinid);

}
