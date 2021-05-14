/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50518
 Source Host           : localhost:3306
 Source Schema         : employment_manage

 Target Server Type    : MySQL
 Target Server Version : 50518
 File Encoding         : 65001

 Date: 21/05/2020 11:39:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employment_info
-- ----------------------------
DROP TABLE IF EXISTS `employment_info`;
CREATE TABLE `employment_info`  (
  `information_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `company_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `company_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `employment_station` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `treatment` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `ability_requirement` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `student_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `student_major` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `student_class` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `student_mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `employment_time` date NULL DEFAULT NULL,
  `company_contact_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `company_contact_mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `student_gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`information_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employment_info
-- ----------------------------
INSERT INTO `employment_info` VALUES ('c9b3ce22-7afa-4f01-a790-c5564147e5dc', '腾讯', '深圳市和平区', '软件测试', '20*18', '熟练掌握各种自动化测试工具', '张莉丽', '软件工程', '18级2班', '15941140102', '2020-05-19', '舒兰', '15941140101', '女');
INSERT INTO `employment_info` VALUES ('ca581765-4174-40e7-bc3f-ecac5d869359', '百度', '北京市海淀区', '软件开发', '25*16', '精通java', '张三', '软件工程', '19级1班', '15941140001', '2020-05-20', '大A', '15941140000', '男');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_account` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_pwd` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_type` int(1) NULL DEFAULT NULL COMMENT '0-管理员，1-普通用户',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('001001001001', 'test', '测试', '123456', 1);
INSERT INTO `user` VALUES ('1234567890', 'admin', '管理员', '123456', 0);

SET FOREIGN_KEY_CHECKS = 1;
