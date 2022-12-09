drop table if exists `order`;
CREATE TABLE `order`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_status`    integer(2)      DEFAULT NULL COMMENT '订单状态',
    `receiver_name`   varchar(16)     default null COMMENT '收件人',
    `receiver_mobile` varchar(16)     default null COMMENT '收件号码',
    `order_amount`    integer(2)      default 0 COMMENT '订单数量',
    `create_time`     datetime   NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`     datetime   NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_user`     varchar(16)     default null COMMENT '创建人',
    `update_user`     varchar(16)     default null COMMENT '更新人',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='锁测试-订单表';

drop table if exists `order_item`;
CREATE TABLE `order_item`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_id`       bigint(20) null DEFAULT NULL COMMENT '订单id',
    `product_id`     bigint(20) null default null COMMENT '商品id',
    `purchase_price` double(16, 2)   default 0.00 COMMENT '购买价格',
    `purchase_num`   integer(2)      default 0 COMMENT '购买数量',
    `create_time`    datetime   NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`    datetime   NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_user`    varchar(16)     default null COMMENT '创建人',
    `update_user`    varchar(16)     default null COMMENT '更新人',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='锁测试-订单商品中间表';

drop table if exists `product`;
CREATE TABLE `product`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `product_name` varchar(20)     DEFAULT NULL COMMENT '商品名称',
    `price`        double(16, 2)   default 0.00 COMMENT '商品价格',
    `count`        integer(4)      default null COMMENT '库存',
    `product_desc` varchar(256)    default null COMMENT '商品描述',
    `create_time`  datetime   NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  datetime   NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_user`  varchar(16)     default null COMMENT '创建人',
    `update_user`  varchar(16)     default null COMMENT '更新人',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='锁测试-商品表';

drop table if exists `distribute_lock`;
CREATE TABLE `distribute_lock`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `business_code` varchar(128)     DEFAULT NULL COMMENT '商品名称',
    `business_name` varchar(128)    default null COMMENT '商品描述',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='数据乐观锁-》分布式锁';


