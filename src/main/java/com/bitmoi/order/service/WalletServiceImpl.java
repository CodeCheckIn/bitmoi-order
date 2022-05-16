package com.bitmoi.order.service;

import com.bitmoi.order.domain.Wallet;
import com.bitmoi.order.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService{

    private final WalletRepository walletRepository;

    @Override
    public Mono<Wallet> updateWaitQuantity(Wallet wallet){
        return this.walletRepository.updateWaitQuantity(wallet.getUserid(), wallet.getCoinid(), wallet.getWaiting_qty());
    }

    // 해당 지갑 내용 가져오기
    @Override
    public Mono<Wallet> getWallet(Integer orderid, Integer coinid){
        return this.walletRepository.getWallet(orderid, coinid);
    }

}
