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

 Date: 25/04/2021 10:59:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mall_t_trade_detail
-- ----------------------------
DROP TABLE IF EXISTS `mall_t_trade_detail`;
CREATE TABLE `mall_t_trade_detail`  (
  `rec_id` bigint(20) NOT NULL COMMENT '主键 ：记录id',
  `trade_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单号',
  `goods_id` int(11) NULL DEFAULT NULL COMMENT '货品ID',
  `goods_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品编号',
  `price_cost` decimal(15, 4) NULL DEFAULT NULL COMMENT '商品成本',
  `goods_count` int(11) NULL DEFAULT NULL COMMENT '数量',
  `goods_weight` double NULL DEFAULT NULL COMMENT '重量',
  `goods_money` decimal(12, 2) NULL DEFAULT NULL COMMENT '金额',
  `goods_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '品名',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '明细备注',
  PRIMARY KEY (`rec_id`) USING BTREE,
  INDEX `idx_trade_no`(`trade_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单信息商品明细表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
