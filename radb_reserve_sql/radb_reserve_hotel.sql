-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: radb_reserve
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hotel` (
  `hotel_number` varchar(10) NOT NULL,
  `hotel_name` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  `location_city` char(3) NOT NULL,
  PRIMARY KEY (`hotel_number`),
  KEY `location_city` (`location_city`),
  CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`location_city`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES ('10100001','品悦精品公寓','顺义区天竺镇岗山路42号','101'),('10100002','百捷快捷酒店','东城区法华南里10号','101'),('10100003','秋果酒店','朝阳区慈云里甲1号','101'),('13100001','IU酒店','和平区胜利南街12-33号','131'),('13100002','沈阳桃仙小镇精品酒店','浑南区桃仙镇镇宁路村桃仙大街132号','131'),('15100001','零点依精致酒店','静安区恒丰路688号','151'),('15100002','上海精灵王国独家庄园','浦东新区新春村金家宅89号','151'),('15100003','桔子酒店','嘉定区曹安公路1980号','151'),('15200001','南京夫子庙亚朵酒店','秦淮区建康路185号','152'),('15200002','南京喜马拉雅酒店','雨花台区民智路11号','152'),('15200003','锦江都城酒店','江宁区胜太路39号','152'),('15200004','如家快捷酒店','栖霞区和燕路356号','152'),('15200005','南京艺术家酒店','栖霞区仙林大道118号','152'),('26400001','H酒店','蓬湖区丰庆路39号','264'),('26400002','西安咸阳国际机场隆庭宾馆','渭城区西咸新区空港新城','264'),('26400003','西安喜鹊愉家酒店','新城区金花北路长乐荟','264');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-23 14:45:55
