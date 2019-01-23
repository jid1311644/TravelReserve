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
-- Table structure for table `vehicle_reservation`
--

DROP TABLE IF EXISTS `vehicle_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vehicle_reservation` (
  `reservation_id` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `plate_number` char(10) NOT NULL,
  `ticket` int(11) DEFAULT NULL,
  PRIMARY KEY (`reservation_id`,`username`),
  KEY `username` (`username`),
  KEY `plate_number` (`plate_number`),
  CONSTRAINT `vehicle_reservation_ibfk_1` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_id`),
  CONSTRAINT `vehicle_reservation_ibfk_2` FOREIGN KEY (`username`) REFERENCES `reservation` (`username`),
  CONSTRAINT `vehicle_reservation_ibfk_3` FOREIGN KEY (`plate_number`) REFERENCES `vehicle` (`plate_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_reservation`
--

LOCK TABLES `vehicle_reservation` WRITE;
/*!40000 ALTER TABLE `vehicle_reservation` DISABLE KEYS */;
INSERT INTO `vehicle_reservation` VALUES ('V022051','user1','苏C·00124',2),('V022437','user1','苏A·A41A1',NULL),('V022504','user1','苏E·D1124',5),('V135842','user1','苏B·314K5',NULL),('V140314','user1','苏A·1440A',5),('V181410','user3','京A·44712',3);
/*!40000 ALTER TABLE `vehicle_reservation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-23 14:46:00
