/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : travel

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 14/10/2020 13:59:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attractions
-- ----------------------------
DROP TABLE IF EXISTS `attractions`;
CREATE TABLE `attractions`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attractions_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attractions_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attractions_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attractions_status` int(2) NULL DEFAULT 0,
  `create_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of attractions
-- ----------------------------
INSERT INTO `attractions` VALUES ('1', 'MY_jingdian_01', '清凉寨景区', '蔡店街道西北部', '景区总面积6000余亩，年平均温度低于武汉市中心城区4-6度；山体高大陡峭，植被丰富，层峦叠嶂。木兰清凉寨十里中华樱花、映山红、油菜花、茶花花花飘香，推出的攀水瀑布、古炭窑、滴水观音、九龙飞瀑等旅游景点，加入丰富多彩的祈福、采茶等活动。', 0, '2020-03-04 20:00:09');
INSERT INTO `attractions` VALUES ('9', 'MY_jingdian_06', '桐乡乌镇古镇旅游区', '浙江省嘉兴桐乡市乌镇石佛南路18号', '乌镇是典型的江南水乡古镇，素有“鱼米之乡，丝绸之府”之称。全镇以河成街，桥街相连，依河筑屋，深宅大 院，重脊高檐，河埠廊坊，过街骑楼，穿竹石栏，临河水阁，古色古香，水镇一体，呈现一派古朴、明洁的幽静，是江南典型的“小桥、流水、人家”石板小路，古旧木屋，还有清清湖水的气息，仿佛都在提示着一种情致，一种氛围。\r\n', 0, '2020-03-04 20:00:09');

-- ----------------------------
-- Table structure for hotel
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hotel_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hotel_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hotel_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hotel_status` int(2) NULL DEFAULT 0,
  `create_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hotel
-- ----------------------------
INSERT INTO `hotel` VALUES ('1', 'MY_kezhan_01', '吉安国际酒店111', '吉安县城庐陵大道庐陵广场111', '酒店功能完善，设有包括总统套房、豪华商务套房等各色客房297间，酒店拥有中餐厅、西餐厅、韩国餐厅、火锅餐厅四个不同风味的餐饮场所，就餐总座位数1600余位，另设有可接待500人的宴会厅、可容纳400人的国际会议中心以及夜总会、spa桑拿及足道、露天泳池、健身中心和网球场，可为宾客提供各式全新五星水准的酒店住宿、饮食、宴会、会议、康体和娱乐一体化的服务。另500多个车位的大型停车场，为宾客的出行提供了更多的便利。', 1, '2020-02-05 19:36:37');
INSERT INTO `hotel` VALUES ('11', 'MY_kezhan_01', '海澜大酒店', '江阴市苏南工业重镇新桥镇海澜工业园内', '海澜大酒店是一家商务、会议型豪华酒店，是江阴市首家五星级酒店。酒店座落在苏南工业重镇新桥镇海澜工业园内，北枕长江，南靠太湖，毗邻张家港市中心，宁太（沿江）高速横亘其侧，交通极其便利。酒店按欧式风格设计装修，环境优美，格调高雅。客房舒适、豪华，餐饮风味独特，各类康乐休闲设施一应俱全，设施先进的商务中心随时为您提供周到、快捷的服务。', 0, '2020-02-04 19:37:04');
INSERT INTO `hotel` VALUES ('29', 'MY_kezhan_04', '米兰酒店', '广西省南宁市', '酒店按欧式风格设计装修，环境优美，格调高雅。客房舒适、豪华，餐饮风味独特，各类康乐休闲设施一应俱全，设施先进的商务中心随时为您提供周到、快捷的服务。', 0, '2020-02-04 19:37:49');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for travel_route
-- ----------------------------
DROP TABLE IF EXISTS `travel_route`;
CREATE TABLE `travel_route`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `route_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `route_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `route_status` int(2) NOT NULL DEFAULT 0,
  `route_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `collect_number` int(32) NOT NULL DEFAULT 0,
  `create_date` datetime NULL DEFAULT NULL,
  `update_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of travel_route
-- ----------------------------
INSERT INTO `travel_route` VALUES ('10', '台湾高雄旅游路线', 'D1捷运美丽岛站光之穹顶(0.5小时) → 驳二艺术特区(2小时) → 打狗鉄道故事馆(1小时) → 西子湾风景区(1小时) → 打狗英国领事馆(1小时) → 真爱码头(0.5小时) → 高雄爱河(0.5小时) → 高雄六合夜市(2小时)', 0, '台湾高雄旅', 0, '2020-03-19 09:37:40', NULL);
INSERT INTO `travel_route` VALUES ('11', '澳门旅游路线', 'D1大三巴牌坊(1小时以下) → 恋爱巷(1小时以下) → 疯堂斜巷(1小时以下) → 澳门渔人码头(3小时以上)', 0, '澳门', 0, '2020-03-19 09:37:47', NULL);
INSERT INTO `travel_route` VALUES ('15', '河北北戴河旅游路线：', '\r\nD1老虎石海上公园(4小时) → 碧螺塔酒吧公园(3小时)\r\n\r\nD2鸽子窝公园(2小时) → 奥林匹克大道公园(1小时) → 秦皇岛北戴河怪楼奇园景区(1小时) → 北戴河海滨浴场(2小时)', 0, '河北北戴河', 0, '2020-03-19 09:38:05', NULL);

-- ----------------------------
-- Table structure for travel_strategy
-- ----------------------------
DROP TABLE IF EXISTS `travel_strategy`;
CREATE TABLE `travel_strategy`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '旅游攻略strategy',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `strategy_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `strategy_status` int(255) NULL DEFAULT NULL COMMENT '0是审核通过,1是未审核,2是审核未通过',
  `create_date` datetime NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `error_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `travel_strategy_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of travel_strategy
-- ----------------------------
INSERT INTO `travel_strategy` VALUES ('bd2cbc4285774cc3898e1130032f5b16', '0bc85e2aa9ac44fbb6cb415271bb5014', '1、南普陀请香与别处不同：小木屋可免费请一支清香（不可多取），功德随意投入，一元二元不拘，不投也无妨； 　　2、烧香的地方在天王殿外，香烛不可带进寺院里面；如随身带有香烛的，可以寄放在天王殿门口的义工处，出来时取； 旅行攻略8： 鼓浪屿攻略 至于游玩鼓浪屿的线路，建议走经典线路：龙头路+八卦楼+菽庄花园', 0, '2019-06-22 03:17:54', 'test', NULL);
INSERT INTO `travel_strategy` VALUES ('d9b05e29c91942f9859a9621286421a0', '123123123', '东方明珠塔的陈列馆还是非常值得一逛哦，特别是对于上海宁，这里是上海城市历史发展陈列馆 里面很多的历史场景，也许还都是你爷爷奶奶外公外婆辈的呢呢，所以也很值得带长辈来玩 就是可能会走比较累。 　　登塔时间： 　　如果想看白天的上海那就下午去，最好1点-3点。如果要看太阳西落及夜景，那就5点再去（必然会排队）去之前我查过很多攻略，都说登塔排队拍了好几个小时，我下午3点去的（本来定的2点，但买喜茶耽误到3点了）排队15分钟。', 2, '2019-06-22 02:17:18', '上海东方明珠攻略', '攻略写的不够详细');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0bc85e2aa9ac44fbb6cb415271bb5014', 'qwe', '1234', '老杜');
INSERT INTO `user` VALUES ('123123123', 'user', '123456', '老杨');

-- ----------------------------
-- Table structure for user_attractions
-- ----------------------------
DROP TABLE IF EXISTS `user_attractions`;
CREATE TABLE `user_attractions`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `attractions_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_attractions_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `attractions_id`(`attractions_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_attractions_ibfk_1` FOREIGN KEY (`attractions_id`) REFERENCES `attractions` (`id`) ON DELETE NO ACTION ON UPDATE RESTRICT,
  CONSTRAINT `user_attractions_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_attractions
-- ----------------------------
INSERT INTO `user_attractions` VALUES ('3b753a46dccb427c85aa2a1583fbe37a', '123123123', '1', NULL, '2020-02-19 12:22:21');

-- ----------------------------
-- Table structure for user_hotel
-- ----------------------------
DROP TABLE IF EXISTS `user_hotel`;
CREATE TABLE `user_hotel`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `hotel_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `user_hotel_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_hotel_ibfk_1`(`user_id`) USING BTREE,
  INDEX `user_hotel_ibfk_2`(`hotel_id`) USING BTREE,
  CONSTRAINT `user_hotel_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_hotel_ibfk_2` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_hotel
-- ----------------------------
INSERT INTO `user_hotel` VALUES ('8aac034f162d4154b9606927c304377c', '123123123', '29', NULL, '2020-02-19 12:22:04');

-- ----------------------------
-- Table structure for user_route
-- ----------------------------
DROP TABLE IF EXISTS `user_route`;
CREATE TABLE `user_route`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `route_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `route_id`(`route_id`) USING BTREE,
  CONSTRAINT `user_route_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_route_ibfk_2` FOREIGN KEY (`route_id`) REFERENCES `travel_route` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_route
-- ----------------------------
INSERT INTO `user_route` VALUES ('ae51c1397b3b4782a028c1119e4413c7', '123123123', '15', '2020-02-19 12:07:27');

-- ----------------------------
-- Table structure for user_strategy
-- ----------------------------
DROP TABLE IF EXISTS `user_strategy`;
CREATE TABLE `user_strategy`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `strategy_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `create_date` datetime NULL DEFAULT NULL,
  `update_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_hotel_ibfk_1`(`user_id`) USING BTREE,
  INDEX `user_hotel_ibfk_2`(`strategy_id`) USING BTREE,
  CONSTRAINT `user_strategy_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_strategy_ibfk_2` FOREIGN KEY (`strategy_id`) REFERENCES `travel_strategy` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_strategy
-- ----------------------------
INSERT INTO `user_strategy` VALUES ('d2ee2a844c364b74931b4184f091f6ca', '123123123', 'bd2cbc4285774cc3898e1130032f5b16', '2020-02-19 12:07:58', NULL);

SET FOREIGN_KEY_CHECKS = 1;
