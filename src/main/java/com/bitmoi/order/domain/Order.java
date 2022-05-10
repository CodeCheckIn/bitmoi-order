package com.bitmoi.order.domain;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Table(value = "order")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @Column(value = "order_id")
    private Long orderId;

    @Column(value = "user_id")
    private Long userId;

    @Column(value = "coin_id")
    private Long coinId;

    private Double price;
    private Double quantity;
    private String types;

    @Column(value = "is_market_price")
    private int isMarketPrice;

    @Column(value = "is_execute")
    private int isExecute;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;

}
