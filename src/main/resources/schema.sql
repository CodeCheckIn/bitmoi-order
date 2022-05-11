use msa;
# DROP TABLE IF EXISTS msa.order;
CREATE TABLE IF NOT EXISTS msa.order
(
    orderId       int NOT NULL AUTO_INCREMENT,
    userId        int,
    coinId        int,
    price         float,
    quantity      float,
    types         VARCHAR(255),
    isMarketPrice int DEFAULT '0' COMMENT 'y-0, n-1',
    isExecute     int DEFAULT '0' COMMENT 'y-0, n-1',
    createAt      datetime COMMENT '생성일',
    updateAt      datetime COMMENT '수정일',
    PRIMARY KEY (orderId)
);


insert into msa.order
VALUES (null, 20, 1234, 230000.0, 90.0, 'wait', 0, 1,now(),now());





