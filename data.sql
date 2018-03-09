/*
 Navicat MySQL Data Transfer

 Source Server         : mybatis
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : mybatisdemo

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 09/03/2018 10:21:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `birthday` datetime(6) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'michael', 1, '2018-03-09 09:32:14.000000', 'shenzhen baoan');
INSERT INTO `t_user` VALUES (2, 'sara', 0, '2018-03-01 10:05:05.000000', 'shenzhen nanshan');
INSERT INTO `t_user` VALUES (3, 'alex', 1, '2018-02-15 10:05:33.000000', 'shenzhen longgang');
INSERT INTO `t_user` VALUES (4, 'michaeel', 1, '2018-03-08 10:12:34.000000', 'shenzhen bantian');

SET FOREIGN_KEY_CHECKS = 1;
