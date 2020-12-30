-- MariaDB dump 10.18  Distrib 10.4.17-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: a1
-- ------------------------------------------------------
-- Server version	10.4.17-MariaDB

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
-- Table structure for table `Reply`
--

DROP TABLE IF EXISTS `Reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Reply` (
  `replyNum` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `articleNum` int(10) unsigned NOT NULL,
  `name` varchar(100) NOT NULL,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `body` text NOT NULL,
  PRIMARY KEY (`replyNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reply`
--

LOCK TABLES `Reply` WRITE;
/*!40000 ALTER TABLE `Reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `Reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `Num` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `memberNum` int(10) unsigned NOT NULL,
  `boardNum` int(10) unsigned NOT NULL,
  `replyNum` int(10) unsigned NOT NULL,
  `views` int(10) unsigned NOT NULL,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `recommandNum` int(10) unsigned NOT NULL,
  `title` varchar(60) NOT NULL,
  `body` text NOT NULL,
  PRIMARY KEY (`Num`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,1,2,0,0,'2020-12-28 20:56:30','2020-12-28 20:56:32',0,'.','테스트 게시물.'),(2,1,1,0,0,'2020-12-21 08:58:22','2020-12-21 08:58:27',0,'공지사항','## 안녕하세요 블로그 주인 방혜성 입니다.\r\n앞으로 제 공부 내용들이 올라올 사이트입니다.'),(3,1,4,0,0,'2020-12-21 09:03:49','2020-12-21 09:03:50',0,'JAVA IF문','if는 조건을 비교하고 그에 따른 결과를 내줍니다.\r\nelse는 if의 조건과 맞지 않을 때 else에 들어간 값을 반환하고\r\nelse if는 if의 조건이 아닐 때 여러개의 값을 줄 수 있습니다.\r\n```codepen\r\nhttps://codepen.io/hyeseong123/embed/RwGLpEm?height=265&theme-id=light&default-tab=js,result&editable=true\r\n```'),(4,1,3,0,0,'2020-12-21 09:20:24','2020-12-21 09:20:24',0,'테스트 게시물1','```\r\n<div></div>\r\n```'),(5,1,4,0,0,'2020-12-22 09:24:21','2020-12-22 09:24:22',0,'JAVA FOR문','for문은 변수를 일정 횟수만큼 반복시켜주는 반복문 입니다.\r\n사용 방법은\r\n```codepen\r\nhttps://codepen.io/hyeseong123/embed/NWRapmr?height=265&theme-id=light&default-tab=js,result&editable=true\r\n```\r\n위와 같습니다.\r\n결과는 b가 5가 됩니다.\r\nfor의\r\n첫째 칸에는 i의 시작 조건\r\n두번째 칸에는 i의 크기\r\n세번째 칸에는 연산 조건을 넣을 수 있습니다.\r\n직접 값을 대입 하실 수 있습니다.'),(6,1,5,0,0,'2020-12-22 09:25:10','2020-12-22 09:25:12',0,'웹 audio 태그','사이트에 음악을 넣을 때 audio 태그를 사용합니다.\r\n사용방법\r\n```codepen\r\nhttps://codepen.io/hyeseong123/embed/qBaPmYe?height=265&theme-id=light&default-tab=html,result\r\n```\r\n위와 같이 생성하면 myAudio의 id를 가진 오디오가 활성화 되며,\r\nautoplay는 사이트가 생성됨과 동시에 오디오가 재생되게 해줍니다.\r\ncontrols는 일시정지 볼륨 조절 등을 가능하게 해줍니다.\r\n\r\nJS 클릭 시 볼륨 자동 조절이 가능한 코드를 보실 수 있습니다.\r\n볼륨은 0.0~1.0 까지 조절 가능합니다.\r\n'),(7,1,5,0,0,'2020-12-23 12:37:46','2020-12-23 12:37:47',0,'웹 자주 사용하는 태그','HTML에서 자주 사용하는 태그에는\r\n```codepen\r\nhttps://codepen.io/hyeseong123/embed/LYRzygY?height=265&theme-id=light&default-tab=html,result\r\n```\r\n가 있습니다.\r\n\r\ndiv = 특징이 없을 때 보통 사용하는 태그이고,\r\nnav = 네비게이션의 약자로 어떤 항목으로 이동시켜줄때 사용되는 태그입니다.\r\nsection = 구역 또는 문단을 나눌때 자주 사용됩니다.\r\n\r\n위 세개는 display : block의 요소를 가지고 있습니다\r\n\r\na = 링크 태그이며 nav의 자식으로 들어가는 경우가 많습니다.\r\n```\r\na[href=\"#\"] 을 넣어서 이동하지 않게 할 수 있고\r\n다른 태그에 id=\"#123\"\r\na[href=\"#123\"] 을 넣어서 하이퍼 링크식으로 사용할 수 있습니다.\r\n```\r\n\r\nspan = 문자를 넣을 때 자주 사용됩니다.\r\n\r\nimg = 이미지를 넣을 때 사용되며 src에는 사진의 위치를 넣으며\r\nalt는 사진이 표시되지 않을 때 대신해서 보여줄 문자 입니다.\r\n\r\n위 새개의 태그는 기본 display : inline으로 설정 돼 있습니다.\r\n'),(8,1,6,0,0,'2020-12-29 08:50:53','2020-12-29 08:50:55',0,'JSP 서블릿','```codepen\r\nhttps://codepen.io/hyeseong123/embed/GRjyyew?height=465&theme-id=light&default-tab=result\r\n```'),(9,1,3,0,0,'2020-12-29 22:38:49','2020-12-29 22:38:50',0,'테스트 게시물2','123'),(10,1,3,0,0,'2020-12-29 22:39:10','2020-12-29 22:39:12',0,'테스트 게시물3','123');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board` (
  `boardNum` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `name` varchar(100) NOT NULL,
  `code` varchar(100) NOT NULL,
  PRIMARY KEY (`boardNum`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'2020-12-21 09:15:56','2020-12-21 09:15:56','🌳 공지사항 🌳','공지'),(2,'2020-12-21 09:16:13','2020-12-21 09:16:13','📖 공부게시판 📖','📖 공부게시판 📖'),(3,'2020-12-21 09:16:26','2020-12-21 09:16:26','🍫 자유게시판 🍫','🍫 자유게시판 🍫'),(4,'2020-12-28 17:22:39','2020-12-28 17:22:12','자바','공부게시판 - 자바'),(5,'2020-12-28 20:07:07','2020-12-28 20:07:10','웹','공부게시판 - 웹'),(6,'2020-12-29 08:00:14','2020-12-29 08:00:20','JSP','공부게시판 - JSP');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `memberNum` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `name` varchar(50) NOT NULL,
  `id` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`memberNum`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'2020-12-16 10:51:17','방혜성','baobab612','baobab0612'),(2,'2020-12-16 10:51:10','aaa','aaa','aaa'),(3,'2020-12-16 10:51:24','bbb','bbb','bbb'),(4,'2020-12-16 11:02:13','ccc','ccc','ccc'),(5,'2020-12-16 11:08:39','fff','fff','fff');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommand`
--

DROP TABLE IF EXISTS `recommand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recommand` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `memberId` int(10) unsigned NOT NULL,
  `articleId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommand`
--

LOCK TABLES `recommand` WRITE;
/*!40000 ALTER TABLE `recommand` DISABLE KEYS */;
/*!40000 ALTER TABLE `recommand` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-30 16:45:45
