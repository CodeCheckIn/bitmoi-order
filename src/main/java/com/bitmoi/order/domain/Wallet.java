package com.bitmoi.order.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(value = "bitmoi.WALLET")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {

    @Id
    @Column(value = "wallet_id")
    private Integer walletid;

    @Column(value = "user_id")
    private Integer userid;

    @Column(value = "coin_id")
    private Integer coinid;

    @Column(value = "quantity")
    private BigDecimal quantity;

    @Column(value = "waiting_qty")
    private BigDecimal waiting_qty;

    @Column(value = "avg_price")
    private BigDecimal avg_price;

    @CreatedDate
    @Column(value = "created_at")
    private LocalDateTime createdat;

    @LastModifiedDate
    @Column(value = "updated_at")
    private LocalDateTime updatedat;

}
