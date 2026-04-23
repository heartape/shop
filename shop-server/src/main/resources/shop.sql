/*
 Navicat Premium Dump SQL

 Source Server         : mysql-nas
 Source Server Type    : MySQL
 Source Server Version : 90300 (9.3.0)
 Source Host           : 192.168.1.100:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 90300 (9.3.0)
 File Encoding         : 65001

 Date: 19/06/2025 02:04:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `id` bigint NOT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '业务id',
  `name` bigint NOT NULL COMMENT '门店名称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地址',
  `longitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '经度',
  `latitude` int NOT NULL COMMENT '纬度',
  `accuracy` char NOT NULL COMMENT '定位精度',
  `status` tinyint NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for store_employee
-- ----------------------------
DROP TABLE IF EXISTS `store_employee`;
CREATE TABLE `store_employee`  (
   `id` bigint NOT NULL,
   `uid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '业务id',
   `store_id` bigint NOT NULL COMMENT '门店id',
   `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '职位',
   `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
   `age` int NOT NULL COMMENT '年龄',
   `phone` char NOT NULL COMMENT '手机号',
   `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱',
   `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '头像链接',
   `status` tinyint NOT NULL COMMENT '状态',
   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for group_product
-- ----------------------------
DROP TABLE IF EXISTS `group_product`;
CREATE TABLE `group_product`  (
  `id` bigint NOT NULL,
  `product_id` bigint NOT NULL COMMENT '商品id',
  `warehouse_id` bigint NOT NULL COMMENT '仓库id',
  `price` decimal(10, 2) NOT NULL COMMENT '价格',
  `currency_code` enum('CNY','USD','EUR') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '货币代码',
  `specification` float NOT NULL COMMENT '规格',
  `available` tinyint NOT NULL COMMENT '是否可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` bigint NOT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '内部唯一编码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名',
  `picture` json NULL COMMENT '主图',
  `type` tinyint NOT NULL COMMENT '类型，标准商品、成分商品',
  `specification` smallint NOT NULL COMMENT '规格',
  `basic` tinyint NOT NULL COMMENT '是否基本售卖单位',
  `removed` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '是否停售',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product_detail
-- ----------------------------
DROP TABLE IF EXISTS `product_detail`;
CREATE TABLE `product_detail`  (
  `id` bigint NOT NULL,
  `product_id` bigint NOT NULL COMMENT '商品id',
  `bar_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '条形码',
  `pictures` json NOT NULL COMMENT '详图,数组形式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for retail_price
-- ----------------------------
DROP TABLE IF EXISTS `retail_price`;
CREATE TABLE `retail_price`  (
  `id` bigint NOT NULL,
  `product_id` bigint NOT NULL COMMENT '商品id',
  `store_id` bigint NOT NULL COMMENT '门店id',
  `price_type` enum('REGULAR','MEMBERSHIP','SPECIAL') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '价格类型',
  `price` decimal(10, 2) NOT NULL COMMENT '价格',
  `side_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '副价格',
  `currency_code` enum('CNY','USD','EUR') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '货币代码',
  `available` tinyint NOT NULL COMMENT '是否可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for store_inventory
-- ----------------------------
DROP TABLE IF EXISTS `store_inventory`;
CREATE TABLE `store_inventory`  (
  `id` bigint NOT NULL,
  `store_id` bigint NOT NULL COMMENT '门店id',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `count` int NOT NULL COMMENT '门店库存数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for store_inventory_record
-- ----------------------------
DROP TABLE IF EXISTS `store_inventory_record`;
CREATE TABLE `store_inventory_record`  (
  `id` bigint NOT NULL,
  `store_id` bigint NOT NULL COMMENT '门店id',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `is_in` tinyint NOT NULL COMMENT '是否入库',
  `count` int NOT NULL COMMENT '门店库存数量',
  `timestamp` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
