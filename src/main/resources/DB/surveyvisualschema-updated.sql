-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: localhost    Database: surveyvisual
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agent`
--

DROP TABLE IF EXISTS `agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent` (
  `id` int(11) NOT NULL,
  `agentName` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent`
--

LOCK TABLES `agent` WRITE;
/*!40000 ALTER TABLE `agent` DISABLE KEYS */;
INSERT INTO `agent` VALUES (1,'Chirag Vivaan8'),(2,'Himmat Devansh19'),(3,'Vaibhav Hiran46'),(4,'Dhruv Divit11'),(5,'Faiyaz Aayush15'),(6,'Madhup Faiyaz27'),(7,'Eshan Eshan14'),(8,'Akarsh Vihaan4'),(9,'Harikiran Devansh18'),(10,'Sahil Sahil38'),(11,'Lakshit Shlok25'),(12,'Samar Harikiran39'),(13,'Arnav Aniruddh5'),(14,'Rohan Vaibhav37'),(15,'Aayush Bhavin2'),(16,'Jayesh Arnav23'),(17,'Ranbir Sahil36'),(18,'Jayesh Chirag23'),(19,'Madhup Harikiran27'),(20,'Madhup Divyansh27'),(21,'Tushar Lakshay44'),(22,'Tushar Ojas44'),(23,'Rohan Vivaan37'),(24,'Madhup Darshit27'),(25,'Neerav Lakshit29'),(26,'Mitul Faiyaz28'),(27,'Darshit Himmat9'),(28,'Sahil Indranil38'),(29,'Akarsh Divyansh4'),(30,'Mitul Eshan28'),(31,'Shlok Samar41'),(32,'Shreyas Shaan43'),(33,'Eshan Divit14'),(34,'Madhup Gurkiran27'),(35,'Arnav Shaan5'),(36,'Mitul Eshan28'),(37,'Aniruddh Ojas6'),(38,'Faiyaz Hansh15'),(39,'Ranbir Harikiran36'),(40,'Shaan Lakshit40'),(41,'Aayush Uthkarsh2'),(42,'Tushar Samar44'),(43,'Shlok Arnav41'),(44,'Divyansh Aarav13'),(45,'Divyansh Reyansh13'),(46,'Mitul Gurkiran28'),(47,'Vihaan Gurkiran47'),(48,'Arnav Aniruddh5'),(49,'Rohan Indranil37'),(50,'Ojas Indranil31'),(51,'Chirag Arnav8'),(52,'Shaan Hiran40'),(53,'Vivaan Samar48'),(54,'Darshit Eshan9'),(55,'Darshit Darshit9'),(56,'Gurkiran Devansh16'),(57,'Reyansh Akarsh35'),(58,'Ranbir Faiyaz36'),(59,'Hansh Reyansh17'),(60,'Gurkiran Jayesh16'),(61,'Divit Kiaan12'),(62,'Shlok Rohan41'),(63,'Vivaan Ojas48'),(64,'Pranay Sahil32'),(65,'Jayesh Pranay23'),(66,'Mitul Lakshit28'),(67,'Ranbir Uthkarsh36'),(68,'Yakshit Devansh49'),(69,'Vivaan Uthkarsh48'),(70,'Devansh Neerav10'),(71,'Shray Indrajit42'),(72,'Shlok Divit41'),(73,'Rohan Shaan37'),(74,'Hansh Vihaan17'),(75,'Uthkarsh Faiyaz45'),(76,'Madhup Aarav27'),(77,'Reyansh Aayush35'),(78,'Jayesh Divit23'),(79,'Advik Bhavin3'),(80,'Shlok Harikiran41'),(81,'Dhruv Eshan11'),(82,'Kiaan Indranil24'),(83,'Aarav Akarsh0'),(84,'Nishith Aarush30'),(85,'Priyansh Indranil33'),(86,'Priyansh Sahil33'),(87,'Lakshit Vaibhav25'),(88,'Bhavin Rachit7'),(89,'Neerav Vaibhav29'),(90,'Tushar Darshit44'),(91,'Rachit Shlok34'),(92,'Hansh Lakshit17'),(93,'Darshit Shaan9'),(94,'Aniruddh Shray6'),(95,'Rohan Faiyaz37'),(96,'Madhup Vivaan27'),(97,'Priyansh Dhruv33'),(98,'Indranil Devansh22'),(99,'Nishith Ranbir30'),(100,'Himmat Jayesh19');
/*!40000 ALTER TABLE `agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer` (
  `ID` int(11) NOT NULL,
  `participantId` int(11) DEFAULT NULL,
  `questionId` int(11) DEFAULT NULL,
  `optionId` int(11) DEFAULT NULL,
  `eventId` int(11) DEFAULT NULL,
  `programId` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,18,18,2,9,1),(2,18,18,1,9,1),(3,14,14,1,5,1),(4,4,4,1,4,1),(5,18,18,1,9,1),(6,19,19,1,1,2),(7,18,18,2,9,1),(8,20,20,2,2,1),(9,10,10,2,1,2),(10,20,20,1,2,1),(11,2,2,1,2,2),(12,19,19,1,1,2),(13,1,1,1,1,1),(14,18,18,2,9,1),(15,4,4,1,4,1),(16,8,8,4,8,1),(17,15,15,3,6,1),(18,16,16,1,7,2),(19,10,10,4,1,2),(20,14,14,2,5,1),(21,12,12,2,3,2),(22,4,4,1,4,1),(23,15,15,1,6,1),(24,13,13,2,4,1),(25,18,18,2,9,1),(26,1,1,1,1,1),(27,13,13,3,4,1),(28,13,13,1,4,1),(29,5,5,2,5,2),(30,13,13,1,4,1),(31,16,16,4,7,2),(32,13,13,2,4,1),(33,7,7,2,7,1),(34,7,7,2,7,1),(35,14,14,1,5,1),(36,12,12,1,3,2),(37,10,10,2,1,2),(38,15,15,1,6,1),(39,15,15,3,6,1),(40,20,20,2,2,1),(41,13,13,2,4,1),(42,19,19,2,1,2),(43,1,1,1,1,1),(44,2,2,1,2,2),(45,10,10,2,1,2),(46,20,20,2,2,1),(47,19,19,1,1,2),(48,4,4,1,4,1),(49,11,11,2,2,1),(50,5,5,1,5,2),(51,16,16,4,7,2),(52,4,4,1,4,1),(53,10,10,2,1,2),(54,1,1,1,1,1),(55,10,10,1,1,2),(56,6,6,2,6,2),(57,16,16,1,7,2),(58,8,8,1,8,1),(59,1,1,1,1,1),(60,19,19,4,1,2),(61,17,17,2,8,1),(62,3,3,3,3,1),(63,17,17,2,8,1),(64,10,10,1,1,2),(65,7,7,2,7,1),(66,17,17,1,8,1),(67,3,3,3,3,1),(68,8,8,4,8,1),(69,5,5,1,5,2),(70,20,20,2,2,1),(71,18,18,3,9,1),(72,9,9,1,9,1),(73,15,15,3,6,1),(74,19,19,2,1,2),(75,9,9,3,9,1),(76,13,13,3,4,1),(77,8,8,4,8,1),(78,20,20,1,2,1),(79,10,10,1,1,2),(80,20,20,2,2,1),(81,20,20,1,2,1),(82,9,9,3,9,1),(83,13,13,3,4,1),(84,10,10,1,1,2),(85,6,6,1,6,2),(86,13,13,1,4,1),(87,15,15,1,6,1),(88,16,16,3,7,2),(89,10,10,3,1,2),(90,10,10,2,1,2),(91,11,11,3,2,1),(92,1,1,1,1,1),(93,6,6,1,6,2),(94,17,17,2,8,1),(95,3,3,3,3,1),(96,18,18,3,9,1),(97,13,13,1,4,1),(98,19,19,1,1,2),(99,3,3,3,3,1),(100,20,20,2,2,1);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `participantId` int(11) DEFAULT NULL,
  `eventId` int(11) DEFAULT NULL,
  `attendance` varchar(3) DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` varchar(25) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `address` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES ('1','ascend dell0','eranakulam'),('10','dell hyber2','tvm'),('11','asus hyber4','bangalur'),('12','ascend hp0','eranakulam'),('13','sony ascend5','tvm'),('14','ascend hp0','eranakulam'),('15','sony hp5','tvm'),('2','dell hyber2','tvm'),('3','asus asus4','bangalur'),('4','hyber hp1','bangalur'),('5','ascend asus0','eranakulam'),('6','ascend hyber0','eranakulam'),('7','sony sony5','tvm'),('8','ascend ascend0','eranakulam'),('9','hp sony3','chennai');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `id` int(11) NOT NULL,
  `eventName` varchar(100) DEFAULT NULL,
  `place` varchar(25) DEFAULT NULL,
  `date` varchar(25) DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL,
  `agentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'free your lungs','alappuzha','11/2/2009',3,3),(2,'stop smoking start repairing','kottayam','4/5/2005',5,15),(3,'tobacco and diabetics','kasargodu','27/9/2010',1,11);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `options`
--

DROP TABLE IF EXISTS `options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `options` (
  `id` int(11) NOT NULL,
  `questionId` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `options`
--

LOCK TABLES `options` WRITE;
/*!40000 ALTER TABLE `options` DISABLE KEYS */;
/*!40000 ALTER TABLE `options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participant`
--

DROP TABLE IF EXISTS `participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participant` (
  `id` int(11) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participant`
--

LOCK TABLES `participant` WRITE;
/*!40000 ALTER TABLE `participant` DISABLE KEYS */;
INSERT INTO `participant` VALUES (1,'Priya Aiden10',25,'F','Alappuzha'),(2,'Ethana Samual82',65,'M','Idukki'),(3,'David Aidan91',32,'M','Kottayam'),(4,'Aiden Mason126',25,'M','Idukki'),(5,'Gabriel Anu41',42,'F','Malappuram'),(6,'Gavin Jany60',27,'F','Idukki'),(7,'Tyler Christina29',26,'M','Kollam'),(8,'David Jasy27',45,'M','Kottayam'),(9,'Monu Kevin68',54,'M','Kannur'),(10,'Angel Praseeetha109',43,'F','Ernakulam'),(11,'Gabriel Elijah41',57,'M','Malappuram'),(12,'Jordan William123',20,'M','Wayanad'),(13,'Ryan Samuel26',57,'M','Alappuzha'),(14,'James Priyanka30',18,'F','Alappuzha'),(15,'Isaiah Brandon122',23,'M','Malappuram'),(16,'Elijah Emily44',57,'F','Malappuram'),(17,'Aidan Evan56',20,'M','Alappuzha'),(18,'John Nathan95',23,'M','Malappuram'),(19,'Logan Praseeetha39',21,'M','Kottayam'),(20,'Kevin Isaac46',20,'M','Alappuzha'),(21,'Pachu Daniel74',21,'M','Alappuzha'),(22,'Priya Ryan3',43,'F','Alappuzha'),(23,'Isaac Nicholas127',20,'M','Alappuzha'),(24,'Thomas Priya53',23,'F','Kottayam'),(25,'Joshua Noah16',20,'F','Pathanamthitta'),(26,'Gabriel Christopher105',42,'M','Wayanad'),(27,'Connor Dylan125',23,'M','Malappuram'),(28,'Aidan Tyler120',32,'M','Alappuzha'),(29,'Connor Monu125',23,'M','Malappuram'),(30,'Jackson Thomas57',23,'M','Ernakulam'),(31,'Priya Alwin3',26,'F','Alappuzha'),(32,'Isaac Jasy127',20,'F','Alappuzha'),(33,'Jordan Emily123',20,'F','Wayanad'),(34,'Samual Jackson7',30,'M','Pathanmthitta'),(35,'Robert Isaiah116',57,'M','Ernakulam'),(36,'Tyler Ethan93',12,'M','Kollam'),(37,'Austin Mason50',20,'M','Ernakulam'),(38,'Elijah Alexander44',57,'M','Malappuram'),(39,'Isaiah Christina58',23,'F','Malappuram'),(40,'Matthew Luke17',57,'M','Kottayam'),(41,'Logan Jack39',20,'M','Kottayam'),(42,'Dylan Samual101',43,'M','Wayanad'),(43,'Michael Manu15',23,'M','Alappuzha'),(44,'Alexander Jasy89',78,'F','Idukki'),(45,'David Gavin27',27,'M','Kottayam'),(46,'Raju Daniel65',33,'M','Thammanam'),(47,'Logan Pachu39',21,'M','Kottayam'),(48,'Ethan Evan18',20,'M','Idukki'),(49,'Zachary DanielD106',57,'M','Alappuzha'),(50,'Priya Mason10',20,'F','Alappuzha'),(51,'Dylan Aidan37',32,'M','Alappuzha'),(52,'Zachary William42',25,'M','Alappuzha'),(53,'Janki Ryan6',43,'F','Kottayam'),(54,'Priya William3',25,'F','Alappuzha'),(55,'EmilyJason Samuel78',57,'F','Kottayam'),(56,'Caleb Samual48',35,'M','Malappuram'),(57,'Benjamin Pachu38',21,'M','Kottayam'),(58,'Samu Luke71',72,'M','Pathanmthitta'),(59,'Roshan Aiden72',33,'M','Thoppumpadi'),(60,'Anthony James21',18,'M','Kannur'),(61,'Kevin Jordan46',20,'M','Alappuzha'),(62,'John EmilyJason31',36,'M','Malappuram'),(63,'Nicholas Anthony92',22,'M','Pathanamthitta'),(64,'Mason Angel55',20,'M','Idukki'),(65,'Zachary Monu106',57,'M','Alappuzha'),(66,'Connor Aiden61',25,'M','Malappuram'),(67,'Samsan Angel64',43,'M','Palarivattam'),(68,'Caleb Aiden112',35,'M','Malappuram'),(69,'Samu Isaac71',72,'M','Pathanmthitta'),(70,'Thomas Jordan53',20,'M','Kottayam'),(71,'Luke Logan118',57,'M','Ernakulam'),(72,'Samuel Samual98',57,'M','Idukki'),(73,'Raj Alexander1',78,'M','Thammanam'),(74,'William Ryan24',43,'M','Alappuzha'),(75,'Tyler Kevin29',23,'M','Kollam'),(76,'Dylan Kevin101',43,'M','Wayanad'),(77,'Ryan Ryan90',43,'M','Alappuzha'),(78,'Kevin Awin110',23,'M','Alappuzha'),(79,'Jonathan Anthony32',19,'M','Kottayam'),(80,'Benjamin Luke102',57,'M','Kottayam'),(81,'Jose David43',34,'M','Ernakulam'),(82,'Alwin Kevin66',23,'M','Aluva'),(83,'Evan Angel51',20,'M','Malappuram'),(84,'Miche Austin79',23,'M','Alappuzha'),(85,'Jany Sam13',26,'M','Kottayam'),(86,'Ethan Roy18',65,'M','Idukki'),(87,'Jack Joshua111',20,'F','Idukki'),(88,'Jack Zachary47',20,'M','Idukki'),(89,'Jose Anthony107',60,'M','Ernakulam'),(90,'Christina Elijah99',26,'M','Ernakulam'),(91,'Prana Joshua69',25,'F','Aluva'),(92,'Evan Christina115',20,'F','Malappuram'),(93,'Alexander Justin25',23,'M','Idukki'),(94,'DanielD Noah84',20,'M','Kasaragod'),(95,'Noah Evan100',20,'M','Malappuram'),(96,'Achu Jack76',20,'M','Kollam'),(97,'Jonathan Elijah32',57,'M','Kottayam'),(98,'Roy Gavin8',27,'M','Thoppumpadi'),(99,'Benjamin Roshan38',33,'M','Kottayam'),(100,'Brandon Robert40',57,'M','Idukki');
/*!40000 ALTER TABLE `participant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `program` (
  `id` varchar(25) NOT NULL,
  `programName` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program`
--

LOCK TABLES `program` WRITE;
/*!40000 ALTER TABLE `program` DISABLE KEYS */;
INSERT INTO `program` VALUES ('1','tobacco-quit'),('2','food-habit');
/*!40000 ALTER TABLE `program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `progId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'wednesdayCampaign',2),(2,'theaterAdd',1),(3,'tuesdayCampaign',2),(4,'oneDayCamp',1),(5,'wednesdayCampaign',2),(6,'thursdayCampaign',1),(7,'saturdayCampaign',2),(8,'tuesdayCampaign',2),(9,'sundayCampaign',1),(10,'fridayCampaign',2),(11,'oneDayCamp',1),(12,'theaterAdd',1),(13,'mondayCampaign',1),(14,'theaterAdd',1),(15,'oneDayCamp',1),(16,'tuesdayCampaign',2),(17,'sundayCampaign',1),(18,'saturdayCampaign',2),(19,'saturdayCampaign',2),(20,'saturdayCampaign',2);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` int(11) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `option1` varchar(50) DEFAULT NULL,
  `option2` varchar(50) DEFAULT NULL,
  `option3` varchar(50) DEFAULT NULL,
  `option4` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionLink`
--

DROP TABLE IF EXISTS `questionLink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionLink` (
  `id` int(11) NOT NULL,
  `questionId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionLink`
--

LOCK TABLES `questionLink` WRITE;
/*!40000 ALTER TABLE `questionLink` DISABLE KEYS */;
/*!40000 ALTER TABLE `questionLink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `firstName` varchar(25) DEFAULT NULL,
  `lastName` varchar(25) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Noah','Taylor',43,'Noah','Taylor12'),(2,'Christian','Anna',78,'Christian','Anna21'),(3,'Ethan','Isabella',34,'EthanIsabella','Isabella66'),(4,'Emily','Emma',21,'JacobEmily','Emma267'),(5,'Gavin','Trinity',34,'Gavin','Trinity5'),(6,'Nathan','Lauren',57,'Nathan','Lauren64'),(7,'Emily','Emma',21,'JacobEmily','Emma267'),(8,'John','Chloe',65,'John','Chloe34'),(9,'Luke','Jennifer',44,'Luke','Jennifer8'),(10,'Evan','Lily',32,'Evan','Lily7'),(11,'Christian','Anna',78,'Christian','Anna21'),(12,'Samuel','Ella',34,'Samuel','Ella54'),(13,'William','Elizabeth',55,'William','Elizabeth34'),(14,'Jose','Julia',56,'Jose','Julia22'),(15,'Kevin','Kaitlyn',66,'Kevin','Kaitlyn12'),(16,'Nicholas','Alyssa',44,'Nicholas','Alyssa21'),(17,'Logan','Jessica',13,'Logan','Jessica32'),(18,'David','Sarah',32,'David','Sarah23'),(19,'Mason','Angelina',23,'Mason','Angelina3'),(20,'Christian','Anna',78,'Christian','Anna21'),(21,'Isaiah','Brooke',87,'Isaiah','Brooke'),(22,'Brandon','Victoria',21,'Brandon','Victoria65'),(23,'Caleb','Katherine',76,'Caleb','Katherine1'),(24,'James','Natalie',43,'James','Natalie11'),(25,'Anthony','Ava',76,'AnthonyAva','Ava4344'),(26,'Aiden','Mackenzie',22,'Aiden','Mackenzie1'),(27,'Jose','Julia',56,'Jose','Julia22'),(28,'Ethan','Isabella',34,'EthanIsabella','Isabella66'),(29,'Matthew','Olivia',65,'MatthewOlivia','Olivia676'),(30,'Christopher','Ashley',77,'Christopher','Ashley12'),(31,'William','Elizabeth',55,'William','Elizabeth34'),(32,'Logan','Jessica',13,'Logan','Jessica32'),(33,'Daniel','Samantha',23,'DanielSamantha','Samantha45'),(34,'Gavints','Brooke',34,'Gavints','Trinity5m'),(35,'Evan','Lily',32,'Evan','Lily7'),(36,'Ethan','Isabella',34,'EthanIsabella','Isabella66'),(37,'Tyler','Mia',45,'Tyler','Mia45'),(38,'Ryan','Grace',54,'Ryan','Grace42'),(39,'Christopher','Ashley',77,'Christopher','Ashley12'),(40,'Austin','Rachel',45,'Austin','Rachel4'),(41,'Joshua','Abigail',54,'JoshuaAbigail','Abigail75'),(42,'Gabriel','Victoria',27,'Gabriel','Victoria33'),(43,'Anthony','Ava',76,'AnthonyAva','Ava4344'),(44,'Jordan','Maria',45,'Jordan','Maria3'),(45,'David','Sarah',32,'David','Sarah23'),(46,'Christopher','Ashley',77,'Christopher','Ashley12'),(47,'Zachary','Sydney',28,'Zachary','Sydney21'),(48,'Andrew','Hannah',24,'AndrewHannah','Hannah22'),(49,'Jackson','Allison',76,'Jackson','Allison4'),(50,'Jonathan','Brianna',76,'Jonathan','Brianna64');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-26 16:38:07
