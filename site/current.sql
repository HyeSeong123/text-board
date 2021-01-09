/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 10.4.17-MariaDB : Database - a1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`a1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;

USE `a1`;

/*Table structure for table `Reply` */

DROP TABLE IF EXISTS `Reply`;

CREATE TABLE `Reply` (
  `replyNum` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `articleNum` int(10) unsigned NOT NULL,
  `name` varchar(100) NOT NULL,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `body` text NOT NULL,
  PRIMARY KEY (`replyNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `Reply` */

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `Num` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `memberNum` int(10) unsigned NOT NULL,
  `boardNum` int(10) unsigned NOT NULL,
  `commentsCount` int(10) unsigned NOT NULL,
  `views` int(10) unsigned NOT NULL,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `likes` int(10) unsigned NOT NULL,
  `title` varchar(60) NOT NULL,
  `body` text NOT NULL,
  PRIMARY KEY (`Num`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

/*Data for the table `article` */

insert  into `article`(`Num`,`memberNum`,`boardNum`,`commentsCount`,`views`,`regDate`,`updateDate`,`likes`,`title`,`body`) values 
(1,1,2,0,0,'2020-12-28 20:56:30','2021-01-07 23:17:32',0,'.','테스트 게시물.'),
(2,1,1,1,2,'2020-12-21 08:58:22','2021-01-07 23:17:32',1,'공지사항','## 안녕하세요 블로그 주인 방혜성 입니다.\r\n앞으로 제 공부 내용들이 올라올 사이트입니다.'),
(3,1,4,0,0,'2020-12-21 09:03:49','2021-01-07 23:17:31',0,'JAVA IF문','if는 조건을 비교하고 그에 따른 결과를 내줍니다.\r\nelse는 if의 조건과 맞지 않을 때 else에 들어간 값을 반환하고\r\nelse if는 if의 조건이 아닐 때 여러개의 값을 줄 수 있습니다.\r\n```codepen\r\nhttps://codepen.io/hyeseong123/embed/RwGLpEm?height=265&theme-id=light&default-tab=js,result&editable=true\r\n```'),
(4,1,3,0,0,'2020-12-21 09:20:24','2021-01-07 23:17:31',0,'테스트 게시물1','```\r\n<div></div>\r\n```'),
(5,1,4,1,2,'2020-12-22 09:24:21','2021-01-07 23:17:31',1,'JAVA FOR문','for문은 변수를 일정 횟수만큼 반복시켜주는 반복문 입니다.\r\n사용 방법은\r\n```codepen\r\nhttps://codepen.io/hyeseong123/embed/NWRapmr?height=265&theme-id=light&default-tab=js,result&editable=true\r\n```\r\n위와 같습니다.\r\n결과는 b가 5가 됩니다.\r\nfor의\r\n첫째 칸에는 i의 시작 조건\r\n두번째 칸에는 i의 크기\r\n세번째 칸에는 연산 조건을 넣을 수 있습니다.\r\n직접 값을 대입 하실 수 있습니다.'),
(6,1,5,0,0,'2020-12-22 09:25:10','2021-01-07 23:17:30',0,'웹 audio 태그','사이트에 음악을 넣을 때 audio 태그를 사용합니다.\r\n사용방법\r\n```codepen\r\nhttps://codepen.io/hyeseong123/embed/qBaPmYe?height=265&theme-id=light&default-tab=html,result\r\n```\r\n위와 같이 생성하면 myAudio의 id를 가진 오디오가 활성화 되며,\r\nautoplay는 사이트가 생성됨과 동시에 오디오가 재생되게 해줍니다.\r\ncontrols는 일시정지 볼륨 조절 등을 가능하게 해줍니다.\r\n\r\nJS 클릭 시 볼륨 자동 조절이 가능한 코드를 보실 수 있습니다.\r\n볼륨은 0.0~1.0 까지 조절 가능합니다.\r\n'),
(7,1,5,0,1,'2020-12-23 12:37:46','2021-01-07 23:17:30',0,'웹 자주 사용하는 태그','HTML에서 자주 사용하는 태그에는\r\n```codepen\r\nhttps://codepen.io/hyeseong123/embed/LYRzygY?height=265&theme-id=light&default-tab=html,result\r\n```\r\n가 있습니다.\r\n\r\ndiv = 특징이 없을 때 보통 사용하는 태그이고,\r\nnav = 네비게이션의 약자로 어떤 항목으로 이동시켜줄때 사용되는 태그입니다.\r\nsection = 구역 또는 문단을 나눌때 자주 사용됩니다.\r\n\r\n위 세개는 display : block의 요소를 가지고 있습니다\r\n\r\na = 링크 태그이며 nav의 자식으로 들어가는 경우가 많습니다.\r\n```\r\na[href=\"#\"] 을 넣어서 이동하지 않게 할 수 있고\r\n다른 태그에 id=\"#123\"\r\na[href=\"#123\"] 을 넣어서 하이퍼 링크식으로 사용할 수 있습니다.\r\n```\r\n\r\nspan = 문자를 넣을 때 자주 사용됩니다.\r\n\r\nimg = 이미지를 넣을 때 사용되며 src에는 사진의 위치를 넣으며\r\nalt는 사진이 표시되지 않을 때 대신해서 보여줄 문자 입니다.\r\n\r\n위 새개의 태그는 기본 display : inline으로 설정 돼 있습니다.\r\n'),
(8,1,6,0,2,'2020-12-29 08:50:53','2021-01-07 23:17:29',0,'JSP 서블릿','```codepen\r\nhttps://codepen.io/hyeseong123/embed/GRjyyew?height=465&theme-id=light&default-tab=result\r\n```'),
(9,1,3,1,0,'2020-12-29 22:38:49','2021-01-07 23:17:29',1,'테스트 게시물2','123'),
(10,1,3,0,0,'2020-12-29 22:39:10','2021-01-07 23:17:28',0,'게시물3','123'),
(11,1,5,0,0,'2021-01-06 22:16:52','2021-01-07 23:17:28',0,'웹 한 글자씩 나오는 효과','코드입니다.\r\n```codepen\r\nhttps://codepen.io/hyeseong123/embed/OJRZrzm?height=265&theme-id=light&default-tab=js,result&editable\r\n```\r\n\r\nword 함수에서 str의 글자수 연산을 해줍니다.'),
(23,1,5,0,0,'2021-01-07 23:01:52','2021-01-07 23:17:28',0,'웹 display 요소','display에는 block, inline-block, flex, inline, table 5개가 있습니다.\r\n오늘은 block와 inline-block,inline 3가지만 쓰겠습니다.\r\n```codepen\r\nhttps://codepen.io/hyeseong123/embed/RwGJBzz?height=560&theme-id=light&default-tab=css,result&editable=true\r\n```\r\n위와 같이\r\nblock은 최대 크기로 늘어나는 속성이며 한 줄을 다 사용합니다.\r\ninline-block 는 최대한 수축하며 너비와 높이를 변경할 수 있습니다.\r\n최대한 수축하려는 속성 때문에 한줄에 여러 태그를 같이 사용할 수 있습니다.\r\ninline은 최대 크기로 수축하며 너비랑 높이 변경이 안됩니다.\r\n```html\r\n<br>을 사용 하여 한 줄을 띄울 수도 있지만\r\n<div></div>\r\n<section></section>\r\n<nav></nav>\r\n```\r\n들의 태그들은 기본 속성이 block이여서 중간에 하나를 사용하면 br과 같은 효과를 볼 수 있습니다.');

/*Table structure for table `board` */

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
  `boardNum` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `name` varchar(100) NOT NULL,
  `code` varchar(100) NOT NULL,
  PRIMARY KEY (`boardNum`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `board` */

insert  into `board`(`boardNum`,`regDate`,`updateDate`,`name`,`code`) values 
(1,'2020-12-21 09:15:56','2020-12-21 09:15:56','Notice','공지사항'),
(2,'2020-12-21 09:16:13','2020-12-21 09:16:13','Study Record','공부게시판'),
(3,'2020-12-21 09:16:26','2020-12-21 09:16:26','Free','자유게시판'),
(4,'2020-12-28 17:22:39','2020-12-28 17:22:12','Java','공부게시판 - 자바'),
(5,'2020-12-28 20:07:07','2020-12-28 20:07:10','Web','공부게시판 - 웹'),
(6,'2020-12-29 08:00:14','2020-12-29 08:00:20','JSP','공부게시판 - JSP');

/*Table structure for table `ga4DataPageHit` */

DROP TABLE IF EXISTS `ga4DataPageHit`;

CREATE TABLE `ga4DataPageHit` (
  `num` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `pagePath` char(100) COLLATE utf8mb4_bin NOT NULL,
  `hit` int(10) unsigned NOT NULL,
  PRIMARY KEY (`num`),
  UNIQUE KEY `pagePath` (`pagePath`)
) ENGINE=InnoDB AUTO_INCREMENT=740 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `ga4DataPageHit` */

insert  into `ga4DataPageHit`(`num`,`regDate`,`updateDate`,`pagePath`,`hit`) values 
(337,'2021-01-06 23:58:10','2021-01-06 23:58:10','/7.html',1),
(598,'2021-01-07 10:17:15','2021-01-07 10:17:15','/8.html',2),
(730,'2021-01-07 23:17:35','2021-01-07 23:17:35','/',18),
(731,'2021-01-07 23:17:35','2021-01-07 23:17:35','/article_list_Java_1.html',4),
(732,'2021-01-07 23:17:35','2021-01-07 23:17:35','/article_list_Web_1.html',4),
(733,'2021-01-07 23:17:35','2021-01-07 23:17:35','/article_list_Free_1.html',3),
(734,'2021-01-07 23:17:35','2021-01-07 23:17:35','/article_list_JSP_1.html',3),
(735,'2021-01-07 23:17:35','2021-01-07 23:17:35','/article_list_Notice_1.html',3),
(736,'2021-01-07 23:17:35','2021-01-07 23:17:35','/joinPage.html',3),
(737,'2021-01-07 23:17:35','2021-01-07 23:17:35','/11.html',2),
(738,'2021-01-07 23:17:35','2021-01-07 23:17:35','/2.html',2),
(739,'2021-01-07 23:17:35','2021-01-07 23:17:35','/5.html',2);

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `memberNum` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `name` varchar(50) NOT NULL,
  `id` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`memberNum`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `member` */

insert  into `member`(`memberNum`,`regDate`,`name`,`id`,`password`) values 
(1,'2020-12-16 10:51:17','방혜성','baobab612','baobab0612'),
(2,'2020-12-16 10:51:10','aaa','aaa','aaa'),
(3,'2020-12-16 10:51:24','bbb','bbb','bbb'),
(4,'2020-12-16 11:02:13','ccc','ccc','ccc'),
(5,'2020-12-16 11:08:39','fff','fff','fff');

/*Table structure for table `recommand` */

DROP TABLE IF EXISTS `recommand`;

CREATE TABLE `recommand` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `memberId` int(10) unsigned NOT NULL,
  `articleId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `recommand` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
