/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : finance

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 18/03/2020 16:52:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '管理员账户  主键id',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员用户名',
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `status` int(10) NULL DEFAULT NULL COMMENT '登录状态（0：离线   1：在线）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 0);

-- ----------------------------
-- Table structure for admin_permissions
-- ----------------------------
DROP TABLE IF EXISTS `admin_permissions`;
CREATE TABLE `admin_permissions`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '管理员权限表 主键自增',
  `adminId` int(10) NULL DEFAULT NULL COMMENT '管理员id',
  `permissionId` int(10) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 80 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin_permissions
-- ----------------------------
INSERT INTO `admin_permissions` VALUES (64, 1, 10);
INSERT INTO `admin_permissions` VALUES (65, 1, 11);
INSERT INTO `admin_permissions` VALUES (66, 1, 12);
INSERT INTO `admin_permissions` VALUES (67, 1, 13);
INSERT INTO `admin_permissions` VALUES (68, 1, 14);
INSERT INTO `admin_permissions` VALUES (69, 1, 15);
INSERT INTO `admin_permissions` VALUES (70, 1, 16);
INSERT INTO `admin_permissions` VALUES (71, 1, 17);
INSERT INTO `admin_permissions` VALUES (72, 1, 18);
INSERT INTO `admin_permissions` VALUES (73, 1, 19);
INSERT INTO `admin_permissions` VALUES (74, 1, 20);
INSERT INTO `admin_permissions` VALUES (75, 1, 21);
INSERT INTO `admin_permissions` VALUES (76, 1, 22);
INSERT INTO `admin_permissions` VALUES (77, 1, 23);
INSERT INTO `admin_permissions` VALUES (78, 1, 24);
INSERT INTO `admin_permissions` VALUES (79, 1, 25);

-- ----------------------------
-- Table structure for bank
-- ----------------------------
DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '银行 主键id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行名称',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行类型',
  `assets` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产',
  `bankDesc` varchar(20000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bank
-- ----------------------------
INSERT INTO `bank` VALUES (1, '中国工商银行', '商业银行', '2,076.14亿美元', '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-weight: bold;\">中国工商银行（INDUSTRIAL AND COMMERCIAL BANK OF CHINA，简称ICBC ，工行）成立于1984年1月1日。  总行位于北京复兴门内大街55号，是中央管理的大型国有银行，  国家副部级单位。&nbsp; </span><div><span style=\"font-weight: bold;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;中国工商银行的基本任务是依据国家的法律和法规，通过国内外开展融资活动筹集社会资金，加强信贷资金管理，支持企业生产和技术改造，为我国经济建设服务。</span><p><br></p></div>');
INSERT INTO `bank` VALUES (2, '中国建设银行', '商业银行', '2,941.12亿美元', '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-style: italic;\">中国建设银行（China Construction Bank）成立于1954年10月1日。总行位于北京金融大街25号，是中央管理的大型国有</span>银行， 国家副部级单位。&nbsp;<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-weight: bold;\">中国建设银行主要经营领域包括公司银行业务、个人银行业务和资金业务，在29个国家和地区设有分支机构及子公司，拥有基金、租赁、信托、人寿、财险、投行、期货、养老金等多个行业的子公司。</span><p><br></p></div>');
INSERT INTO `bank` VALUES (3, '中国民生银行11', '股份制商业银行', '7,685.66亿美元', '<h1><span style=\"font-weight: bold; font-style: italic;\">民生银行</span></h1>');

-- ----------------------------
-- Table structure for bankcard
-- ----------------------------
DROP TABLE IF EXISTS `bankcard`;
CREATE TABLE `bankcard`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '银行卡编号 主键自增',
  `cardBank` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡所属银行',
  `type` int(10) NULL DEFAULT NULL COMMENT '银行卡类型（1：借记卡  2：信用卡）',
  `cardNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡号',
  `userId` int(10) NULL DEFAULT NULL COMMENT '银行卡所属用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bankcard
-- ----------------------------
INSERT INTO `bankcard` VALUES (1, '中国建设银行', 1, '12345678945213124', 1);
INSERT INTO `bankcard` VALUES (6, '中国民生银行', 1, '12345678998765432', 1);
INSERT INTO `bankcard` VALUES (7, '中国邮政储蓄银行', 2, '1234567891234567', 6);

-- ----------------------------
-- Table structure for change_money
-- ----------------------------
DROP TABLE IF EXISTS `change_money`;
CREATE TABLE `change_money`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '零钱理财产品 主键id',
  `name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '理财产品名称',
  `annualIncome` decimal(10, 8) NULL DEFAULT NULL COMMENT '七日年化收益率',
  `peiIncome` decimal(10, 2) NULL DEFAULT NULL COMMENT '每万元收益',
  `invesTerm` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资期限',
  `invesMoney` decimal(10, 2) NULL DEFAULT NULL COMMENT '起投金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of change_money
-- ----------------------------
INSERT INTO `change_money` VALUES (1, '支付宝零钱理财', 0.03435000, 0.99, '30天', 100.00);
INSERT INTO `change_money` VALUES (2, '微信零钱理财', 0.03236000, 0.98, '30天', 100.00);
INSERT INTO `change_money` VALUES (3, '理财通零钱理财', 0.03222000, 0.97, '30天', 300.00);
INSERT INTO `change_money` VALUES (4, '云闪付理财', 0.03233000, 0.88, '三个月', 200.00);

-- ----------------------------
-- Table structure for flow_of_funds
-- ----------------------------
DROP TABLE IF EXISTS `flow_of_funds`;
CREATE TABLE `flow_of_funds`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '资金记录表 id主键自增',
  `userId` int(10) NULL DEFAULT NULL COMMENT '所属用户',
  `flowMoney` decimal(20, 2) NULL DEFAULT NULL COMMENT '金额',
  `type` int(10) NULL DEFAULT NULL COMMENT '类型（1：支出  2：收入）',
  `source` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源',
  `createTime` date NULL DEFAULT NULL COMMENT '创建时间',
  `fundDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of flow_of_funds
-- ----------------------------
INSERT INTO `flow_of_funds` VALUES (2, 1, 100.00, 1, '支付宝零钱理财', '2020-03-12', '无');
INSERT INTO `flow_of_funds` VALUES (3, 1, 100.00, 1, '理财通零钱理财', '2020-03-12', '无');
INSERT INTO `flow_of_funds` VALUES (4, 1, 2000.00, 1, '工资理财', '2020-03-12', '期货');
INSERT INTO `flow_of_funds` VALUES (5, 1, 1000.00, 1, '工资理财', '2020-03-12', '国债');
INSERT INTO `flow_of_funds` VALUES (6, 1, 8000.00, 1, 'P2P期限理财', '2020-03-12', '无');
INSERT INTO `flow_of_funds` VALUES (7, 1, 5000.00, 1, '支付宝期限理财', '2020-03-12', '无');
INSERT INTO `flow_of_funds` VALUES (8, 1, 100.00, 1, '长信利发债券', '2020-03-12', '无');
INSERT INTO `flow_of_funds` VALUES (9, 1, 100.00, 1, '广发多元新兴股票', '2020-03-12', '无');
INSERT INTO `flow_of_funds` VALUES (10, 1, 2000.00, 1, '工资理财', '2020-03-12', '期货');
INSERT INTO `flow_of_funds` VALUES (11, 2, 100.00, 1, '支付宝零钱理财', '2020-03-12', '无');
INSERT INTO `flow_of_funds` VALUES (12, 1, 8000.00, 1, 'P2P期限理财', '2020-03-15', '无');
INSERT INTO `flow_of_funds` VALUES (15, 6, 100.00, 1, '支付宝零钱理财', '2020-03-16', '无');
INSERT INTO `flow_of_funds` VALUES (16, 6, 2000.00, 1, '工资理财', '2020-03-16', '期货');
INSERT INTO `flow_of_funds` VALUES (17, 3, 200.00, 1, '云闪付理财', '2020-03-18', '无');

-- ----------------------------
-- Table structure for fund_product
-- ----------------------------
DROP TABLE IF EXISTS `fund_product`;
CREATE TABLE `fund_product`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '基金理财产品  主键id',
  `type` int(10) NULL DEFAULT NULL COMMENT '基金类型(1:股票型基金  2:债券型基金  3:货币型基金  4:混合型基金)',
  `code` int(10) NULL DEFAULT NULL COMMENT '基金代码',
  `fundDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '基金简称',
  `dailyGrowth` decimal(10, 8) NULL DEFAULT NULL COMMENT '日增长率',
  `monthlyGrowth` decimal(10, 8) NULL DEFAULT NULL COMMENT '月增长率',
  `annualGrowth` decimal(10, 8) NULL DEFAULT NULL COMMENT '年增长率',
  `leastMoney` decimal(10, 2) NULL DEFAULT NULL COMMENT '起投金额',
  `invesTerm` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资期限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of fund_product
-- ----------------------------
INSERT INTO `fund_product` VALUES (1, 1, 143745, '广发多元新兴股票', -0.02720000, 0.06090000, 0.80550000, 100.00, '两个月');
INSERT INTO `fund_product` VALUES (2, 4, 519933, '长信利发债券', -0.00100000, 0.03030000, 0.23820000, 100.00, '一个月');

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '消息编号 主键自增',
  `sendId` int(10) NULL DEFAULT NULL COMMENT '消息发送者id（admin）',
  `receiveId` int(10) NULL DEFAULT NULL COMMENT '消息接收者id（user）',
  `createTime` date NULL DEFAULT NULL COMMENT '消息创建时间',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息标题',
  `infoDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息内容',
  `status` int(10) NULL DEFAULT NULL COMMENT '消息状态（0：未读  1：已读）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES (3, 1, 1, '2020-03-13', 'World', '测试内容', 1);
INSERT INTO `info` VALUES (4, 1, 1, '2020-03-15', '还款通知', '用户lisi申请的9999.00元网贷该还款了！该提醒发送人为：admin', 1);
INSERT INTO `info` VALUES (6, 1, 3, '2020-03-18', '网贷审核通过', '用户zhangsan的123.00元网贷申请审核通过！审核人为：admin', 0);

-- ----------------------------
-- Table structure for loan
-- ----------------------------
DROP TABLE IF EXISTS `loan`;
CREATE TABLE `loan`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '网贷信息表id 主键自增',
  `loanId` int(10) NULL DEFAULT NULL COMMENT '借贷人id（用户）',
  `examineId` int(10) NULL DEFAULT NULL COMMENT '审核人id（管理员）',
  `loanTime` date NULL DEFAULT NULL COMMENT '借贷时间',
  `amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '借贷金额',
  `term` int(20) NULL DEFAULT NULL COMMENT '借贷期限（天）',
  `rate` decimal(10, 8) NULL DEFAULT NULL COMMENT '固定年借贷利率',
  `applyStatus` int(10) NULL DEFAULT NULL COMMENT '申请状态（0：未审核  1：审核未通过  2：审核通过）',
  `loanStatus` int(10) NULL DEFAULT NULL COMMENT '借贷状态（0：未逾期  1：逾期  2：已还请）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of loan
-- ----------------------------
INSERT INTO `loan` VALUES (2, 1, NULL, '2020-03-13', 123.00, 10, 0.28450000, 1, 0);
INSERT INTO `loan` VALUES (3, 1, NULL, '2020-03-13', 9999.00, 456, 0.28450000, 2, 2);
INSERT INTO `loan` VALUES (4, 6, NULL, '2020-03-16', 5555.00, 55, 0.28450000, 0, 0);
INSERT INTO `loan` VALUES (5, 3, 1, '2020-03-18', 233.00, 30, 0.28450000, 2, 2);
INSERT INTO `loan` VALUES (6, 3, 1, '2020-03-18', 123.00, 123, 0.28450000, 2, 0);

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '新闻资讯id 主键自增',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `newsDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `createTime` date NULL DEFAULT NULL COMMENT '新闻发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, '个人理财简介', '个人理财，是在对个人收入、资产、负债等数据进行分析整理的基础上，根据个人对风险的偏好和承受能力，结合预定目标运用诸如储蓄、保险、证券、外汇、收藏、住房投资等多种手段管理资产和负债，合理安排资金，从而在个人风险可以接受范围内实现资产增值的最大化的过程。', '2020-03-09');
INSERT INTO `news` VALUES (2, '书籍推荐', '《个人理财(第4版)》是一本探讨个人如何更好地通过投资理财活动让财富不断增加的实用教材。\r\n\r\n本书是美国个人理财教科书中最受欢迎之一，也是考美国个人理财规划师最常用的参考书。全书包括五个部分，共十八章，分别从理财规划基础知识和基本概念、如何管理好自己的金钱、如何利用保险保护自己、如何更好地进行投资管理以及需要注意的生命周期内财务事件等方面出发，对个人理财的各种技巧 和方法进行深入浅出而又细致全面的讲解，建立起了一个非常完整的理财框架体系。', '2020-03-10');

-- ----------------------------
-- Table structure for pay_money
-- ----------------------------
DROP TABLE IF EXISTS `pay_money`;
CREATE TABLE `pay_money`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '工资理财 主键id',
  `monthMoney` decimal(10, 2) NULL DEFAULT NULL COMMENT '每月金额设定',
  `autoInto` int(10) NULL DEFAULT NULL COMMENT '1:每月自动转入   2：每月不自动转入',
  `type` int(10) NULL DEFAULT NULL COMMENT '产品类型（1：国债  2：期货）',
  `invesTerm` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资期限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pay_money
-- ----------------------------
INSERT INTO `pay_money` VALUES (1, 1000.00, 1, 1, '半年');
INSERT INTO `pay_money` VALUES (2, 2000.00, 2, 2, '一年');
INSERT INTO `pay_money` VALUES (3, 3600.00, 2, 1, '两年');

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '权限id 主键自增',
  `permission` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of permissions
-- ----------------------------
INSERT INTO `permissions` VALUES (1, 'user:finance');
INSERT INTO `permissions` VALUES (2, 'user:changeMoney');
INSERT INTO `permissions` VALUES (3, 'user:payMoney');
INSERT INTO `permissions` VALUES (4, 'user:termFinancial');
INSERT INTO `permissions` VALUES (5, 'user:fundProduct');
INSERT INTO `permissions` VALUES (6, 'user:bank');
INSERT INTO `permissions` VALUES (7, 'user:tools');
INSERT INTO `permissions` VALUES (8, 'user:loan');
INSERT INTO `permissions` VALUES (9, 'user:record');
INSERT INTO `permissions` VALUES (10, 'admin:userInfo');
INSERT INTO `permissions` VALUES (11, 'admin:bankCard');
INSERT INTO `permissions` VALUES (12, 'admin:reputation');
INSERT INTO `permissions` VALUES (13, 'admin:userInfoElse');
INSERT INTO `permissions` VALUES (14, 'admin:finance');
INSERT INTO `permissions` VALUES (15, 'admin:changeMoney');
INSERT INTO `permissions` VALUES (16, 'admin:payMoney');
INSERT INTO `permissions` VALUES (17, 'admin:termFinancial');
INSERT INTO `permissions` VALUES (18, 'admin:fundProduct');
INSERT INTO `permissions` VALUES (19, 'admin:bank');
INSERT INTO `permissions` VALUES (20, 'admin:permission');
INSERT INTO `permissions` VALUES (21, 'admin:userPermissions');
INSERT INTO `permissions` VALUES (22, 'admin:adminPermissions');
INSERT INTO `permissions` VALUES (23, 'admin:loan');
INSERT INTO `permissions` VALUES (24, 'admin:loanExam');
INSERT INTO `permissions` VALUES (25, 'admin:loanInfo');

-- ----------------------------
-- Table structure for term_financial
-- ----------------------------
DROP TABLE IF EXISTS `term_financial`;
CREATE TABLE `term_financial`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '期限理财产品 主键id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `invesTerm` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资期限',
  `leastMoney` decimal(10, 2) NULL DEFAULT NULL COMMENT '起投金额',
  `profit` int(10) NULL DEFAULT NULL COMMENT '收益方式(1:收益型  2:净值型)',
  `annualIncome` decimal(10, 8) NULL DEFAULT NULL COMMENT '七日年化收益率',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of term_financial
-- ----------------------------
INSERT INTO `term_financial` VALUES (1, '支付宝期限理财', '半年', 5000.00, 1, 0.04489000);
INSERT INTO `term_financial` VALUES (2, 'P2P期限理财', '一年', 8000.00, 2, 0.04371000);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id 主键自增',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `realname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `IDcard` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `paypwd` int(40) NULL DEFAULT NULL COMMENT '交易密码',
  `status` int(10) NULL DEFAULT NULL COMMENT '用户状态（0：离线   1：在线）',
  `reputation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户信誉',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'lisi', '李四', 'e10adc3949ba59abbe56e057f20f883e', '110101199703142123', '15188888888', '123123@qq.com', 123456, 1, '良好');
INSERT INTO `user` VALUES (2, 'inmaps', '赵六', 'e10adc3949ba59abbe56e057f20f883e', '110101199608142123', '12345678912', '2333@233.com', 123456, 0, '超级优秀');
INSERT INTO `user` VALUES (3, 'zhangsan', '张三', 'e10adc3949ba59abbe56e057f20f883e', '110101199703142123', '15188888888', '567567@qq.com', 123456, 0, '良好');
INSERT INTO `user` VALUES (4, 'wangwu', '王五', 'e10adc3949ba59abbe56e057f20f883e', NULL, '13338106110', '567567@qq.com', NULL, 0, '差');
INSERT INTO `user` VALUES (6, 'zhaoliu', NULL, 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL, NULL, 0, '良好');

-- ----------------------------
-- Table structure for user_change_money
-- ----------------------------
DROP TABLE IF EXISTS `user_change_money`;
CREATE TABLE `user_change_money`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户-零钱理财 投资表id 主键自增',
  `userId` int(10) NULL DEFAULT NULL COMMENT '用户id',
  `changeId` int(10) NULL DEFAULT NULL COMMENT '零钱理财产品id',
  `startTime` date NULL DEFAULT NULL COMMENT '起投时间',
  `averYield` decimal(10, 8) NULL DEFAULT NULL COMMENT '平均收益率',
  `profit` decimal(20, 2) NULL DEFAULT NULL COMMENT '收益',
  `status` int(10) NULL DEFAULT NULL COMMENT '投资状态（1：持有中  2：已失效  3：已撤销）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_change_money
-- ----------------------------
INSERT INTO `user_change_money` VALUES (9, 1, 1, '2020-03-12', 0.03435000, 3.44, 3);
INSERT INTO `user_change_money` VALUES (10, 1, 3, '2020-03-12', 0.03222000, 3.22, 2);
INSERT INTO `user_change_money` VALUES (11, 2, 1, '2020-03-12', 0.03435000, 3.44, 1);
INSERT INTO `user_change_money` VALUES (12, 6, 1, '2020-03-15', 0.03435000, 3.44, 1);
INSERT INTO `user_change_money` VALUES (13, 6, 1, '2020-03-15', 0.03435000, 3.44, 1);
INSERT INTO `user_change_money` VALUES (14, 6, 1, '2020-03-16', 0.03435000, 3.44, 1);
INSERT INTO `user_change_money` VALUES (15, 3, 4, '2020-03-18', 0.03233000, 6.47, 1);

-- ----------------------------
-- Table structure for user_fund_product
-- ----------------------------
DROP TABLE IF EXISTS `user_fund_product`;
CREATE TABLE `user_fund_product`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户-基金理财 投资表id 主键 自增',
  `userId` int(10) NULL DEFAULT NULL COMMENT '用户id',
  `fundId` int(10) NULL DEFAULT NULL COMMENT '基金产品id',
  `startTime` date NULL DEFAULT NULL COMMENT '起投时间',
  `averYield` decimal(10, 8) NULL DEFAULT NULL COMMENT '平均投资率',
  `profit` decimal(10, 2) NULL DEFAULT NULL COMMENT '收益',
  `status` int(10) NULL DEFAULT NULL COMMENT '投资状态（1：持有中  2：已失效  3：已撤销）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_fund_product
-- ----------------------------
INSERT INTO `user_fund_product` VALUES (3, 1, 2, '2020-03-12', 0.03030000, 3.03, 1);
INSERT INTO `user_fund_product` VALUES (4, 1, 1, '2020-03-12', 0.06090000, 6.09, 3);

-- ----------------------------
-- Table structure for user_pay_money
-- ----------------------------
DROP TABLE IF EXISTS `user_pay_money`;
CREATE TABLE `user_pay_money`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户-工资理财 投资表id 主键自增',
  `userId` int(10) NULL DEFAULT NULL COMMENT '用户id',
  `payId` int(10) NULL DEFAULT NULL COMMENT '工资理财产品id',
  `startTime` date NULL DEFAULT NULL COMMENT '起投时间',
  `averYield` decimal(10, 8) NULL DEFAULT NULL COMMENT '平均收益率',
  `profit` decimal(20, 2) NULL DEFAULT NULL COMMENT '收益',
  `status` int(10) NULL DEFAULT NULL COMMENT '投资状态（1：持有中  2：已失效  3：已撤销）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_pay_money
-- ----------------------------
INSERT INTO `user_pay_money` VALUES (5, 1, 2, '2020-03-12', 0.03123000, 62.46, 1);
INSERT INTO `user_pay_money` VALUES (6, 1, 1, '2020-03-12', 0.03123000, 31.23, 1);
INSERT INTO `user_pay_money` VALUES (7, 1, 2, '2020-03-12', 0.03123000, 62.46, 3);
INSERT INTO `user_pay_money` VALUES (8, 6, 2, '2020-03-16', 0.03123000, 62.46, 1);

-- ----------------------------
-- Table structure for user_permissions
-- ----------------------------
DROP TABLE IF EXISTS `user_permissions`;
CREATE TABLE `user_permissions`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户权限中间表id 主键自增',
  `userId` int(10) NULL DEFAULT NULL COMMENT '用户id',
  `permissionId` int(10) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 96 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_permissions
-- ----------------------------
INSERT INTO `user_permissions` VALUES (87, 1, 1);
INSERT INTO `user_permissions` VALUES (88, 1, 2);
INSERT INTO `user_permissions` VALUES (89, 1, 3);
INSERT INTO `user_permissions` VALUES (90, 1, 4);
INSERT INTO `user_permissions` VALUES (91, 1, 5);
INSERT INTO `user_permissions` VALUES (92, 1, 6);
INSERT INTO `user_permissions` VALUES (93, 1, 7);
INSERT INTO `user_permissions` VALUES (94, 1, 9);
INSERT INTO `user_permissions` VALUES (95, 1, 8);

-- ----------------------------
-- Table structure for user_term_financial
-- ----------------------------
DROP TABLE IF EXISTS `user_term_financial`;
CREATE TABLE `user_term_financial`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户-期限理财 投资表id 主键自增',
  `userId` int(10) NULL DEFAULT NULL COMMENT '用户id',
  `termId` int(10) NULL DEFAULT NULL COMMENT '期限理财产品id',
  `startTime` date NULL DEFAULT NULL COMMENT '起投时间',
  `averYield` decimal(10, 8) NULL DEFAULT NULL COMMENT '平均收益率',
  `profit` decimal(10, 2) NULL DEFAULT NULL COMMENT '收益',
  `status` int(10) NULL DEFAULT NULL COMMENT '投资状态（1：持有中  2：已失效  3：已撤销）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_term_financial
-- ----------------------------
INSERT INTO `user_term_financial` VALUES (3, 1, 2, '2020-03-12', 0.04371000, 349.68, 1);
INSERT INTO `user_term_financial` VALUES (4, 1, 1, '2020-03-12', 0.04489000, 224.45, 3);
INSERT INTO `user_term_financial` VALUES (5, 1, 2, '2020-03-15', 0.04371000, 349.68, 1);

SET FOREIGN_KEY_CHECKS = 1;
