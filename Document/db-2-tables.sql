-- MySQL dump 10.13  Distrib 5.5.32, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: ibm_database
-- ------------------------------------------------------
-- Server version	5.5.32-0ubuntu0.13.04.1
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `PLAYER`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PLAYER` (
  `UUID` varchar(255) NOT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `JERSEY_NUMBER` int(11) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `LAST_SPOKEN_WORDS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UUID`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TEAM`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TEAM` (
  `TEAM_ID` int(11) NOT NULL,
  `LEAGUE` varchar(255) DEFAULT NULL,
  `TEAMNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`TEAM_ID`)
);
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-08-05 13:10:58
