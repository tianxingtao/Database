-- MySQL dump 10.13  Distrib 8.0.12, for macos10.13 (x86_64)
--
-- Host: localhost    Database: art
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
-- Table structure for table `com`
--

DROP TABLE IF EXISTS `com`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `com` (
  `cid` int(11) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `com`
--

LOCK TABLES `com` WRITE;
/*!40000 ALTER TABLE `com` DISABLE KEYS */;
/*!40000 ALTER TABLE `com` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderinfo`
--

DROP TABLE IF EXISTS `orderinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orderinfo` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(45) NOT NULL COMMENT '下订单者ID',
  `pid` varchar(45) NOT NULL COMMENT '产品id',
  `time` date DEFAULT NULL COMMENT '下订单时间',
  `num` int(11) DEFAULT NULL COMMENT '下单数量',
  `price` float DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderinfo`
--

LOCK TABLES `orderinfo` WRITE;
/*!40000 ALTER TABLE `orderinfo` DISABLE KEYS */;
INSERT INTO `orderinfo` VALUES (1,'uid','1','2019-01-03',4,100,''),(2,'uid','1','2019-01-03',11,275,'北京林业大学'),(3,'uid','11','2019-01-03',2,10,'北京林业大学'),(4,'uid','11','2019-01-03',2,10,'北京林业大学');
/*!40000 ALTER TABLE `orderinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pcollection`
--

DROP TABLE IF EXISTS `pcollection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pcollection` (
  `pcid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(45) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`pcid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pcollection`
--

LOCK TABLES `pcollection` WRITE;
/*!40000 ALTER TABLE `pcollection` DISABLE KEYS */;
/*!40000 ALTER TABLE `pcollection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pcomment`
--

DROP TABLE IF EXISTS `pcomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pcomment` (
  `pcoid` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL,
  `uid` varchar(45) NOT NULL,
  `pcomment` varchar(500) DEFAULT NULL,
  `pspeaker` char(3) DEFAULT NULL,
  PRIMARY KEY (`pcoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pcomment`
--

LOCK TABLES `pcomment` WRITE;
/*!40000 ALTER TABLE `pcomment` DISABLE KEYS */;
/*!40000 ALTER TABLE `pcomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pcommentconfig`
--

DROP TABLE IF EXISTS `pcommentconfig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pcommentconfig` (
  `pcfid` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `uid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pcfid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pcommentconfig`
--

LOCK TABLES `pcommentconfig` WRITE;
/*!40000 ALTER TABLE `pcommentconfig` DISABLE KEYS */;
/*!40000 ALTER TABLE `pcommentconfig` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productinfo`
--

DROP TABLE IF EXISTS `productinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `productinfo` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品ID',
  `pname` varchar(45) DEFAULT NULL COMMENT '产品名称',
  `type` varchar(45) DEFAULT NULL COMMENT '产品类型',
  `price` float DEFAULT NULL COMMENT '产品价格',
  `introduce` varchar(500) DEFAULT NULL COMMENT '产品简介',
  `cid` varchar(45) DEFAULT NULL COMMENT '产品所属公司',
  `pnum` int(11) DEFAULT NULL COMMENT '产品库存',
  `picturelocation` varchar(45) DEFAULT NULL,
  `pview` int(11) DEFAULT '0',
  `pbuynum` int(11) DEFAULT '0',
  `pstatus` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='产品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productinfo`
--

LOCK TABLES `productinfo` WRITE;
/*!40000 ALTER TABLE `productinfo` DISABLE KEYS */;
INSERT INTO `productinfo` VALUES (1,'hhhh','java',25,'dfkjlns','1',29384,NULL,18,0,NULL),(2,'ppp','python',4,'sdf,jsnkf','1',10,'65c89da2-3959-45ec-9b9b-14da897043d1.png',1,0,NULL),(3,'asdkj',NULL,0,NULL,NULL,0,'5a3971bf-6c7b-40e1-ba6c-6e95b25f8f6a.png',0,0,NULL),(4,'pdf',NULL,0,NULL,NULL,0,'05155459-368e-45ab-8101-bb3b8407da26.png',0,0,NULL),(5,'sdkaj',NULL,0,NULL,NULL,0,'03addc83-8610-4a68-bb2a-0795226b641a.png',0,0,NULL),(8,'a',NULL,0,NULL,'null',0,'b5f8183f-efd5-436f-9838-4798885574af.png',0,0,NULL),(11,'java编程思想','java',5,'java编程思想','null',10,'7f0d4a1c-7efc-4a03-95d4-c339c63cc03d.jpg',2,0,NULL),(12,'java编程思想','java',5,'java编程思想','null',10,'1e794dfe-9f1e-43ce-b865-e6dc620fa9f2.jpg',0,0,NULL),(14,'java编程思想','java',5,'java编程思想','null',10,'2facb6dd-c975-4da7-be1b-b82e2f205e21.jpg',0,0,NULL),(17,'java编程思想','java',5,'java编程思想','1',10,'22c37eaf-5f06-48aa-bbfc-06746b187c3f.jpg',0,0,NULL);
/*!40000 ALTER TABLE `productinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `products` (
  `pnid` int(11) NOT NULL DEFAULT '1',
  `pnum` int(11) DEFAULT '0',
  PRIMARY KEY (`pnid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,9);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pshoppingcart`
--

DROP TABLE IF EXISTS `pshoppingcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pshoppingcart` (
  `psid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(45) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`psid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pshoppingcart`
--

LOCK TABLES `pshoppingcart` WRITE;
/*!40000 ALTER TABLE `pshoppingcart` DISABLE KEYS */;
INSERT INTO `pshoppingcart` VALUES (9,'',1,2),(10,'uid',2,2);
/*!40000 ALTER TABLE `pshoppingcart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `uid` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2019-01-03 21:14:36
