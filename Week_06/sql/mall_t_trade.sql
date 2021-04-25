/*
 Navicat Premium Data Transfer

 Source Server         : 47.103.114.251(主)
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : 47.103.114.251:3306
 Source Schema         : a_demo_test

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 25/04/2021 10:59:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mall_t_trade
-- ----------------------------
DROP TABLE IF EXISTS `mall_t_trade`;
CREATE TABLE `mall_t_trade`  (
  `trade_id` bigint(20) NOT NULL COMMENT '单号ID',
  `trade_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单号',
  `trade_status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态',
  `shop_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '店铺类型',
  `shop_id` int(11) NULL DEFAULT NULL COMMENT '店铺id',
  `warehouse_id` int(11) NULL DEFAULT NULL COMMENT '仓库id',
  `logistic_id` int(11) NULL DEFAULT NULL COMMENT '物流id',
  `goods_total` decimal(12, 4) NULL DEFAULT NULL COMMENT '货款合计',
  `all_total` decimal(12, 4) NULL DEFAULT NULL COMMENT '合计应收',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '客服备注',
  `coupon_total` decimal(12, 4) NULL DEFAULT NULL COMMENT '优惠金额',
  `trade_time` datetime(0) NULL DEFAULT NULL COMMENT '交易时间',
  `snd_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '付款时间',
  `province` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '省',
  `city` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '市',
  `town` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '区',
  `country` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '国家',
  `snd_to` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收件人名字',
  `tel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话号码',
  PRIMARY KEY (`trade_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单信息表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
