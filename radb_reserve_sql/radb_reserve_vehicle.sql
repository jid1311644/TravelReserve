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
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vehicle` (
  `plate_number` char(10) NOT NULL,
  `car_type` char(10) NOT NULL,
  `price` float(6,2) NOT NULL,
  `location_city` char(3) NOT NULL,
  PRIMARY KEY (`plate_number`),
  KEY `vehicle_ibfk_1` (`location_city`),
  CONSTRAINT `vehicle_ibfk_1` FOREIGN KEY (`location_city`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES ('京A·44712','机场大巴',20.00,'101'),('京A·BD2C4','商务车',12.00,'101'),('京A·F5401','小轿车',6.00,'101'),('京B·68686','机场大巴',17.00,'101'),('京B·D5114','小轿车',6.00,'101'),('京B·PO401','小轿车',6.00,'101'),('京C·11540','小轿车',8.00,'101'),('京C·77841','商务车',12.00,'101'),('京C·78001','机场大巴',15.00,'101'),('京D·99001','机场大巴',9.00,'101'),('沪A·11A20','小轿车',6.00,'151'),('沪A·15477','机场大巴',15.00,'151'),('沪A·54001','小轿车',6.00,'151'),('沪B·1S2P2','商务车',12.00,'151'),('沪D·P6464','机场大巴',20.00,'151'),('苏A·1440A','机场大巴',17.00,'152'),('苏A·31457','小轿车',7.00,'152'),('苏A·A41A1','小轿车',7.00,'152'),('苏A·H41A7','商务车',13.00,'152'),('苏A·OP970','商务车',25.00,'152'),('苏A·SA182','机场大巴',30.00,'152'),('苏B·31441','小轿车',7.00,'152'),('苏B·314K5','商务车',15.00,'152'),('苏C·00124','机场大巴',20.00,'152'),('苏C·LK564','小轿车',7.00,'152'),('苏D·66540','商务车',20.00,'152'),('苏E·55J96','机场大巴',7.00,'152'),('苏E·D1124','机场大巴',6.00,'152'),('苏E·P5685','小轿车',7.00,'152'),('苏E·ZX123','小轿车',7.00,'152'),('陕A·66JKI','商务车',15.00,'264'),('陕A·A4414','小轿车',5.00,'264'),('陕A·I6410','小轿车',5.00,'264'),('陕A·I6A19','机场大巴',20.00,'264'),('陕A·P6001','机场大巴',3.00,'264'),('陕B·2L00K','小轿车',5.00,'264'),('陕B·54545','商务车',15.00,'264'),('陕C·ZZ11A','机场大巴',4.00,'264');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
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
