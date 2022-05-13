-- use msa;
-- DROP TABLE IF EXISTS msa.orderbook;
-- CREATE TABLE IF NOT EXISTS msa.orderbook
-- (
--     orderbook_id   int NOT NULL AUTO_INCREMENT,
--     user_id    int,
--     coin_id    int,
--     price     decimal(65, 8) ,
--     quantity  decimal(65, 4) ,
--     types     VARCHAR(255),
--     state     VARCHAR(255),
--     createdat datetime COMMENT '생성일',
--     updatedat datetime COMMENT '수정일',
--     PRIMARY KEY (orderbook_id)
-- );

DROP TABLE IF EXISTS ORDERBOOK;
CREATE TABLE IF NOT EXISTS ORDERBOOK
(
    orderbook_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id      int NOT NULL,
    coin_id      int NOT NULL,
    price        decimal(65, 8) COMMENT '가격',
    quantity     decimal(65, 4) COMMENT '수량',
    types        varchar(200) COMMENT '주문 구분(매수/매도)',
    state        varchar(200) COMMENT '주문 상태(대기/체결/취소)',
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    updated_at   TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일'
);


-- insert into msa.orderbook
-- VALUES (null, 20, 1234, 230000.0, 90.0, 'bid','wait', ,now(),now());





