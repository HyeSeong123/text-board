CREATE DATABASE `a1`

SET NAMES utf8mb4;
/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 10.4.6-MariaDB : Database - a1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`a1` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `a1`;

/*Table structure for table `Reply` */

DROP TABLE IF EXISTS `Reply`;

CREATE TABLE `Reply` (
  `replyNum` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `articleNum` INT(10) UNSIGNED NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `regDate` DATETIME NOT NULL,
  `updateDate` DATETIME NOT NULL,
  `body` TEXT NOT NULL,
  PRIMARY KEY (`replyNum`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;

/*Data for the table `Reply` */

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `Num` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `memberNum` INT(10) UNSIGNED NOT NULL,
  `boardNum` INT(10) UNSIGNED NOT NULL,
  `replyNum` INT(10) UNSIGNED NOT NULL,
  `views` INT(10) UNSIGNED NOT NULL,
  `regDate` DATETIME NOT NULL,
  `updateDate` DATETIME NOT NULL,
  `recommandNum` INT(10) UNSIGNED NOT NULL,
  `title` VARCHAR(60) COLLATE utf8_unicode_ci NOT NULL,
  `body` TEXT COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Num`)
) ENGINE=INNODB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `article` */

INSERT  INTO `article`(`Num`,`memberNum`,`boardNum`,`replyNum`,`views`,`regDate`,`updateDate`,`recommandNum`,`title`,`body`) VALUES 
(1,1,1,0,0,'2020-12-21 08:58:22','2020-12-21 08:58:27',0,'공지사항','## 안녕하세요 블로그 주인 방혜성 입니다.\r\n앞으로 제 공부 내용들이 올라올 사이트입니다.'),
(2,1,2,0,0,'2020-12-21 09:03:49','2020-12-21 09:03:50',0,'JAVA IF문','if는 조건을 비교하고 그에 따른 결과를 내줍니다.\r\nelse는 if의 조건과 맞지 않을 때 else에 들어간 값을 반환하고\r\nelse if는 if의 조건이 아닐 때 여러개의 값을 줄 수 있습니다.\r\n```\r\nint a =0;\r\nint b = 0;\r\nif(a==0){\r\n    b = 1;\r\n}\r\nelse{\r\n    b = 2;\r\n}\r\n```'),
(3,1,3,0,0,'2020-12-21 09:20:24','2020-12-21 09:20:24',0,'테스트 게시물1','```\r\n<div></div>\r\n```'),
(4,1,2,0,0,'2020-12-22 09:24:21','2020-12-22 09:24:22',0,'JAVA FOR문','for문은 변수를 일정 횟수만큼 반복시켜주는 반복문 입니다.\r\n사용 방법은\r\n```\r\nint  b = 0;\r\nfor(int i=0; i&lt;5; i++){\r\n    b++;\r\n}\r\n```\r\n위와 같습니다.\r\n결과는 b가 5가 됩니다.\r\nfor의\r\n첫째 칸에는 i의 시작 조건\r\n두번째 칸에는 i의 크기\r\n세번째 칸에는 연산 조건을 넣을 수 있습니다.'),
(5,1,2,0,0,'2020-12-22 09:25:10','2020-12-22 09:25:12',0,'웹 audio 태그','사이트에 음악을 넣을 때 audio 태그를 사용합니다.\r\n사용방법\r\n```\r\nHTML\r\n<audio id=\"myAudio\" autoplay=\"\" controls=\"\">\r\n<source src=\"../music/노래.mp3>\r\n</audio>\r\n```\r\n위와 같이 생성하면 myAudio의 id를 가진 오디오가 활성화 되며,\r\nautoplay는 사이트가 생성됨과 동시에 파일이 재생되게 해줍니다.\r\ncontrols는 일시정지 볼륨 조절 등을 가능하게 해줍니다.\r\n그리고 시작 시 볼륨 조정 방법을 자바 스크립트로 할 수 있습니다.\r\n\r\n');

/*Table structure for table `board` */

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
  `boardNum` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `regDate` DATETIME NOT NULL,
  `updateDate` DATETIME NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `code` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`boardNum`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `board` */

INSERT  INTO `board`(`boardNum`,`regDate`,`updateDate`,`name`,`code`) VALUES 
(1,'2020-12-21 09:15:56','2020-12-21 09:15:56','공지사항','공지'),
(2,'2020-12-21 09:16:13','2020-12-21 09:16:13','공부게시판','공부'),
(3,'2020-12-21 09:16:26','2020-12-21 09:16:26','자유게시판','자유');

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `memberNum` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `regDate` DATETIME NOT NULL,
  `name` VARCHAR(50) COLLATE utf8_unicode_ci NOT NULL,
  `id` VARCHAR(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` VARCHAR(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`memberNum`)
) ENGINE=INNODB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `member` */

INSERT  INTO `member`(`memberNum`,`regDate`,`name`,`id`,`password`) VALUES 
(1,'2020-12-16 10:51:10','aaa','aaa','aaa'),
(2,'2020-12-16 10:51:17','방혜성','baobab612','baobab0612'),
(3,'2020-12-16 10:51:24','bbb','bbb','bbb'),
(4,'2020-12-16 11:02:13','ccc','ccc','ccc'),
(5,'2020-12-16 11:08:39','fff','fff','fff');

/*Table structure for table `recommand` */

DROP TABLE IF EXISTS `recommand`;

CREATE TABLE `recommand` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `regDate` DATETIME NOT NULL,
  `updateDate` DATETIME NOT NULL,
  `memberId` INT(10) UNSIGNED NOT NULL,
  `articleId` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `recommand` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;