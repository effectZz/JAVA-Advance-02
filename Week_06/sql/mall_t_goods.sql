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

 Date: 25/04/2021 10:59:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mall_t_goods
-- ----------------------------
DROP TABLE IF EXISTS `mall_t_goods`;
CREATE TABLE `mall_t_goods`  (
  `goods_id` int(11) NOT NULL COMMENT '主键：货品ID',
  `goods_sku` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'SKU',
  `goods_spu` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'SPU',
  `class_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类别名',
  `goods_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '品名 ',
  `brand` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '品牌',
  `goods_len` float NULL DEFAULT NULL COMMENT '长',
  `goods_width` float NULL DEFAULT NULL COMMENT '宽',
  `goods_height` float NULL DEFAULT NULL COMMENT '高',
  `weight` float NULL DEFAULT NULL COMMENT '重量',
  `spec_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '规格-颜色',
  PRIMARY KEY (`goods_id`) USING BTREE,
  INDEX `fk_otg_1`(`goods_sku`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
