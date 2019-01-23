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
-- Table structure for table `hotel_reservation`
--

DROP TABLE IF EXISTS `hotel_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hotel_reservation` (
  `reservation_id` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `hotel_number` varchar(10) NOT NULL,
  `room_type` varchar(10) NOT NULL,
  `room_number` int(11) NOT NULL,
  PRIMARY KEY (`reservation_id`,`username`),
  KEY `username` (`username`),
  KEY `hotel_number` (`hotel_number`),
  CONSTRAINT `hotel_reservation_ibfk_1` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_id`),
  CONSTRAINT `hotel_reservation_ibfk_2` FOREIGN KEY (`username`) REFERENCES `reservation` (`username`),
  CONSTRAINT `hotel_reservation_ibfk_3` FOREIGN KEY (`hotel_number`) REFERENCES `hotel_room` (`hotel_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_reservation`
--

LOCK TABLES `hotel_reservation` WRITE;
/*!40000 ALTER TABLE `hotel_reservation` DISABLE KEYS */;
INSERT INTO `hotel_reservation` VALUES ('H014939','user1','15200001','高级套房',3),('H015137','user1','15200001','高级套房',1),('H015220','user1','15200004','高级套房',2),('H015357','user1','10100003','高级套房',1),('H015423','user1','10100003','高级套房',1),('H134300','user1','15200005','标准间',3),('H181345','user3','10100002','大床房',1),('H181410','user1','10100003','标准间',2);
/*!40000 ALTER TABLE `hotel_reservation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-23 14:45:58
