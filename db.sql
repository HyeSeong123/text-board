`a1``article`CREATE DATABASE `a1`
USE `a1`

DROP TABLE `article`
DROP TABLE `board`
DROP TABLE `member`
DROP TABLE `recommand`
DROP TABLE `Reply`

DROP TABLE `member`
CREATE TABLE `member`(
    memberNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `id` VARCHAR(50) NOT NULL,
    `password` VARCHAR(100) NOT NULL
);
SELECT * FROM `member`

DESC `member`
DROP TABLE `article`
CREATE TABLE `article`(
    Num INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    memberNum INT(10) UNSIGNED NOT NULL,
    boardNum INT(10) UNSIGNED NOT NULL,
    replyNum INT(10) UNSIGNED NOT NULL,
    views INT(10) UNSIGNED NOT NULL,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    recommandNum INT(10) UNSIGNED NOT NULL,
    title VARCHAR(60) NOT NULL,
    `body` TEXT NOT NULL 
);

SELECT * FROM article
ORDER BY Num DESC;

INSERT INTO article
    SET memberNum = FLOOR(RAND()*4)+2,
    boardNum = FLOOR(RAND()*4)+1,
    replyNum = 0,
    views =0,
    regDate = DATE(NOW()),
    updateDate = DATE(NOW()),
    recommandNum = 0,
    title = CONCAT('제목_',RAND()),
    `body` = CONCAT('내용_', RAND())
    
SELECT * FROM board;
CREATE TABLE `board`(
    boardNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `recommand`(
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    memberId INT(10) UNSIGNED NOT NULL,
    articleId INT(10) UNSIGNED NOT NULL
);

CREATE TABLE `Reply`(
    replyNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT N`a1`ULL,
    updateDate DATETIME NOT NULL,
    articleNum INT(10) UNSIGNED NOT NULL,
    `name` VARCHAR(60) NOT NULL,
    `body` TEXT NOT NULL
);






/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 10.4.14-MariaDB : Database - a2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`a2` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `a2`;

/*Table structure for table `Member` */

DROP TABLE IF EXISTS `Member`;

CREATE TABLE `Member` (
  `memberNum` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `regDate` DATETIME NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `id` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`memberNum`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `Member` */

INSERT  INTO `Member`(`memberNum`,`regDate`,`name`,`id`,`password`) VALUES 
(1,'2020-12-21 08:51:31','방혜성','baobab612','baobab0612'),
(2,'2020-12-21 08:51:46','aaa','aaa','aaa'),
(3,'2020-12-21 08:51:52','bbb','bbb','bbb');

/*Table structure for table `Recommand` */

DROP TABLE IF EXISTS `Recommand`;

CREATE TABLE `Recommand` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `regDate` DATETIME NOT NULL,
  `updateDate` DATETIME NOT NULL,
  `memberId` INT(10) UNSIGNED NOT NULL,
  `articleId` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;

/*Data for the table `Recommand` */

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
  `num` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `views` INT(10) UNSIGNED NOT NULL,
  `replyNum` INT(10) UNSIGNED NOT NULL,
  `memberNum` INT(10) UNSIGNED NOT NULL,
  `boardNum` INT(10) UNSIGNED NOT NULL,
  `recommandNum` INT(10) UNSIGNED NOT NULL,
  `regDate` DATETIME NOT NULL,
  `updateDate` DATETIME NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `body` TEXT NOT NULL,
  PRIMARY KEY (`num`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `article` */

INSERT  INTO `article`(`num`,`views`,`replyNum`,`memberNum`,`boardNum`,`recommandNum`,`regDate`,`updateDate`,`title`,`body`) VALUES 
(1,0,0,1,1,0,'2020-12-21 08:58:22','2020-12-21 08:58:27','공지사항','## 안녕하세요 블로그 주인 방혜성 입니다.\r\n앞으로 제 공부 내용들이 올라올 사이트입니다.'),
(2,0,0,1,2,0,'2020-12-21 09:03:49','2020-12-21 09:03:50','JAVA IF문','if는 조건을 비교하고 그에 따른 결과를 내줍니다.\r\nelse는 if의 조건과 맞지 않을 때 else에 들어간 값을 반환하고\r\nelse if는 if의 조건이 아닐 때 여러개의 값을 줄 수 있습니다.\r\n```\r\nint a =0;\r\nint b = 0;\r\nif(a==0){\r\n    b = 1;\r\n}\r\nelse{\r\n    b = 2;\r\n}\r\n```'),
(3,0,0,1,3,0,'2020-12-21 09:20:24','2020-12-21 09:20:24','테스트 게시물1','```\r\n<div></div>\r\n```');

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

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;