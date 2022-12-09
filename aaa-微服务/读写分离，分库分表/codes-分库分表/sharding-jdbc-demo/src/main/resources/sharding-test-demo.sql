-- 主从库
CREATE DATABASE sharding_order DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE TABLE sharding_order.`t_order`
(
    `order_id`     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_amount` decimal(10,2)      default 0.00 COMMENT '订单金额',
    `order_status` integer(2) NULL DEFAULT 1 COMMENT '创建时间',
    `user_id`      bigint(20) NULL COMMENT '更新时间',
    PRIMARY KEY (`order_id`) USING BTREE
);
-- 本地单独库
CREATE DATABASE shard_order DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE TABLE shard_order.`t_order`
(
    `order_id`     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_amount` decimal(10,2)      default 0.00 COMMENT '订单金额',
    `order_status` integer(2) NULL DEFAULT 1 COMMENT '创建时间',
    `user_id`      bigint(20) NULL COMMENT '更新时间',
    PRIMARY KEY (`order_id`) USING BTREE
);

-- sharding-jdbc的全局表
CREATE TABLE `area`
(
    `id`     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`      varchar(255) NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
);
