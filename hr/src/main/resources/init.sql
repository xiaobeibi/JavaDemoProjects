-- MySQL dump 10.13  Distrib 5.5.25, for Win32 (x86)
--
-- Host: localhost    Database: p-hr
-- ------------------------------------------------------
-- Server version	5.5.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `employee_number` int(10) DEFAULT NULL,
  `day` date DEFAULT NULL,
  `time_type` enum('上午','下午','加班') DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `start_type` enum('正常','迟到','未签到') DEFAULT '未签到',
  `end_time` time DEFAULT NULL,
  `end_type` enum('正常','早退','未签到') DEFAULT '未签到',
  `work_type` enum('上班','请假') DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (1,1001,'2017-07-07','下午','17:01:33','迟到','17:25:15','早退',NULL,NULL),(2,1001,'2017-07-08','上午','08:53:43','正常','11:20:46','早退',NULL,NULL),(3,1001,'2017-07-08','下午','14:25:17','正常',NULL,'未签到',NULL,NULL),(4,1009,'2017-07-10','上午','10:29:35','迟到',NULL,'未签到',NULL,NULL),(5,1009,'2017-07-10','下午','16:42:01','迟到','16:42:25','早退',NULL,NULL),(6,1009,'2017-07-10','加班','19:31:46','正常',NULL,'未签到',NULL,NULL),(7,1009,'2017-07-11','上午','09:21:13','迟到',NULL,'未签到',NULL,NULL),(8,1009,'2017-07-12','上午','09:09:53','迟到',NULL,'未签到',NULL,NULL),(9,1009,'2017-07-12','下午','15:31:03','迟到',NULL,'未签到',NULL,NULL),(10,1001,'2017-07-12','下午','15:34:58','迟到',NULL,'未签到',NULL,NULL),(11,1007,'2017-07-12','下午','15:51:24','迟到',NULL,'未签到',NULL,NULL),(12,1008,'2017-07-12','下午','16:48:03','迟到',NULL,'未签到',NULL,NULL),(13,1009,'2017-07-12','加班','21:02:35','迟到',NULL,'未签到',NULL,NULL),(14,1010,'2017-07-12','加班','21:24:34','迟到',NULL,'未签到',NULL,NULL);
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `department_number` int(10) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `manager` varchar(10) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,2001,'急诊科','王生安','0923-3456180','住院楼101',''),(2,2002,'骨科','贺易','0923-3456324','门诊楼304',''),(3,2003,'内分泌科  ','周卓浩','0923-3456909','门诊楼205',''),(4,2004,'神经内科 ','何刚名','0923-3456231','门诊楼109',''),(5,2005,'神经外科','王成文 ','0923-3456782','门诊楼102',''),(6,2006,'消化内科 ','严席华','0923-3456098','门诊楼201',''),(7,2007,'检验科','云介融 ','0923-3456143','医技楼104',''),(8,2008,'体检中心 ','范湖','0923-3456677','医技楼203',''),(9,2009,'放射科  ','吴敬序','0923-3456489','医技楼305',''),(10,2010,'护理部    ','凌月青','0923-3456210','住院楼109',''),(11,2011,'康复理疗科 ','丁频佟','0923-3456724','医技楼208',''),(12,2012,'药剂科','王缘','0923-3456423','医技楼302',''),(13,2013,'人事部','李烨','0923-2456123','办公楼108','');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `employee_number` int(10) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `gender` enum('男','女') DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `telephone` varchar(15) DEFAULT '',
  `email` varchar(30) DEFAULT '',
  `address` varchar(50) DEFAULT NULL,
  `photo` varchar(50) DEFAULT '',
  `education` varchar(20) DEFAULT '',
  `department_number` int(10) DEFAULT NULL,
  `position_number` int(10) DEFAULT NULL,
  `in_time` date DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `notes` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `department_number` (`department_number`),
  KEY `title_number` (`position_number`),
  KEY `employee_number` (`employee_number`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,1001,'admin','男','1995-10-18','15678015439','','','','',2013,3009,'2017-02-22','1001',''),(2,1007,'刘涛','女','1996-03-04','18907327612','',NULL,'','',2001,3003,'2017-01-10','1007',''),(3,1008,'成龙','男','1995-06-06','13464238971','','','','',2007,3003,'2017-06-28','1008',''),(4,1009,'张智霖','男','1995-09-24','15810239904','','','','',2013,3009,'2017-02-06','1009',''),(5,1010,'陈小春','男','1995-01-26','17871239756','','','','',2013,3010,'2017-05-12','1010',''),(6,1011,'黎明','男','1995-03-29','18832013916','','河北沧州',NULL,'大学本科',2007,3003,'2017-07-05','1011',''),(7,1012,'张宇','男','1997-03-04','18832050264','','河北张家口',NULL,'大学本科',2013,3009,'2017-07-05','1012','');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `employee_number` int(10) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `gender` enum('男','女') DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `telephone` varchar(20) DEFAULT '',
  `email` varchar(30) DEFAULT '',
  `address` varchar(50) DEFAULT '',
  `photo` varchar(50) DEFAULT '',
  `education` varchar(20) DEFAULT '',
  `in_time` date DEFAULT NULL,
  `out_time` date DEFAULT NULL,
  `department_number` int(10) DEFAULT NULL,
  `position_number` int(10) DEFAULT NULL,
  `status` enum('离职','在职','退休') DEFAULT NULL,
  `home` varchar(100) DEFAULT '',
  `notes` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (1,1001,'admin','男','1995-10-18','15678015439','','','','','2017-02-22',NULL,2001,3002,'在职','',''),(2,1002,'王秀英','女','1992-03-08','15590678821','','','','','2011-04-29','2017-07-04',2011,3004,'离职','',''),(3,1003,'李强','男','1993-12-22','18929778634','','','','','2010-05-06','2017-07-05',2010,3007,'退休','',''),(4,1004,'刘洋','男','1991-07-26','13807987324','','','','','2009-12-23','2017-07-04',2009,3005,'退休','',''),(5,1005,'李敏','女','1991-01-03','13791826142','','','','','2010-03-29','2017-07-05',2008,3004,'退休','',''),(6,1006,'王伟 ','女','1990-06-12','13986207926','','','','','2010-10-12','2017-07-06',2012,3005,'离职','',''),(7,1007,'李烨','女','1996-03-04','18907327612','','','','','2017-01-10',NULL,2001,3003,'离职','',''),(8,1008,'刘旭亮','男','1995-06-00','13464238971','','','','','2017-06-28',NULL,2002,3001,'在职','',''),(9,1009,'张彤','男','1995-09-24','15810239904','','','','','2017-02-06',NULL,2002,3003,'在职','',''),(10,1010,'杨杰','男','1995-01-26','17871239756','','','','','2017-05-12',NULL,2003,3003,'在职','',''),(11,1011,'唐治涛','男','1995-03-29','18832013916','819564344@qq.com','河北沧州','','大学本科','2017-07-05',NULL,2010,3006,'在职','',''),(12,1012,'张璐','男','1997-03-11','18832050264','1215959210@qq.com','河北省张家口','','本科','2017-07-05',NULL,2009,3004,'在职','','');
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lea`
--

DROP TABLE IF EXISTS `lea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lea` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `employee_number` int(10) DEFAULT NULL,
  `department_number` int(10) DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `days` varchar(10) DEFAULT NULL,
  `reason` varchar(100) DEFAULT NULL,
  `type` enum('事假','病假') DEFAULT NULL,
  `manager` varchar(10) DEFAULT NULL,
  `status` enum('已批准','未批准') DEFAULT '未批准',
  `notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lea`
--

LOCK TABLES `lea` WRITE;
/*!40000 ALTER TABLE `lea` DISABLE KEYS */;
INSERT INTO `lea` VALUES (1,1007,2007,'2017-07-11','2017-07-12','1','家中有事','事假',NULL,'未批准',NULL),(2,1008,2007,'2017-07-10','2017-07-12','2','偶感风寒','病假',NULL,'已批准',NULL),(3,1011,2007,'2017-07-11','2017-07-11','1','回家看看','事假',NULL,'已批准',NULL),(7,1008,2007,'2017-07-14','2017-07-17','3','真的有点事','事假',NULL,'已批准',NULL),(8,1009,2013,'2017-07-05','2017-07-06','1','回家看看','事假',NULL,'已批准',NULL),(9,1012,2013,'2017-07-08','2017-07-08','1','摊上事了','事假',NULL,'已批准',NULL),(10,1012,2013,'2017-07-13','2017-07-14','1','真的有点事','事假',NULL,'已批准',NULL),(11,1001,NULL,'2017-09-29','2017-09-30','2','国庆节出去玩','事假',NULL,'未批准',NULL),(12,1007,NULL,'2017-09-28','2017-09-30','3','去拍电影','事假',NULL,'未批准',NULL),(13,1012,NULL,'2017-09-29','2017-09-30','3','开演唱会','事假',NULL,'未批准',NULL);
/*!40000 ALTER TABLE `lea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `move`
--

DROP TABLE IF EXISTS `move`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `move` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `employee_number` int(10) DEFAULT NULL,
  `before` int(10) DEFAULT NULL,
  `after` int(10) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `manager` varchar(10) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `move`
--

LOCK TABLES `move` WRITE;
/*!40000 ALTER TABLE `move` DISABLE KEYS */;
INSERT INTO `move` VALUES (1,1011,2010,2011,'2017-07-10 20:40:20','张彤',NULL),(3,1007,2001,2007,'2017-07-11 09:53:34','张彤',NULL);
/*!40000 ALTER TABLE `move` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `overtime`
--

DROP TABLE IF EXISTS `overtime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `overtime` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `department_number` int(10) DEFAULT NULL,
  `employee_number` int(10) DEFAULT NULL,
  `day` date DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `overtime`
--

LOCK TABLES `overtime` WRITE;
/*!40000 ALTER TABLE `overtime` DISABLE KEYS */;
INSERT INTO `overtime` VALUES (1,2007,1007,'2017-07-12',NULL,NULL,NULL),(2,2001,1008,'2017-07-12',NULL,NULL,NULL),(3,2013,1012,'2017-07-12',NULL,NULL,NULL),(4,2003,1010,'2017-07-12',NULL,NULL,NULL),(8,2011,1011,'2017-07-14',NULL,NULL,NULL);
/*!40000 ALTER TABLE `overtime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `position_number` int(10) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `level` enum('部门主任','部门员工','人事部主任','人事部员工') DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `position_number` (`position_number`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,3001,'主任医师','部门主任',''),(2,3002,'副主任医师','部门员工',''),(3,3003,'医师','部门员工',''),(4,3004,'主任技师','部门主任',''),(5,3005,'副主任技师','部门员工',''),(6,3006,'技师','部门员工',''),(7,3007,'护士长','部门主任',''),(8,3008,'护士','部门员工',''),(9,3009,'人事部主任','人事部主任',''),(10,3010,'人事部员工','人事部员工','');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rewards_punishment`
--

DROP TABLE IF EXISTS `rewards_punishment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rewards_punishment` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `employee_number` int(10) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `reason` varchar(100) DEFAULT NULL,
  `money` float(8,0) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `manager` varchar(10) DEFAULT NULL,
  `notes` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_number` (`employee_number`),
  CONSTRAINT `rewards_punishment_ibfk_1` FOREIGN KEY (`employee_number`) REFERENCES `employee` (`employee_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rewards_punishment`
--

LOCK TABLES `rewards_punishment` WRITE;
/*!40000 ALTER TABLE `rewards_punishment` DISABLE KEYS */;
/*!40000 ALTER TABLE `rewards_punishment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-28 10:07:09
