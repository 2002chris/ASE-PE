-- MySQL dump 10.17  Distrib 10.3.16-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: todoapp
-- ------------------------------------------------------
-- Server version	10.3.16-MariaDB-1:10.3.16+maria~bionic

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `calendar`
--

DROP TABLE IF EXISTS `calendar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calendar` (
                            `calendar_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                            `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `user_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                            PRIMARY KEY (`calendar_id`),
                            KEY `FK7lyt2gd8862h9hhn5ne38l51i` (`user_id`),
                            CONSTRAINT `FK7lyt2gd8862h9hhn5ne38l51i` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendar`
--

LOCK TABLES `calendar` WRITE;
/*!40000 ALTER TABLE `calendar` DISABLE KEYS */;
INSERT INTO `calendar` VALUES ('023f7171-bf4d-4c6c-8d06-acafa1e85ef4','calendar5','cc24af75-89a0-47fd-ba60-f36a6bfdf909'),('26a1270a-b98a-4608-8d6f-a717b990dae5','calendar1','5a2ded9b-6f48-4501-87f8-9ead35c7e35c'),('53e2c2fd-5af6-405a-83c6-fd40cf8bc53c','calendar2','b7fc481d-93e1-4061-b42b-4b65339b8df2'),('57624cce-ea3d-489e-9ae1-136053d1507b','calendar0','f588ce33-39ce-43ad-ad46-428f3638735e'),('7629a312-780d-427a-9139-9a7053874fa2','calendar6','1d2821c3-8122-4687-af6e-88cbaad83c86'),('87d607a1-291e-4ee7-a012-036e2e269d4e','calendar3','90e85bdb-467b-4c5b-a5cc-d04ba0970fc0'),('916a6104-0c75-4492-b354-5440444ffa76','calendar4','1a119b63-cd1b-4bb4-bd9f-4d0aa0fb73a7'),('a70efbe1-d407-44e8-8469-3fabcc608ee8','calendar7','ce814f76-b5b7-4d43-946e-3aa0745b2cc7'),('d2b4c4a2-7077-41e2-b5c5-fef84e9c386a','calendar9','c6115f15-4830-472a-8e52-ee87059020cf'),('ffd31595-da7d-42d9-ae35-71ab73cf21a5','calendar8','11467ab9-911d-439a-b32d-c209dbf3033a');
/*!40000 ALTER TABLE `calendar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flyway_schema_history` (
                                         `installed_rank` int(11) NOT NULL,
                                         `version` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                         `description` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `type` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `script` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `checksum` int(11) DEFAULT NULL,
                                         `installed_by` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `installed_on` timestamp NOT NULL DEFAULT current_timestamp(),
                                         `execution_time` int(11) NOT NULL,
                                         `success` tinyint(1) NOT NULL,
                                         PRIMARY KEY (`installed_rank`),
                                         KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reminder`
--

DROP TABLE IF EXISTS `reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reminder` (
                            `reminder_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                            `date` date DEFAULT NULL,
                            `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `calendar_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                            PRIMARY KEY (`reminder_id`),
                            KEY `FKbjysrl8yquggqbggewqklon2v` (`calendar_id`),
                            CONSTRAINT `FKbjysrl8yquggqbggewqklon2v` FOREIGN KEY (`calendar_id`) REFERENCES `calendar` (`calendar_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminder`
--

LOCK TABLES `reminder` WRITE;
/*!40000 ALTER TABLE `reminder` DISABLE KEYS */;
INSERT INTO `reminder` VALUES ('29895344-64d6-4096-ae89-3c43d5ce6e36','2023-05-29','test5','reminder5','023f7171-bf4d-4c6c-8d06-acafa1e85ef4'),('7f9cdfae-5392-434a-9fd5-e7ef52f92c24','2023-05-29','test3','reminder3','87d607a1-291e-4ee7-a012-036e2e269d4e'),('818746ca-b082-4703-ad25-509993edf1f5','2023-05-29','test4','reminder4','916a6104-0c75-4492-b354-5440444ffa76'),('99bcaca9-81e6-4222-91b4-976662689432','2023-05-29','test6','reminder6','7629a312-780d-427a-9139-9a7053874fa2'),('9c19c53a-cbb4-4743-a14d-99a118b8f5e2','2023-05-29','test1','reminder1','26a1270a-b98a-4608-8d6f-a717b990dae5'),('9e3657b0-62dc-422c-94a3-2ebc1b7f3bda','2023-05-29','test8','reminder8','ffd31595-da7d-42d9-ae35-71ab73cf21a5'),('a5344053-ea6e-4263-8672-413548543ef1','2023-05-29','test2','reminder2','53e2c2fd-5af6-405a-83c6-fd40cf8bc53c'),('b4425470-0a37-4ab9-a065-996900a9b5a1','2023-05-29','test9','reminder9','d2b4c4a2-7077-41e2-b5c5-fef84e9c386a'),('ccca5463-07fb-4380-9d63-c958d9b38199','2023-05-29','test0','reminder0','57624cce-ea3d-489e-9ae1-136053d1507b'),('e9ce5aa9-3368-4325-a1de-5f9ec7d502e5','2023-05-29','test7','reminder7','a70efbe1-d407-44e8-8469-3fabcc608ee8');
/*!40000 ALTER TABLE `reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
                       `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                       PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES ('arbeit'),('privat');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `todo`
--

DROP TABLE IF EXISTS `todo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `todo` (
                        `todo_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                        `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `until_date` date DEFAULT NULL,
                        `calendar_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `user_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        PRIMARY KEY (`todo_id`),
                        KEY `FKs6grjt2iu9ql2on17r2g7w8q3` (`calendar_id`),
                        KEY `FKdcopxq1yu1u8ijb7rjexhsr6v` (`user_id`),
                        CONSTRAINT `FKdcopxq1yu1u8ijb7rjexhsr6v` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE,
                        CONSTRAINT `FKs6grjt2iu9ql2on17r2g7w8q3` FOREIGN KEY (`calendar_id`) REFERENCES `calendar` (`calendar_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `todo`
--

LOCK TABLES `todo` WRITE;
/*!40000 ALTER TABLE `todo` DISABLE KEYS */;
INSERT INTO `todo` VALUES ('045c1ccf-b49c-4c7c-b472-c5cfe6ac3ad2','calendarTodo1','2023-05-29','26a1270a-b98a-4608-8d6f-a717b990dae5',NULL),('12c4ac74-9c1d-4f42-b7a4-cbe7668f1899','userTodo8','2023-05-29',NULL,'11467ab9-911d-439a-b32d-c209dbf3033a'),('1eeeeb58-beed-47e9-a20e-972986446bef','calendarTodo3','2023-05-29','87d607a1-291e-4ee7-a012-036e2e269d4e',NULL),('2c9e414b-0724-4712-8915-c37212c69b00','calendarTodo2','2023-05-29','53e2c2fd-5af6-405a-83c6-fd40cf8bc53c',NULL),('3d606b7b-43c2-421f-ab01-d76300134c45','userTodo3','2023-05-29',NULL,'90e85bdb-467b-4c5b-a5cc-d04ba0970fc0'),('5f0a3f12-75f4-4fc4-8919-d5a660afc4fb','userTodo0','2023-05-29',NULL,'f588ce33-39ce-43ad-ad46-428f3638735e'),('5f4a3734-64d5-4c1f-b176-7ec9bf676694','calendarTodo6','2023-05-29','7629a312-780d-427a-9139-9a7053874fa2',NULL),('6422292e-5fda-4caa-9cfc-32fcbaef7130','userTodo1','2023-05-29',NULL,'5a2ded9b-6f48-4501-87f8-9ead35c7e35c'),('646624cb-64b0-42cb-bdb1-0acb3f38528f','userTodo7','2023-05-29',NULL,'ce814f76-b5b7-4d43-946e-3aa0745b2cc7'),('66e27040-b54f-4cf8-9056-d1e86dce929e','calendarTodo4','2023-05-29','916a6104-0c75-4492-b354-5440444ffa76',NULL),('686845df-e416-4148-95c8-839b39e39649','calendarTodo7','2023-05-29','a70efbe1-d407-44e8-8469-3fabcc608ee8',NULL),('6e6e1814-791c-4fcb-8432-4d96869ee05c','userTodo2','2023-05-29',NULL,'b7fc481d-93e1-4061-b42b-4b65339b8df2'),('a4ac01bc-a34a-4bbb-930a-b7b9e22b2be5','calendarTodo5','2023-05-29','023f7171-bf4d-4c6c-8d06-acafa1e85ef4',NULL),('b2e82a29-e66c-4308-969e-03bd7fdf5e50','userTodo5','2023-05-29',NULL,'cc24af75-89a0-47fd-ba60-f36a6bfdf909'),('b416f577-2ad3-4eab-979a-f5969ff134a2','userTodo6','2023-05-29',NULL,'1d2821c3-8122-4687-af6e-88cbaad83c86'),('b91b8382-6850-4629-ab8f-6d875f092eb7','userTodo9','2023-05-29',NULL,'c6115f15-4830-472a-8e52-ee87059020cf'),('bc8d4e27-a866-46f6-8d23-b4bca18b7ba3','calendarTodo9','2023-05-29','d2b4c4a2-7077-41e2-b5c5-fef84e9c386a',NULL),('d9d632ef-1f6f-4c27-9c12-642848990fb9','calendarTodo0','2023-05-29','57624cce-ea3d-489e-9ae1-136053d1507b',NULL),('f1c9a422-89a8-4c01-a168-fc1209b44a2a','calendarTodo8','2023-05-29','ffd31595-da7d-42d9-ae35-71ab73cf21a5',NULL),('fd8c8366-cdc7-44d8-b741-b0eb97bf27a2','userTodo4','2023-05-29',NULL,'1a119b63-cd1b-4bb4-bd9f-4d0aa0fb73a7');
/*!40000 ALTER TABLE `todo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `todo_tags`
--

DROP TABLE IF EXISTS `todo_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `todo_tags` (
                             `todo_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                             `tag_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                             KEY `FKgktdbehb92c6cogo0r4gkatlr` (`tag_name`),
                             KEY `FKpgxbhmtbteff76lkxftwhmgny` (`todo_id`),
                             CONSTRAINT `FKgktdbehb92c6cogo0r4gkatlr` FOREIGN KEY (`tag_name`) REFERENCES `tag` (`name`),
                             CONSTRAINT `FKpgxbhmtbteff76lkxftwhmgny` FOREIGN KEY (`todo_id`) REFERENCES `todo` (`todo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `todo_tags`
--

LOCK TABLES `todo_tags` WRITE;
/*!40000 ALTER TABLE `todo_tags` DISABLE KEYS */;
INSERT INTO `todo_tags` VALUES ('d9d632ef-1f6f-4c27-9c12-642848990fb9','arbeit'),('5f0a3f12-75f4-4fc4-8919-d5a660afc4fb','privat'),('5f0a3f12-75f4-4fc4-8919-d5a660afc4fb','arbeit'),('045c1ccf-b49c-4c7c-b472-c5cfe6ac3ad2','arbeit'),('6422292e-5fda-4caa-9cfc-32fcbaef7130','privat'),('6422292e-5fda-4caa-9cfc-32fcbaef7130','arbeit'),('2c9e414b-0724-4712-8915-c37212c69b00','arbeit'),('6e6e1814-791c-4fcb-8432-4d96869ee05c','privat'),('6e6e1814-791c-4fcb-8432-4d96869ee05c','arbeit'),('1eeeeb58-beed-47e9-a20e-972986446bef','arbeit'),('3d606b7b-43c2-421f-ab01-d76300134c45','privat'),('3d606b7b-43c2-421f-ab01-d76300134c45','arbeit'),('66e27040-b54f-4cf8-9056-d1e86dce929e','arbeit'),('fd8c8366-cdc7-44d8-b741-b0eb97bf27a2','privat'),('fd8c8366-cdc7-44d8-b741-b0eb97bf27a2','arbeit'),('a4ac01bc-a34a-4bbb-930a-b7b9e22b2be5','arbeit'),('b2e82a29-e66c-4308-969e-03bd7fdf5e50','privat'),('b2e82a29-e66c-4308-969e-03bd7fdf5e50','arbeit'),('5f4a3734-64d5-4c1f-b176-7ec9bf676694','arbeit'),('b416f577-2ad3-4eab-979a-f5969ff134a2','privat'),('b416f577-2ad3-4eab-979a-f5969ff134a2','arbeit'),('686845df-e416-4148-95c8-839b39e39649','arbeit'),('646624cb-64b0-42cb-bdb1-0acb3f38528f','privat'),('646624cb-64b0-42cb-bdb1-0acb3f38528f','arbeit'),('f1c9a422-89a8-4c01-a168-fc1209b44a2a','arbeit'),('12c4ac74-9c1d-4f42-b7a4-cbe7668f1899','privat'),('12c4ac74-9c1d-4f42-b7a4-cbe7668f1899','arbeit'),('bc8d4e27-a866-46f6-8d23-b4bca18b7ba3','arbeit'),('b91b8382-6850-4629-ab8f-6d875f092eb7','privat'),('b91b8382-6850-4629-ab8f-6d875f092eb7','arbeit');
/*!40000 ALTER TABLE `todo_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
                         `user_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                         `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         PRIMARY KEY (`user_id`),
                         UNIQUE KEY `UK_3g1j96g94xpk3lpxl2qbl985x` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('11467ab9-911d-439a-b32d-c209dbf3033a','user8','test'),('1a119b63-cd1b-4bb4-bd9f-4d0aa0fb73a7','user4','test'),('1d2821c3-8122-4687-af6e-88cbaad83c86','user6','test'),('5a2ded9b-6f48-4501-87f8-9ead35c7e35c','user1','test'),('90e85bdb-467b-4c5b-a5cc-d04ba0970fc0','user3','test'),('b7fc481d-93e1-4061-b42b-4b65339b8df2','user2','test'),('c6115f15-4830-472a-8e52-ee87059020cf','user9','test'),('cc24af75-89a0-47fd-ba60-f36a6bfdf909','user5','test'),('ce814f76-b5b7-4d43-946e-3aa0745b2cc7','user7','test'),('f588ce33-39ce-43ad-ad46-428f3638735e','user0','test');
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

-- Dump completed on 2023-05-29 17:28:07
