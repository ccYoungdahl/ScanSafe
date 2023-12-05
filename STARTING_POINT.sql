-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: localhost    Database: scansafe
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `alternative_product`
--

DROP TABLE IF EXISTS `alternative_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alternative_product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `alt_product` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `replaces_product` varchar(255) DEFAULT NULL,
  `upc` varchar(255) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alternative_product`
--

LOCK TABLES `alternative_product` WRITE;
/*!40000 ALTER TABLE `alternative_product` DISABLE KEYS */;
INSERT INTO `alternative_product` VALUES (1,'0669809200808','','Sour patch kids','0070462098358',0);
/*!40000 ALTER TABLE `alternative_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredient` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient`
--

LOCK TABLES `ingredient` WRITE;
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
INSERT INTO `ingredient` VALUES (5,'Aspartame','https://www.who.int/news/item/14-07-2023-aspartame-hazard-and-risk-assessment-results-released'),(6,'Sodium benzoate','https://www.healthline.com/nutrition/sodium-benzoate'),(7,'Datem','https://www.isitbadforyou.com/questions/is-datem-bad-for-you'),(8,'High fructose corn syrup','https://health.clevelandclinic.org/avoid-the-hidden-dangers-of-high-fructose-corn-syrup-video'),(9,'Potassium benzoate','https://www.healthline.com/nutrition/potassium-benzoate'),(10,'Saccharin','https://www.healthline.com/nutrition/saccharin-good-or-bad'),(11,'Potassium sorbate','https://www.healthline.com/health/potassium-sorbate'),(12,'Sorbic acid','https://www.medicinenet.com/what_is_sorbic_acid/article.htm'),(13,'Sucralose','https://www.healthline.com/nutrition/sucralose-good-or-bad'),(14,'corn syrup','https://www.healthgrades.com/right-care/food-nutrition-and-diet/corn-syrup'),(15,'red 40','https://health.clevelandclinic.org/red-dye-40');
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal-ingredient`
--

DROP TABLE IF EXISTS `personal-ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal-ingredient` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal-ingredient`
--

LOCK TABLES `personal-ingredient` WRITE;
/*!40000 ALTER TABLE `personal-ingredient` DISABLE KEYS */;
INSERT INTO `personal-ingredient` VALUES (1,NULL,0),(2,NULL,0);
/*!40000 ALTER TABLE `personal-ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_ingredient`
--

DROP TABLE IF EXISTS `personal_ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal_ingredient` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_ingredient`
--

LOCK TABLES `personal_ingredient` WRITE;
/*!40000 ALTER TABLE `personal_ingredient` DISABLE KEYS */;
INSERT INTO `personal_ingredient` VALUES (1,NULL,0,NULL),(2,NULL,0,NULL),(3,NULL,0,NULL),(4,NULL,0,NULL),(5,'red 40',0,NULL),(7,'red 40',1,NULL),(8,NULL,0,NULL),(9,NULL,0,NULL),(10,NULL,0,NULL),(11,'datem',1,NULL),(14,'dye',1,NULL),(15,'sugar',1,NULL),(17,'wheat',1,NULL),(28,'red 40',0,'2'),(30,'dye',0,'username11'),(31,'sugar',0,'jackson');
/*!40000 ALTER TABLE `personal_ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proposed_ingredient`
--

DROP TABLE IF EXISTS `proposed_ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proposed_ingredient` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `approved` bit(1) NOT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rejected` bit(1) NOT NULL,
  `risk` varchar(255) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  `website` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proposed_ingredient`
--

LOCK TABLES `proposed_ingredient` WRITE;
/*!40000 ALTER TABLE `proposed_ingredient` DISABLE KEYS */;
INSERT INTO `proposed_ingredient` VALUES (1,_binary '\0','','red 40',_binary '\0','adhd',0,'example.com');
/*!40000 ALTER TABLE `proposed_ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN'),(3,'ROLE_INFLUENCER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (4,1),(5,1),(8,1),(9,1),(7,2),(6,3);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (4,'2@email.com','2','$2a$10$ixYKwf8FO6QK2VfsPbWbV.iZo01yWfUN7igYTDqT9V6fVCDM55yzG','2'),(5,'jackson@email.com','jackson','$2a$10$Z68iFrXGMmMOHCM20jzc2uTUrXemO8SC9QjGO6LrnPUgJNpR2eriK','jackson'),(6,'robby@email.com','robby','$2a$10$BM5qj4MK325S2WZxhYJTD.uTHmkoohdAwMBXhxhKRuSQtOs96Sk/y','robby'),(7,'caleb@email.com','caleb','$2a$10$7fScHu.lMQzJ6s1fLtmcYuynDu7XAmp.1PqLEPjpAJu6z/HFvono2','caleb'),(8,'user@email.com','username11','$2a$10$Ii7r7bhfVWFebLIWkigo0uPV88sUORr0.GszLeQkvRUxkqcy5jw2a','username11'),(9,'username2@email.com','username2','$2a$10$dOQzARJPiwdFPpcQ3sYCUu56C39deW04K9LQwqVQ6Ux8q/7wi6zK6','username2');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-05  8:13:56
