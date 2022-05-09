package com.bitmoi.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Order {

    private Integer id;
    private Long price;
    private Long quantity;
    private String types;
    private Boolean isMarketPrice;
    private Boolean isExecute;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
