use msa;
-- DROP TABLE IF EXISTS msa.order;
CREATE TABLE IF NOT EXISTS msa.order
(
    orderid       int NOT NULL AUTO_INCREMENT,
    userid        int,
    coinid        int,
    price         float,
    quantity      float,
    types         VARCHAR(255),
    ismarketprice int DEFAULT '0' COMMENT 'y-0, n-1',
    state     VARCHAR(255),
    createdat      datetime COMMENT '생성일',
    updatedat      datetime COMMENT '수정일',
    PRIMARY KEY (orderid)
);


-- insert into msa.order
-- VALUES (null, 20, 1234, 230000.0, 90.0, 'wait', 0, 1,now(),now());





