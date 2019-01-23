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
-- Table structure for table `hotel_room`
--

DROP TABLE IF EXISTS `hotel_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hotel_room` (
  `hotel_number` varchar(10) NOT NULL,
  `room_type` varchar(10) NOT NULL,
  `price` float(6,2) NOT NULL,
  `total_rooms` int(11) NOT NULL,
  `vacant_rooms` int(11) NOT NULL,
  PRIMARY KEY (`hotel_number`,`room_type`),
  CONSTRAINT `hotel_room_ibfk_1` FOREIGN KEY (`hotel_number`) REFERENCES `hotel` (`hotel_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_room`
--

LOCK TABLES `hotel_room` WRITE;
/*!40000 ALTER TABLE `hotel_room` DISABLE KEYS */;
INSERT INTO `hotel_room` VALUES ('10100001','大床房',285.00,30,6),('10100001','标准间',256.00,20,13),('10100001','高级套房',840.00,3,3),('10100002','大床房',153.00,50,24),('10100002','标准间',153.00,50,16),('10100002','高级套房',353.00,20,16),('10100003','大床房',558.00,100,85),('10100003','标准间',646.00,100,64),('10100003','高级套房',842.00,80,69),('13100001','大床房',147.00,100,58),('13100001','标准间',165.00,100,43),('13100001','高级套房',339.00,10,4),('13100002','大床房',183.00,90,61),('13100002','标准间',200.00,100,54),('13100002','高级套房',341.00,40,34),('15100001','大床房',258.00,100,5),('15100001','标准间',278.00,100,30),('15100001','高级套房',398.00,70,38),('15100002','大床房',305.00,50,17),('15100002','标准间',366.00,70,12),('15100002','高级套房',510.00,30,27),('15100003','大床房',258.00,80,14),('15100003','标准间',296.00,100,21),('15100003','高级套房',463.00,20,17),('15200001','大床房',471.00,50,33),('15200001','标准间',527.00,50,44),('15200001','高级套房',654.00,10,10),('15200002','大床房',239.00,100,24),('15200002','标准间',248.00,100,10),('15200002','高级套房',300.00,50,39),('15200003','大床房',325.00,60,50),('15200003','标准间',325.00,60,44),('15200003','高级套房',556.00,20,17),('15200004','大床房',167.00,100,23),('15200004','标准间',202.00,100,55),('15200004','高级套房',357.00,10,6),('15200005','大床房',257.00,80,66),('15200005','标准间',279.00,80,10),('15200005','高级套房',351.00,20,4),('26400001','大床房',175.00,100,35),('26400001','标准间',175.00,100,41),('26400001','高级套房',210.00,50,47),('26400002','大床房',116.00,200,144),('26400002','标准间',126.00,200,17),('26400002','高级套房',290.00,20,13),('26400003','大床房',244.00,100,57),('26400003','标准间',244.00,120,33),('26400003','高级套房',327.00,80,69);
/*!40000 ALTER TABLE `hotel_room` ENABLE KEYS */;
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
