/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : car

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 02/06/2020 11:25:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bus_car
-- ----------------------------
DROP TABLE IF EXISTS `bus_car`;
CREATE TABLE `bus_car`  (
  `carnumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cartype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  `rentprice` double(10, 2) NULL DEFAULT NULL,
  `deposit` double NULL DEFAULT NULL,
  `isrenting` int(11) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `carimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`carnumber`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bus_car
-- ----------------------------
INSERT INTO `bus_car` VALUES ('京a11111', '奥迪A4L', '白色', 300.00, 10.00, 100, 0, '', 'images/defaultcarimage.jpg', '2020-06-02 10:06:46');
INSERT INTO `bus_car` VALUES ('京a22222', '奔驰c260L', '黑色', 500.00, 20.00, 100, 0, '', 'images/defaultcarimage.jpg', '2020-06-02 10:07:39');
INSERT INTO `bus_car` VALUES ('京a33333', '宝马320', '蓝色', 400.00, 100.00, 100, 0, '', 'images/defaultcarimage.jpg', '2020-06-02 10:08:17');

-- ----------------------------
-- Table structure for bus_check
-- ----------------------------
DROP TABLE IF EXISTS `bus_check`;
CREATE TABLE `bus_check`  (
  `checkid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `checkdate` datetime NULL DEFAULT NULL,
  `checkdesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `problem` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paymoney` double(255, 0) NULL DEFAULT NULL,
  `opername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rentid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`checkid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bus_check
-- ----------------------------
INSERT INTO `bus_check` VALUES ('JC_20200602_100857_811_82643', '2020-06-02 10:08:57', '没有问题', '无', 0, '管理员', 'CZ_20200602_100825_483_16597', '2020-06-02 10:09:28');

-- ----------------------------
-- Table structure for bus_customer
-- ----------------------------
DROP TABLE IF EXISTS `bus_customer`;
CREATE TABLE `bus_customer`  (
  `identity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证',
  `custname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` int(255) NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `career` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `createtime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`identity`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bus_customer
-- ----------------------------
INSERT INTO `bus_customer` VALUES ('111', '蔡徐坤', 1, '上海', '15199999999', '打篮球', '2020-06-02 09:49:09');

-- ----------------------------
-- Table structure for bus_rent
-- ----------------------------
DROP TABLE IF EXISTS `bus_rent`;
CREATE TABLE `bus_rent`  (
  `rentid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  `begindate` datetime NULL DEFAULT NULL,
  `returndate` datetime NULL DEFAULT NULL,
  `rentflag` int(11) NULL DEFAULT NULL,
  `identity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `carnumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `opername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`rentid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bus_rent
-- ----------------------------
INSERT INTO `bus_rent` VALUES ('CZ_20200602_100825_483_16597', 10.00, '2020-06-02 10:08:25', '2020-06-03 00:00:00', 1, '111', '京a11111', '管理员', '2020-06-02 10:08:34');

-- ----------------------------
-- Table structure for sys_log_login
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_login`;
CREATE TABLE `sys_log_login`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loginip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `logintime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 237 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_log_login
-- ----------------------------
INSERT INTO `sys_log_login` VALUES (232, '管理员-admin', '0:0:0:0:0:0:0:1', '2020-06-02 10:29:08');
INSERT INTO `sys_log_login` VALUES (233, '管理员-admin', '0:0:0:0:0:0:0:1', '2020-06-02 10:33:07');
INSERT INTO `sys_log_login` VALUES (234, '管理员-admin', '0:0:0:0:0:0:0:1', '2020-06-02 10:47:45');
INSERT INTO `sys_log_login` VALUES (235, '管理员-admin', '0:0:0:0:0:0:0:1', '2020-06-02 11:04:37');
INSERT INTO `sys_log_login` VALUES (236, '管理员-admin', '0:0:0:0:0:0:0:1', '2020-06-02 11:22:45');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `href` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `spread` int(255) NULL DEFAULT NULL COMMENT '0不展开1展开',
  `target` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `available` int(255) NULL DEFAULT NULL COMMENT '0不可用1可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '汽车出租系统', NULL, 1, NULL, '&#xe68e;', 1);
INSERT INTO `sys_menu` VALUES (2, 1, '基础管理', '', 1, '', '&#xe653;', 1);
INSERT INTO `sys_menu` VALUES (3, 1, '业务管理', '', 1, '', '&#xe663;', 1);
INSERT INTO `sys_menu` VALUES (4, 1, '系统管理', '', 0, '', '&#xe716;', 1);
INSERT INTO `sys_menu` VALUES (5, 1, '统计分析', NULL, 0, NULL, '&#xe629;', 1);
INSERT INTO `sys_menu` VALUES (6, 2, '客户管理', '../bus/toCustomerManager.action', 0, '', '&#xe770;', 1);
INSERT INTO `sys_menu` VALUES (7, 2, '车辆管理', '../bus/toCarManager.action', 0, '', '&#xe657;', 1);
INSERT INTO `sys_menu` VALUES (8, 3, '汽车出租', '../bus/toRentCarManager.action', 1, '', '&#xe65b;', 1);
INSERT INTO `sys_menu` VALUES (9, 3, '出租单管理', '../bus/toRentManager.action', 0, '', '&#xe6b2;', 1);
INSERT INTO `sys_menu` VALUES (10, 3, '汽车入库', '../bus/toCheckCarManager.action', 0, '', '&#xe65a;', 1);
INSERT INTO `sys_menu` VALUES (11, 3, '检查单管理', '../bus/toCheckManager.action', 0, '', '&#xe705;', 1);
INSERT INTO `sys_menu` VALUES (12, 4, '菜单管理', '../sys/toMenuManager.action', 0, NULL, '&#xe60f;', 1);
INSERT INTO `sys_menu` VALUES (13, 4, '角色管理', '../sys/toRoleManager.action', 0, '', '&#xe66f;', 1);
INSERT INTO `sys_menu` VALUES (14, 4, '用户管理', '../sys/toUserManager.action', 0, '', '&#xe770;', 1);
INSERT INTO `sys_menu` VALUES (15, 4, '日志管理', '../sys/toLogInfoManager.action', 0, '', '&#xe655;', 1);
INSERT INTO `sys_menu` VALUES (16, 4, '公告管理', '../sys/toNewsManager.action', 0, '', '&#xe645;', 1);
INSERT INTO `sys_menu` VALUES (17, 4, '数据源监控', '../druid/', 0, '', '&#xe857;', 1);
INSERT INTO `sys_menu` VALUES (18, 5, '客户地区统计', '../stat/toCustomerAreaStat.action', 0, '', '&#xe63c;', 1);
INSERT INTO `sys_menu` VALUES (19, 5, '公司年度月份销售额', '../stat/toCompanyYearGradeStat.action', 0, '', '&#xe62c;', 1);
INSERT INTO `sys_menu` VALUES (20, 5, '业务员年度销售额', '../stat/toOpernameYearGradeStat.action', 0, '', '&#xe62d;', 1);

-- ----------------------------
-- Table structure for sys_news
-- ----------------------------
DROP TABLE IF EXISTS `sys_news`;
CREATE TABLE `sys_news`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT NULL,
  `opername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_news
-- ----------------------------
INSERT INTO `sys_news` VALUES (18, '欢迎来到伟彬汽车出租公司', '<p>伟彬汽车出租公司竭诚为您服务</p>', '2020-06-02 09:55:02', '管理员');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `roledesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `available` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`roleid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', '拥有所有菜单权限', 1);
INSERT INTO `sys_role` VALUES (2, '业务管理员', '拥有所以业务菜单', 1);
INSERT INTO `sys_role` VALUES (3, '系统管理员', '管理系统', 1);
INSERT INTO `sys_role` VALUES (4, '数据统计管理员', '数据统计管理员', 1);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `rid` int(11) NOT NULL,
  `mid` int(11) NOT NULL,
  PRIMARY KEY (`rid`, `mid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (1, 2);
INSERT INTO `sys_role_menu` VALUES (1, 3);
INSERT INTO `sys_role_menu` VALUES (1, 4);
INSERT INTO `sys_role_menu` VALUES (1, 5);
INSERT INTO `sys_role_menu` VALUES (1, 6);
INSERT INTO `sys_role_menu` VALUES (1, 7);
INSERT INTO `sys_role_menu` VALUES (1, 8);
INSERT INTO `sys_role_menu` VALUES (1, 9);
INSERT INTO `sys_role_menu` VALUES (1, 10);
INSERT INTO `sys_role_menu` VALUES (1, 11);
INSERT INTO `sys_role_menu` VALUES (1, 12);
INSERT INTO `sys_role_menu` VALUES (1, 13);
INSERT INTO `sys_role_menu` VALUES (1, 14);
INSERT INTO `sys_role_menu` VALUES (1, 15);
INSERT INTO `sys_role_menu` VALUES (1, 16);
INSERT INTO `sys_role_menu` VALUES (1, 17);
INSERT INTO `sys_role_menu` VALUES (1, 18);
INSERT INTO `sys_role_menu` VALUES (1, 19);
INSERT INTO `sys_role_menu` VALUES (1, 20);
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 3);
INSERT INTO `sys_role_menu` VALUES (2, 6);
INSERT INTO `sys_role_menu` VALUES (2, 7);
INSERT INTO `sys_role_menu` VALUES (2, 8);
INSERT INTO `sys_role_menu` VALUES (2, 9);
INSERT INTO `sys_role_menu` VALUES (2, 10);
INSERT INTO `sys_role_menu` VALUES (2, 11);
INSERT INTO `sys_role_menu` VALUES (3, 1);
INSERT INTO `sys_role_menu` VALUES (3, 4);
INSERT INTO `sys_role_menu` VALUES (3, 12);
INSERT INTO `sys_role_menu` VALUES (3, 13);
INSERT INTO `sys_role_menu` VALUES (3, 14);
INSERT INTO `sys_role_menu` VALUES (3, 15);
INSERT INTO `sys_role_menu` VALUES (3, 16);
INSERT INTO `sys_role_menu` VALUES (3, 17);
INSERT INTO `sys_role_menu` VALUES (4, 1);
INSERT INTO `sys_role_menu` VALUES (4, 5);
INSERT INTO `sys_role_menu` VALUES (4, 18);
INSERT INTO `sys_role_menu` VALUES (4, 19);
INSERT INTO `sys_role_menu` VALUES (4, 20);

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user`  (
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`uid`, `rid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES (8, 1);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `identity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` int(255) NULL DEFAULT NULL COMMENT '0女1男',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(255) NULL DEFAULT 2 COMMENT '1，超级管理员,2，系统用户',
  `available` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (8, 'admin', '123', '管理员', 1, '北京', '15111111111', 'e10adc3949ba59abbe56e057f20f883e', '系统管理员', 2, 1);

SET FOREIGN_KEY_CHECKS = 1;
