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
    public Mono<Wallet> updateQuantity(Integer userid, Integer coinid, BigDecimal quantity){
        return this.walletRepository.updateQuantity(userid, coinid, quantity);
    }

    @Override
    public Mono<Wallet> updateWaitQuantity(Wallet wallet){
        return this.walletRepository.updateWaitQuantity(wallet.getUserid(), wallet.getCoinid(), wallet.getWaiting_qty());
    }

//    @Override
//    public Mono<Integer> updateWaitQuantity(Integer userid, Integer coinid, BigDecimal quantity){
//        return this.walletRepository.updateWaitQuantity(userid, coinid, quantity);
//    }


    //getQuantity
    @Override
    public Mono<Wallet> getQuantity(Integer orderid, Integer coinid){
        return this.walletRepository.getQuantity(orderid, coinid);
    }

    @Override
    public Mono<Wallet> getWallet(Integer orderid, Integer coinid){
        return this.walletRepository.getWallet(orderid, coinid);
    }

}
