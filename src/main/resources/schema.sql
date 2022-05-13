-- use msa;
-- DROP TABLE IF EXISTS msa.orderbook;
CREATE TABLE IF NOT EXISTS msa.orderbook
(
    orderid   int NOT NULL AUTO_INCREMENT,
    userid    int,
    coinid    int,
    price     float,
    quantity  float,
    types     VARCHAR(255),
    state     VARCHAR(255),
    createdat datetime COMMENT '생성일',
    updatedat datetime COMMENT '수정일',
    PRIMARY KEY (orderid)
);

-- insert into msa.orderbook
-- VALUES (null, 20, 1234, 230000.0, 90.0, 'bid','wait', ,now(),now());





