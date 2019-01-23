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
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `flight` (
  `flight_number` varchar(10) NOT NULL,
  `price` float(6,2) NOT NULL,
  `seats` int(11) NOT NULL,
  `free_seats` int(11) NOT NULL,
  `departure_city` char(3) NOT NULL,
  `departure_time` char(16) NOT NULL,
  `destination_city` char(3) NOT NULL,
  `destination_time` char(16) NOT NULL,
  PRIMARY KEY (`flight_number`),
  KEY `departure_city` (`departure_city`),
  KEY `destination_city` (`destination_city`),
  CONSTRAINT `flight_ibfk_1` FOREIGN KEY (`departure_city`) REFERENCES `city` (`city_id`),
  CONSTRAINT `flight_ibfk_2` FOREIGN KEY (`destination_city`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES ('东航MU2335',810.00,370,10,'151','06:40','264','09:20'),('东航MU2764',650.00,340,179,'131','12:25','152','14:55'),('东航MU2769',570.00,300,64,'152','11:30','264','13:35'),('东航MU2811',354.00,340,103,'152','08:30','101','10:25'),('东航MU3777',1050.00,400,359,'101','12:30','272','14:35'),('东航MU5103',820.00,400,274,'151','09:00','101','11:20'),('南航CZ3951',920.00,350,321,'101','09:00','151','11:15'),('南航CZ6327',640.00,270,49,'130','14:10','161','16:20'),('南航CZ6452',890.00,240,99,'152','18:35','131','20:50'),('南航CZ6455',660.00,270,31,'131','19:35','264','22:55'),('南航CZ9082',500.00,260,22,'101','20:25','153','22:35'),('南航CZ9097',900.00,400,13,'151','06:40','264','09:20'),('南航CZ9207',360.00,400,79,'152','20:50','101','23:00'),('厦航MF8096',513.00,340,44,'130','19:55','161','22:05'),('吉祥航HO1252',790.00,300,199,'101','06:35','151','08:55'),('吉祥航HO1675',850.00,300,224,'152','08:25','131','10:35'),('吉祥航HO1676',310.00,170,3,'131','20:20','152','23:05'),('国航CA155',540.00,200,23,'101','07:15','151','09:30'),('国航CA3491',660.00,290,224,'131','08:05','152','10:55'),('天津航GS7658',621.00,300,11,'152','10:35','264','12:55'),('山航SC8776',705.00,130,114,'130','22:00','161','00:10'),('昆航KY9579',742.00,210,145,'152','09:00','264','11:25'),('春秋9C8743',400.00,120,103,'131','14:35','152','18:55'),('春秋9C8831',614.00,110,97,'131','06:40','264','09:50'),('春秋9C8843',563.00,190,23,'151','06:50','130','09:00'),('海航HU7570',585.00,230,13,'131','20:10','264','23:50'),('深航ZH1557',1280.00,400,397,'101','11:30','151','13:35'),('深航ZH9157',375.00,310,35,'101','06:20','153','08:35'),('深航ZH9708',1032.00,400,357,'152','17:10','131','19:10'),('联航KN5605',945.00,370,325,'101','12:30','272','14:35'),('联航KN5978',475.00,310,21,'151','20:35','101','23:05'),('联航KN5987',473.00,400,12,'101','21:00','151','23:25'),('西藏航TV6705',742.00,200,131,'152','09:00','264','11:25');
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-23 14:45:56
