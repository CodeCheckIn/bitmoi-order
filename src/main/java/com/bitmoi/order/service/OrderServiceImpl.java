package com.bitmoi.order.service;

import com.bitmoi.order.domain.Orderbook;
import com.bitmoi.order.repository.OrderRepository;
import com.bitmoi.order.util.JwtDecode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final JwtDecode jwtDecode;

    //매매 전체 목록
    @Override
    public Flux<Orderbook> getOrderList(){
        return this.orderRepository.findAll();
    }

    //매매 주문하기
    @Override
    public Mono<Orderbook> orderBidnAsk(Orderbook orderbook){
        return this.orderRepository.save(orderbook);
    }

    //주문 취소
    @Override
    public Mono<Orderbook> OrderCancel(Integer id){
        orderRepository.updateisExecute(id);
        return this.orderRepository.findById(id);
    }

    //사용자 id decode
    @Override
    public Mono<Orderbook> saveUserid(Orderbook orderbook, ServerRequest request){
         orderbook.setUserid(jwtDecode.decode(request.headers().asHttpHeaders().getFirst("Authorization")));
        return this.orderRepository.save(orderbook);
    }


}
