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
-- Table structure for table `flight_reservation`
--

DROP TABLE IF EXISTS `flight_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `flight_reservation` (
  `reservation_id` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `flight_number` varchar(10) NOT NULL,
  `passenger_id` char(18) NOT NULL,
  PRIMARY KEY (`reservation_id`,`username`,`flight_number`,`passenger_id`),
  KEY `username` (`username`),
  KEY `flight_number` (`flight_number`),
  CONSTRAINT `flight_reservation_ibfk_1` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_id`),
  CONSTRAINT `flight_reservation_ibfk_2` FOREIGN KEY (`username`) REFERENCES `reservation` (`username`),
  CONSTRAINT `flight_reservation_ibfk_3` FOREIGN KEY (`flight_number`) REFERENCES `flight` (`flight_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_reservation`
--

LOCK TABLES `flight_reservation` WRITE;
/*!40000 ALTER TABLE `flight_reservation` DISABLE KEYS */;
INSERT INTO `flight_reservation` VALUES ('F085044','user1','东航MU2764','622827197101303114'),('F085044','user1','东航MU2764','622827197205145431'),('F085044','user1','东航MU2764','622827197211070254'),('F085044','user1','东航MU2764','622827199609100314'),('F010541','user1','南航CZ6327','622827199507280311'),('F131711','user1','天津航GS7658','622827197706310010'),('F131711','user1','天津航GS7658','62282719771111011x'),('F131711','user1','天津航GS7658','622827199507280311'),('F011529','user1','昆航KY9579','622827197101303114'),('F011529','user1','昆航KY9579','622827199609100314'),('F181104','user2','春秋9C8743','547763197503175614'),('F011259','user1','西藏航TV6705','622827197101303114'),('F011259','user1','西藏航TV6705','622827197205145431'),('F011259','user1','西藏航TV6705','622827197211070254'),('F011259','user1','西藏航TV6705','622827197706310010'),('F011259','user1','西藏航TV6705','622827199507280311'),('F011259','user1','西藏航TV6705','622827199609100314');
/*!40000 ALTER TABLE `flight_reservation` ENABLE KEYS */;
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
