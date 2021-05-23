CREATE DATABASE  IF NOT EXISTS `cabinetmedical` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cabinetmedical`;
-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cabinetmedical
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asistent`
--

DROP TABLE IF EXISTS `asistent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asistent` (
  `cnp` varchar(13) NOT NULL,
  `nume` varchar(45) DEFAULT NULL,
  `prenume` varchar(45) DEFAULT NULL,
  `sectie` varchar(45) DEFAULT NULL,
  `zi_angajare` int DEFAULT NULL,
  `luna_angajare` int DEFAULT NULL,
  `an_angajare` int DEFAULT NULL,
  `salariu` double DEFAULT NULL,
  `nr_telefon` varchar(15) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `nr_saloane` int DEFAULT NULL,
  PRIMARY KEY (`cnp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistent`
--

LOCK TABLES `asistent` WRITE;
/*!40000 ALTER TABLE `asistent` DISABLE KEYS */;
INSERT INTO `asistent` VALUES ('1900807544352','Florescu','Fabian','Cardiologie',1,4,2020,5000,'0766455789','fab@gmail.com',15);
/*!40000 ALTER TABLE `asistent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientmajor`
--

DROP TABLE IF EXISTS `clientmajor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientmajor` (
  `cnp` varchar(13) NOT NULL,
  `nume` varchar(60) DEFAULT NULL,
  `prenume` varchar(100) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `gen` varchar(10) DEFAULT NULL,
  `adresa` varchar(250) DEFAULT NULL,
  `id_cardsanatate` double DEFAULT NULL,
  `nr_telefon` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`cnp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientmajor`
--

LOCK TABLES `clientmajor` WRITE;
/*!40000 ALTER TABLE `clientmajor` DISABLE KEYS */;
INSERT INTO `clientmajor` VALUES ('1490709563425','Chivu','Radu','radu.chivu@yahoo.com','masculin','Giurgiu Mun. Giurgiu Strada Portului nr.8',619209,'0766342110'),('1560909234176','Cristea','Marian','mariancristescu@yahoo.com','masculin','Bucuresti Strada Brasov nr.2',89067521,'0766478999'),('1730604167345','Stegaru','Alexandru','alexandrust@yahoo.com','masculin','Jud. Prahova Mun. Ploiesti Strada Zambilelor nr 6',40078625,'0765806365'),('1900205675884','Enescu','Cristian','cristian.e@yahoo.com','masculin','Jud Brasov Mun Brasov Strada Republicii nr.28',9765543,'0766390776'),('1900607133267','Anghel','Vladimir','vladimir@gmail.com','masculin','Bucuresti Strada Florilor nr 7',45637284,'0722334156'),('1980605145234','Georgescu','Darius','darius@gmail.com','masculin','Bucuresti Strada Florilor nr. 8',51423567,'0785523414'),('1980708354657','Popescu','Emanuel','emi@gmail.com','masculin','Bucuresti Sos Progresul nr 5',167584,'0722567448'),('2500103765263','Pavel','Adriana','adrianapav@yahoo.com','feminin','Constanta Mun. Constanta Strada Marii nr.5',67453628,'0754123984'),('2500708145678','Constantinescu','Ana','anaconst@gmail.com','feminin','Bucuresti Strada 1 Decembrie 1918 nr.45',50087632,'0724776590'),('2770103786543','Ghetu','Selena','ghetu.selena@gmail.com','feminin','Jud.Giurgiu Mun.Giurgiu Strada Bucuresti bl 40',95634256,'0765443887'),('2960707145754','Popescu','Raluca','ralucap@yahoo.com','feminin','Jud.Giurgiu Mun. Giurgiu Strada Mihai Viteazul',1906242,'0722566342'),('2980506143564','Anghel','Daria','daria.ang@gmail.com','feminin','Bucuresti Sos. Oltenitei bl.55 Ap. 10',459372048,'0744908561'),('2990310245637','Sabasanu','Maria','mariasab@gmail.com','feminin','Jud.Constanta Mun. Constanta Strada Lalelelor nr.10',65409382,'0724776549'),('6000102467389','Florescu','Ema','emaflorescu@yahoo.com','feminin','Bucuresti Strada Giurgiului nr.11',4527382,'0736221899'),('6000202588946','Ionescu','Venera','veneraionescu@gmail.com','feminin','Jud Constanta Mun. Constanta Strada Ancorei bloc 1 Ap. 14',7973084,'0722990145');
/*!40000 ALTER TABLE `clientmajor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientminor`
--

DROP TABLE IF EXISTS `clientminor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientminor` (
  `cnp` varchar(14) NOT NULL,
  `nume` varchar(50) DEFAULT NULL,
  `prenume` varchar(100) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `gen` varchar(15) DEFAULT NULL,
  `adresa` varchar(250) DEFAULT NULL,
  `nume_insotitor` varchar(45) DEFAULT NULL,
  `prenume_insotitor` varchar(100) DEFAULT NULL,
  `nr_telefon_insotitor` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`cnp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientminor`
--

LOCK TABLES `clientminor` WRITE;
/*!40000 ALTER TABLE `clientminor` DISABLE KEYS */;
INSERT INTO `clientminor` VALUES ('5060910254674','Enache','Vladimir','vladimir.enache@gmail.com','masculin','Giurgiu Mun Giurgiu Strada Unirii nr. 2','Enache','Daniel','0754133627'),('5070908156275','Petre','Alexandru','petre.al@gmail.com','masculin','Bucuresti Sos. Oltenitei bl. 50 Ap. 40','Petre','Mihaela','0755368778'),('5110304167499','Verzea','Sebastian','sebiverzea@gmail.com','masculin','Giurgiu Mun Giurgiu Strada Garii nr.3','Verzea','Ciprian','0765390872'),('5120503748391','Cretu','Alexandru','alex-cretu@gmail.com','masculin','Bucuresti Strada Actiunii nr.15','Cretu','Denisa','0766907544'),('6080909143675','Alexandrescu','Maria','maria_al@gmail.com','feminin','Giurgiu Strada Portului nr 5','Alexandrescu','Dan','0766890788'),('6100405887356','Georgescu','Eliza','elizageorgescu@yahoo.com','feminin','Timisoara Mun. Timisoara Strada Timisului nr. 21','Georgescu','Maria','0722165400');
/*!40000 ALTER TABLE `clientminor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medic`
--

DROP TABLE IF EXISTS `medic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medic` (
  `cnp` varchar(13) NOT NULL,
  `nume` varchar(45) DEFAULT NULL,
  `prenume` varchar(45) DEFAULT NULL,
  `sectie` varchar(45) DEFAULT NULL,
  `zi_angajare` int DEFAULT NULL,
  `luna_angajare` int DEFAULT NULL,
  `an_angajare` int DEFAULT NULL,
  `salariu` double DEFAULT NULL,
  `nr_telefon` varchar(15) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `cod_parafa` double DEFAULT NULL,
  `specializare` varchar(45) DEFAULT NULL,
  `rezident` tinyint DEFAULT NULL,
  `garda` tinyint DEFAULT NULL,
  PRIMARY KEY (`cnp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medic`
--

LOCK TABLES `medic` WRITE;
/*!40000 ALTER TABLE `medic` DISABLE KEYS */;
INSERT INTO `medic` VALUES ('1600606245367','Dimitrie','Andrei','Dermatologie',20,9,2019,20000,'0744678543','dim.andrei@gmail.com',165276,'Dermatologie',0,1),('1650331453762','Berg','Eric','Nutritie',6,8,2010,20000,'0756467775','ericberg@gmail.com',190765,'Chiropractologie',0,1),('1700607352466','Florescu','Mihai','Diabetologie',9,7,2011,19000,'0789334123','mihaif@yahoo.com',190876,'Diabetologie',0,0),('1940510245678','Matei','Alexandru','Urologie',3,4,2019,10000,'0766456754','matei@gmail.com',17865,'Urologie',0,1),('2900805145345','Oprea','Carmen','Chirurgie',6,5,2015,18000,'0766908789','carmen@gmail.com',195342,'Urologie',0,1),('2910403196745','Popescu','Raluca','Cardiologie',4,6,2018,15000,'0755342311','raluca@yahoo.com',12341,'Cardiologie',0,0),('2930909567665','Savu','Elisabeta','Ortopedie',7,2,2020,6000,'0722564776','savuelisabeta@gmail.com',189654,'Ortopedie',1,0);
/*!40000 ALTER TABLE `medic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programare_clientmajor`
--

DROP TABLE IF EXISTS `programare_clientmajor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `programare_clientmajor` (
  `id_programare` double NOT NULL,
  `cod_bilet` double DEFAULT NULL,
  `cnp` varchar(13) DEFAULT NULL,
  `zi_programare` int DEFAULT NULL,
  `luna_programare` int DEFAULT NULL,
  `an_programare` int DEFAULT NULL,
  `zi_planificare` int DEFAULT NULL,
  `luna_planificare` int DEFAULT NULL,
  `an_planificare` int DEFAULT NULL,
  `sectie` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_programare`),
  KEY `cnp_idx` (`cnp`),
  CONSTRAINT `cnp` FOREIGN KEY (`cnp`) REFERENCES `clientmajor` (`cnp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programare_clientmajor`
--

LOCK TABLES `programare_clientmajor` WRITE;
/*!40000 ALTER TABLE `programare_clientmajor` DISABLE KEYS */;
INSERT INTO `programare_clientmajor` VALUES (145778,458907,'1490709563425',3,5,2020,8,5,2020,'Dermatologie'),(578943,226789,'1560909234176',6,6,2020,6,7,2020,'Gastroenterologie'),(589005,478231,'1730604167345',1,1,2021,3,1,2021,'Ortopedie');
/*!40000 ALTER TABLE `programare_clientmajor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programare_clientminor`
--

DROP TABLE IF EXISTS `programare_clientminor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `programare_clientminor` (
  `id_programare` double NOT NULL,
  `cod_bilet` double DEFAULT NULL,
  `cnp` varchar(13) DEFAULT NULL,
  `zi_programare` int DEFAULT NULL,
  `luna_programare` int DEFAULT NULL,
  `an_programare` int DEFAULT NULL,
  `zi_planificare` int DEFAULT NULL,
  `luna_planificare` int DEFAULT NULL,
  `an_planificare` int DEFAULT NULL,
  `sectie` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_programare`),
  KEY `cnp_idx` (`cnp`),
  CONSTRAINT `cnpmin` FOREIGN KEY (`cnp`) REFERENCES `clientminor` (`cnp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programare_clientminor`
--

LOCK TABLES `programare_clientminor` WRITE;
/*!40000 ALTER TABLE `programare_clientminor` DISABLE KEYS */;
/*!40000 ALTER TABLE `programare_clientminor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-19 15:23:11
