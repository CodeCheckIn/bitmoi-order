package com.bitmoi.order;

import com.bitmoi.order.domain.Orderbook;
import com.bitmoi.order.repository.OrderRepository;
import com.bitmoi.order.service.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@SpringBootTest
@Import(OrderServiceImpl.class)
class OrderbookApplicationTests {

    @MockBean
    OrderRepository orderRepository;

    @Test
    void contextLoads() {
        Orderbook orderbook = new Orderbook();
        orderbook.setUserid(7);
        orderbook.setCoinid(10);
        orderbook.setPrice(BigDecimal.valueOf(300.0));
        orderbook.setQuantity(BigDecimal.valueOf(2.0));

        System.out.println("orderbook test > "+orderbook);

    }

}
