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
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reservation` (
  `reservation_id` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `time` varchar(20) NOT NULL,
  `type` char(1) NOT NULL,
  PRIMARY KEY (`reservation_id`,`username`),
  KEY `username` (`username`),
  CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES ('F010541','user1','2019-01-08 01:05','F'),('F011259','user1','2019-01-08 01:12','F'),('F011529','user1','2019-01-08 01:15','F'),('F085044','user1','2019-01-04 08:50','F'),('F131711','user1','2019-01-23 13:17','F'),('F181104','user2','2019-01-04 18:11','F'),('H014939','user1','2019-01-08 01:49','H'),('H015137','user1','2019-01-08 01:51','H'),('H015220','user1','2019-01-08 01:52','H'),('H015357','user1','2019-01-08 01:53','H'),('H015423','user1','2019-01-08 01:54','H'),('H134300','user1','2019-01-23 13:43','H'),('H181345','user3','2019-01-04 18:13','H'),('H181410','user1','2019-01-08 01:45','H'),('V022051','user1','2019-01-08 02:20','V'),('V022437','user1','2019-01-08 02:24','V'),('V022504','user1','2019-01-08 02:25','V'),('V135842','user1','2019-01-23 13:58','V'),('V140314','user1','2019-01-23 14:03','V'),('V181410','user3','2019-01-04 18:14','V');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
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
