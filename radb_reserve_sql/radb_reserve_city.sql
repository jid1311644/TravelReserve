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
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `city` (
  `city_id` char(3) NOT NULL,
  `city_name` varchar(10) NOT NULL,
  `province_name` varchar(10) NOT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES ('101','北京','北京'),('102','天津','天津'),('103','石家庄','河北'),('108','太原','山西'),('111','大同','山西'),('113','呼和浩特','内蒙古'),('130','大连','辽宁'),('131','沈阳','辽宁'),('132','丹东','辽宁'),('133','锦州','辽宁'),('134','鞍山','辽宁'),('135','朝阳','辽宁'),('137','长春','吉林'),('140','通化','吉林'),('141','哈尔滨','黑龙江'),('143','佳木斯','黑龙江'),('145','齐齐哈尔','黑龙江'),('151','上海','上海'),('152','南京','江苏'),('153','无锡','江苏'),('154','常州','江苏'),('157','扬州','江苏'),('161','杭州','浙江'),('163','宁波','浙江'),('168','合肥','安徽'),('169','黄山','安徽'),('170','阜阳','安徽'),('171','池州','安徽'),('172','安庆','安徽'),('173','厦门','福建'),('174','福州','福建'),('178','南昌','江西'),('184','青岛','山东'),('185','济南','山东'),('186','烟台','山东'),('188','威海','山东'),('192','郑州','河南'),('193','洛阳','河南'),('195','武汉','湖北'),('196','宜昌','湖北'),('199','神农架','湖北'),('200','长沙','湖南'),('201','张家界','湖南'),('206','广州','广东'),('207','深圳','广东'),('208','珠海','广东'),('212','南宁','广西'),('213','桂林','广西'),('219','三亚','海南'),('220','海口','海南'),('221','重庆','重庆'),('224','成都','四川'),('228','宜宾','四川'),('237','贵阳','贵州'),('238','遵义','贵州'),('247','昆明','云南'),('248','丽江','云南'),('251','大理','云南'),('253','香格里拉','云南'),('256','普洱','云南'),('259','拉萨','西藏'),('264','西安','陕西'),('269','兰州','甘肃'),('270','敦煌','甘肃'),('271','嘉峪关','甘肃'),('272','庆阳','甘肃'),('273','金昌','甘肃'),('274','张掖','甘肃'),('275','天水','甘肃'),('276','夏河','甘肃'),('277','西宁','青海'),('281','银川','宁夏'),('282','中卫','宁夏'),('283','固原','宁夏'),('284','乌鲁木齐','新疆');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
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
