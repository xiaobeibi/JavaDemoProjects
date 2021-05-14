/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : mypet

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 23/10/2020 10:48:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员的名字',
  `adminPwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `realName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实的名字',
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `Email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birthday` date NOT NULL,
  `sex` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pic` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'a10.png',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '111111', '伟彬', '13912341234', '111@qq.com', '1999-09-08', '男', '5ea1639b-137a-4d8b-8206-eb6279430b35.jpg', '外号 玄宗。这位可是我们团队的玄学的代表。由他在似乎任何困难都能解决。');

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `replay_id` int(11) NULL DEFAULT NULL,
  `comment_id` int(11) NOT NULL,
  `answerTime` date NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk8`(`user_id`) USING BTREE,
  INDEX `fk11`(`comment_id`) USING BTREE,
  INDEX `fk10`(`replay_id`) USING BTREE,
  CONSTRAINT `fk10` FOREIGN KEY (`replay_id`) REFERENCES `answer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk11` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk8` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES (1, 2, NULL, 8, '2020-04-05', '这条狗很好动。 ');
INSERT INTO `answer` VALUES (2, 5, 1, 8, '2020-04-05', '这只宠物很乖。');
INSERT INTO `answer` VALUES (3, 3, 2, 8, '2020-04-05', '我也喜欢这样的宠物。');
INSERT INTO `answer` VALUES (6, 1, NULL, 8, '2020-04-05', '我也喜欢这样的宠物。');
INSERT INTO `answer` VALUES (7, 1, NULL, 11, '2020-04-05', '我也喜欢这样的宠物。');
INSERT INTO `answer` VALUES (8, 30, NULL, 8, '2020-04-05', '我也喜欢这样的宠物。');
INSERT INTO `answer` VALUES (9, 30, NULL, 8, '2020-04-05', '我也喜欢这样的宠物。');
INSERT INTO `answer` VALUES (10, 30, NULL, 12, '2020-04-05', '我也喜欢这样的宠物。');
INSERT INTO `answer` VALUES (11, 30, NULL, 11, '2020-04-05', '我也喜欢这样的宠物。');

-- ----------------------------
-- Table structure for apply
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int(11) NOT NULL,
  `telephone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `message` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `applyTime` date NOT NULL,
  `state` int(11) NULL DEFAULT 2,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of apply
-- ----------------------------
INSERT INTO `apply` VALUES (1, 'Wu Xin', '549281@qq.com', 24, '15712341234', '喜欢动物', '2020-04-07', 3);
INSERT INTO `apply` VALUES (2, '张三丰', '24251@qq.com', 21, '15712341234', '想保护动物', '2020-04-07', 3);
INSERT INTO `apply` VALUES (3, '4334', '4343', 4334, '15712341234', '434343', '2020-04-07', 2);
INSERT INTO `apply` VALUES (4, '公孙策', '2425549@qq.com', 45, '15712341234', '我想保护流浪动物。使得它们有自己的家。', '2020-04-07', 2);

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `actionTime` date NOT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `peoples` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `event` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (1, '2020-04-07', '江西省宿迁市', '张三，李四，王五.', '自愿去春风小区对小区的动物进行检查和医疗', '保护小动物');
INSERT INTO `blog` VALUES (2, '2020-04-07', '江西省宿迁市', '张三,王五', '自愿去春风小区对小区的动物进行检查和医疗', '保护小动物');
INSERT INTO `blog` VALUES (3, '2020-04-07', '江西省宿迁市', '王二麻子,李四', '去收养路边的猫狗1', '保护小动物');
INSERT INTO `blog` VALUES (4, '2020-04-07', '江西省宿迁市', '王二麻子,张三,李四', '去收养路边的猫', '保护小动物');
INSERT INTO `blog` VALUES (5, '2020-04-07', '江西省宿迁市', '张三,李四', '去治疗路边的猫', '保护小动物');
INSERT INTO `blog` VALUES (6, '2020-04-07', '江西省宿迁市', '张三,李四，王五', '去治疗路边的猫狗', '保护小动物');
INSERT INTO `blog` VALUES (7, '2020-04-07', '江西省宿迁市', '王五', '去喂养流浪的猫狗', '保护小动物');
INSERT INTO `blog` VALUES (8, '2020-04-07', '江西省宿迁市', '杨一', '去喂养流浪的猫狗', '保护小动物');
INSERT INTO `blog` VALUES (10, '2020-04-07', '江西省上饶市余干县', '杨一,王二麻子', '去喂养流浪的猫狗', '保护小动物');
INSERT INTO `blog` VALUES (14, '2020-04-07', '十里长亭小公园', '54', '第13批好心宠物收养人集体聚会交流。', '请大家准时参加啊');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `admin_id` int(11) NULL DEFAULT NULL,
  `pet_id` int(11) NULL DEFAULT NULL,
  `commentTime` date NOT NULL,
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论的内容',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk1`(`user_id`) USING BTREE,
  INDEX `fk2`(`pet_id`) USING BTREE,
  INDEX `fk5`(`admin_id`) USING BTREE,
  CONSTRAINT `fk1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`pet_id`) REFERENCES `pet` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk5` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (8, 8, NULL, 5, '2020-04-07', '这条狗不错');
INSERT INTO `comment` VALUES (11, 1, NULL, 5, '2020-04-07', '这条狗很活泼。');
INSERT INTO `comment` VALUES (12, 1, NULL, 5, '2020-04-07', '这条狗很活泼，喜欢在户外玩耍。');

-- ----------------------------
-- Table structure for pet
-- ----------------------------
DROP TABLE IF EXISTS `pet`;
CREATE TABLE `pet`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `petName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `petType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宠物类型',
  `sex` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `birthday` date NOT NULL,
  `pic` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像',
  `state` int(11) NOT NULL DEFAULT 1 COMMENT '现在的状态 0 没有申请领养 1 被申请领养 2 已经被领养',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pet
-- ----------------------------
INSERT INTO `pet` VALUES (1, '淘气旺仔', '柴犬', '雄性', '2020-03-22', 'e85ff25e-efd0-4fff-8c47-a06e7616f189.jpg', 0, '旺仔在一年前被车撞坏了腿，后来主人送给了朋友，谁知道朋友也抛弃了他，旺仔不再活泼，希望好心人接纳他。');
INSERT INTO `pet` VALUES (2, '哈k', '萨摩', '雄性', '2020-03-24', '8bc17cae-f13c-4888-ac28-b9b50aae555f.jpg', 2, '哈k在两岁的时候生了以此大病，被主人给遗弃了，其实他非常的乖巧懂事啊');
INSERT INTO `pet` VALUES (5, '辛巴', '暹罗猫', '雄性', '2020-04-05', '07b78b94-e7db-4d04-a677-abfff13d75d5.jpg', 0, '辛巴活泼又好奇，特别喜欢和别的狗狗玩耍，更十分喜欢户外活动。一个没有儿童的家庭更适合他，你愿意成为辛巴德好朋友，让他继续快乐德成长吗？');
INSERT INTO `pet` VALUES (20, '凯丽', '暹罗猫', '雄性', '2020-04-09', '07b78b94-e7db-4d04-a677-abfff13d75d5.jpg', 0, '特别的乖巧懂事呀');
INSERT INTO `pet` VALUES (21, '小傻', '泰迪', '雄性', '2020-04-09', 'fdf3cfb2-9c9c-4d7b-92db-593223a21bf5.png', 0, '1');
INSERT INTO `pet` VALUES (22, '傻子', '泰迪', '雄性', '2020-04-02', 'e85ff25e-efd0-4fff-8c47-a06e7616f189.jpg', 0, '111');
INSERT INTO `pet` VALUES (23, '大傻', '泰迪', '雄性', '2020-04-16', 'e85ff25e-efd0-4fff-8c47-a06e7616f189.jpg', 0, '测试');
INSERT INTO `pet` VALUES (24, '哔了狗', '哈士奇', '雄性', '2020-04-09', 'e85ff25e-efd0-4fff-8c47-a06e7616f189.jpg', 0, '阿赫');

-- ----------------------------
-- Table structure for t_adopt
-- ----------------------------
DROP TABLE IF EXISTS `t_adopt`;
CREATE TABLE `t_adopt`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户表id的外键',
  `pet_id` int(11) NOT NULL COMMENT '宠物表id的外键',
  `adoptTime` date NOT NULL,
  `state` int(11) NULL DEFAULT 1 COMMENT '是否同意被领养 0 是不同意 1 还在审核 2 是同意',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk3`(`user_id`) USING BTREE,
  INDEX `fk4`(`pet_id`) USING BTREE,
  CONSTRAINT `fk3` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk4` FOREIGN KEY (`pet_id`) REFERENCES `pet` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_adopt
-- ----------------------------
INSERT INTO `t_adopt` VALUES (13, 1, 5, '2020-04-07', 0);
INSERT INTO `t_adopt` VALUES (14, 30, 5, '2020-04-07', 0);
INSERT INTO `t_adopt` VALUES (15, 1, 2, '2020-04-07', 2);
INSERT INTO `t_adopt` VALUES (16, 1, 5, '2020-04-14', 0);

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `Time` date NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('2020-04-07');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `Email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Email',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `pic` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 't9.jpg',
  `state` int(11) NULL DEFAULT 0 COMMENT '有无领养宠物的经历 0 是没有 1 是由',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '张三丰', 'zsf123', '男', 100, '13809182091', '2425549281@qq.com', '湖北武当山', '5f4d2b81-0ed9-4278-b7f6-c38d7aa4efe2.jpg', 1);
INSERT INTO `users` VALUES (2, '宋远桥', 'syq123', '男', 50, '13908457344', '2425549281@qq.com', '湖北武当山', 't2.jpg', 0);
INSERT INTO `users` VALUES (3, '俞莲舟', 'ylz123', '男', 45, '13903827601', '2425549281@qq.com', '湖北武当山', 't3.jpg', 1);
INSERT INTO `users` VALUES (5, '赵敏', 'zm123', '女', 23, '13903810621', '2425549281@qq.com', '蒙古科尔沁', 't5.jpg', 1);
INSERT INTO `users` VALUES (8, '殷素素', 'yss123', '女', 35, '13123819301', '2425549281@qq.com', '光明顶', 't8.jpg', 0);
INSERT INTO `users` VALUES (30, '赵虎', '4444', '男', 32, '15797959509', '2425549281@qq.com', '开封', 't9.jpg', 0);

SET FOREIGN_KEY_CHECKS = 1;
