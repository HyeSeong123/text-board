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
  `commentsCount` int(10) unsigned NOT NULL DEFAULT 0,
  `views` int(10) unsigned NOT NULL DEFAULT 0,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `likes` int(10) unsigned NOT NULL DEFAULT 0,
  `title` varchar(60) NOT NULL,
  `body` text NOT NULL,
  PRIMARY KEY (`Num`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

/*Data for the table `article` */

insert  into `article`(`Num`,`memberNum`,`boardNum`,`commentsCount`,`views`,`regDate`,`updateDate`,`likes`,`title`,`body`) values 
(1,1,2,0,0,'2020-12-28 20:56:30','2021-01-27 01:20:12',0,'.','테스트 게시물.'),
(2,1,1,1,3,'2020-12-21 08:58:22','2021-01-27 01:20:11',1,'공지사항','## 안녕하세요 블로그 주인 방혜성 입니다.\r\n앞으로 제 공부 내용들이 올라올 사이트입니다.'),
(3,1,4,0,0,'2020-12-21 09:03:49','2021-01-27 01:20:11',0,'JAVA IF문','if는 조건을 비교하고 그에 따른 결과를 내줍니다.\r\nelse는 if의 조건과 맞지 않을 때 else에 들어간 값을 반환하고\r\nelse if는 if의 조건이 아닐 때 여러개의 값을 줄 수 있습니다.\r\n```codepen\r\nhttps://codepen.io/hyeseong123/embed/RwGLpEm?height=265&theme-id=light&default-tab=js,result&editable=true\r\n```'),
(4,1,3,0,0,'2020-12-21 09:20:24','2021-01-27 01:20:11',0,'테스트 게시물1','```\r\n<div></div>\r\n```'),
(5,1,4,1,2,'2020-12-22 09:24:21','2021-01-27 01:20:10',1,'JAVA FOR문','for문은 변수를 일정 횟수만큼 반복시켜주는 반복문 입니다.\r\n사용 방법은\r\n```codepen\r\nhttps://codepen.io/hyeseong123/embed/NWRapmr?height=265&theme-id=light&default-tab=js,result&editable=true\r\n```\r\n위와 같습니다.\r\n결과는 b가 5가 됩니다.\r\nfor의\r\n첫째 칸에는 i의 시작 조건\r\n두번째 칸에는 i의 크기\r\n세번째 칸에는 연산 조건을 넣을 수 있습니다.\r\n직접 값을 대입 하실 수 있습니다.'),
(6,1,5,0,0,'2020-12-22 09:25:10','2021-01-27 01:20:10',0,'audio 태그','사이트에 음악을 넣을 때 audio 태그를 사용합니다.\r\n사용방법\r\n```codepen\r\nhttps://codepen.io/hyeseong123/embed/qBaPmYe?height=265&theme-id=light&default-tab=html,result\r\n```\r\n위와 같이 생성하면 myAudio의 id를 가진 오디오가 활성화 되며,\r\nautoplay는 사이트가 생성됨과 동시에 오디오가 재생되게 해줍니다.\r\ncontrols는 일시정지 볼륨 조절 등을 가능하게 해줍니다.\r\n\r\nJS 클릭 시 볼륨 자동 조절이 가능한 코드를 보실 수 있습니다.\r\n볼륨은 0.0~1.0 까지 조절 가능합니다.\r\n'),
(7,1,5,0,1,'2020-12-23 12:37:46','2021-01-27 01:20:10',0,'자주 사용하는 태그','HTML에서 자주 사용하는 태그에는\r\n```codepen\r\nhttps://codepen.io/hyeseong123/embed/LYRzygY?height=265&theme-id=light&default-tab=html,result\r\n```\r\n가 있습니다.\r\n\r\ndiv = 특징이 없을 때 보통 사용하는 태그이고,\r\nnav = 네비게이션의 약자로 어떤 항목으로 이동시켜줄때 사용되는 태그입니다.\r\nsection = 구역 또는 문단을 나눌때 자주 사용됩니다.\r\n\r\n위 세개는 display : block의 요소를 가지고 있습니다\r\n\r\na = 링크 태그이며 nav의 자식으로 들어가는 경우가 많습니다.\r\n```\r\na[href=\"#\"] 을 넣어서 이동하지 않게 할 수 있고\r\n다른 태그에 id=\"#123\"\r\na[href=\"#123\"] 을 넣어서 하이퍼 링크식으로 사용할 수 있습니다.\r\n```\r\n\r\nspan = 문자를 넣을 때 자주 사용됩니다.\r\n\r\nimg = 이미지를 넣을 때 사용되며 src에는 사진의 위치를 넣으며\r\nalt는 사진이 표시되지 않을 때 대신해서 보여줄 문자 입니다.\r\n\r\n위 새개의 태그는 기본 display : inline으로 설정 돼 있습니다.\r\n'),
(8,1,6,0,2,'2020-12-29 08:50:53','2021-01-27 01:20:09',0,'JSP 서블릿','```codepen\r\nhttps://codepen.io/hyeseong123/embed/GRjyyew?height=465&theme-id=light&default-tab=result\r\n```'),
(9,1,3,1,0,'2020-12-29 22:38:49','2021-01-27 01:20:09',1,'테스트 게시물2','123'),
(10,1,3,0,0,'2020-12-29 22:39:10','2021-01-27 01:20:09',0,'게시물3','123'),
(11,1,5,0,0,'2021-01-06 22:16:52','2021-01-27 01:20:08',0,'[자바스크립트]한 글자씩 나오는 효과','코드입니다.\r\n```codepen\r\nhttps://codepen.io/hyeseong123/embed/OJRZrzm?height=265&theme-id=light&default-tab=js,result&editable\r\n```\r\n\r\nword 함수에서 str의 글자수 연산을 해줍니다.'),
(12,1,5,0,3,'2021-01-07 23:01:52','2021-01-27 01:20:08',0,'display 요소','display에는 block, inline-block, flex, inline, table 5개가 있습니다.\r\n오늘은 block와 inline-block,inline 3가지만 쓰겠습니다.\r\n```codepen\r\nhttps://codepen.io/hyeseong123/embed/RwGJBzz?height=560&theme-id=light&default-tab=css,result&editable=true\r\n```\r\n위와 같이\r\nblock은 최대 크기로 늘어나는 속성이며 한 줄을 다 사용합니다.\r\ninline-block 는 최대한 수축하며 너비와 높이를 변경할 수 있습니다.\r\n최대한 수축하려는 속성 때문에 한줄에 여러 태그를 같이 사용할 수 있습니다.\r\ninline은 최대 크기로 수축하며 너비랑 높이 변경이 안됩니다.\r\n```html\r\n<br>을 사용 하여 한 줄을 띄울 수도 있지만\r\n<div></div>\r\n<section></section>\r\n<nav></nav>\r\n```\r\n들의 태그들은 기본 속성이 block이여서 중간에 하나를 사용하면 br과 같은 효과를 볼 수 있습니다.'),
(13,1,4,0,0,'2021-01-18 23:17:34','2021-01-27 01:20:08',0,'자바 문자열 비교 함수','int 같은 정수형 변수들을 비교할 때는 조건문에 == 을 사용하여 비교합니다.\r\n그러나 String의 변수를 비교할 때는 변수.equal을 사용합니다.\r\n\r\n```java\r\npackage pra;\r\n\r\nimport java.util.ArrayList;\r\nimport java.util.List;\r\nimport java.util.Scanner;\r\n\r\npublic class Main {\r\n	public static void main(String[] args) {\r\n\r\n		Scanner sc = new Scanner(System.in);\r\n\r\n		String a = \"aa\";\r\n		String b = new String(\"aa\");\r\n		\r\n		if(a == b) {\r\n			System.out.println(\"맞음\");\r\n		} else if(a!=b) {\r\n			System.out.println(\"틀림\");\r\n		}\r\n	}\r\n}\r\n```\r\n위의 실행 결과는 틀림입니다. 자세한 이론은 모르지만 ==은 변수 속의 값을 비교하는게 아닌\r\n변수의 주소값을 비교한다고 합니다.\r\n\r\n```\r\npackage pra;\r\n\r\nimport java.util.ArrayList;\r\nimport java.util.List;\r\nimport java.util.Scanner;\r\n\r\npublic class Main {\r\n	public static void main(String[] args) {\r\n\r\n		Scanner sc = new Scanner(System.in);\r\n\r\n		String a = \"aa\";\r\n		String b = new String(\"aa\");\r\n		\r\n		if(a.equals(b)) {\r\n			System.out.println(\"맞음\");\r\n		} else if(a.equals(b) == false) {\r\n			System.out.println(\"틀림\");\r\n		}\r\n	}\r\n}\r\n```\r\n위 식의 결과는 맞음 입니다.\r\nequal은 변수의 값 자체를 비교합니다.\r\n맞는지 다른지를 알고 싶다면 == false 를 뒤에 붙이면 됩니다.'),
(14,1,4,0,5,'2021-01-20 00:30:35','2021-01-27 01:20:07',0,'자바 List','코딩을 하면서 객체를 배열에 담아 사용하는것은 많이 번거롭습니다.\r\n\r\n```java\r\npackage pra;\r\n\r\nimport java.util.ArrayList;\r\nimport java.util.List;\r\n\r\npublic class App {\r\n	Article article;\r\n	List<Article> articles;\r\n\r\n	public void App() {\r\n		article = new Article();\r\n		articles = new ArrayList<>();\r\n	}\r\n\r\n	public void run() {\r\n		Article[] article1 = new Article[5];\r\n\r\n		for (int i = 0; i < article1.length; i++) {\r\n			article1[i] = new Article();\r\n		}\r\n		article1[0].number = 1;\r\n		article1[0].title = \"가나다라\";\r\n\r\n		System.out.printf(\"번호 : %d, 이름 : %s\\n\", article1[0].number, article1[0].title);\r\n	}\r\n\r\n	public class Article {\r\n		private int number = 0;\r\n		private String title = \"\";\r\n	}\r\n}\r\n                                ---- 출력 결과 ----\r\n번호 : 1, 이름 : 가나다라\r\n```\r\n배열로 객체를 사용하려면 배열의 길이 지정뿐만 아니라\r\n배열의 중간을 삭제하게 된다면\r\n어느 부분이 비어있는지 연산한 뒤, 한 칸 씩 바꿔가며 삭제되어 비어진 부분을 넘겨야하고 또, \r\n```java\r\nfor (int i = 0; i < article1.length; i++) {\r\n	article1[i] = new Article();\r\n}\r\n```\r\n위 코드와 같이 선언 해준 뒤 사용한다고 다시 지정을 해야해서 코드가 길어지고 헷갈려집니다.\r\n\r\n그래서 List를 사용하는데 위를 List로 바꾸게 된다면\r\n\r\n```java\r\npackage pra;\r\n\r\nimport java.util.ArrayList;\r\nimport java.util.List;\r\n\r\npublic class App {\r\n	Article article;\r\n	List<Article> articles;\r\n\r\n	public void App() {\r\n		article = new Article();\r\n		articles = new ArrayList<>();\r\n	}\r\n\r\n	public void run() {\r\n		listAdd(1, \"홍길동\");\r\n\r\n	}\r\n\r\n	private void listAdd(int number, String title) {\r\n		article = new Article();\r\n		articles = new ArrayList<>();\r\n\r\n		article.number = 1;\r\n		article.title = \"홍길동\";\r\n\r\n		articles.add(article);\r\n\r\n		System.out.printf(\"번호 : %d, 이름 : %s\\n\", articles.get(0).number, articles.get(0).title);\r\n	}\r\n\r\n	public class Article {\r\n		private int number = 0;\r\n		private String title = \"\";\r\n	}\r\n}\r\n                                ---- 출력 결과 ----\r\n번호 : 1, 이름 : 홍길동\r\n```\r\n위와 같습니다. List는 값이 들어오면 순차적으로 쌓아주며 중간이 삭제된다고 해도\r\n정리를 해줍니다.\r\n\r\n값을 수정하고 싶다면\r\n\r\n```java\r\npackage pra;\r\n\r\nimport java.util.ArrayList;\r\nimport java.util.List;\r\n\r\npublic class App {\r\n	Article article;\r\n	List<Article> articles;\r\n\r\n	public void App() {\r\n		article = new Article();\r\n		articles = new ArrayList<>();\r\n	}\r\n\r\n	public void run() {\r\n		listAdd(1, \"홍길동\");\r\n		listModify(2, \"임꺽정\");\r\n		System.out.printf(\"리스트 갯수 = %d\", articles.size());\r\n	}\r\n\r\n	private void listAdd(int number, String title) {\r\n		article = new Article();\r\n		articles = new ArrayList<>();\r\n\r\n		article.number = 1;\r\n		article.title = \"홍길동\";\r\n\r\n		articles.add(article);\r\n\r\n		System.out.printf(\"번호 : %d, 이름 : %s\\n\", articles.get(0).number, articles.get(0).title);\r\n	}\r\n\r\n	private void listModify(int number, String title) {\r\n\r\n		article.number = number;\r\n		article.title = title;\r\n\r\n		articles.set(0, article);\r\n\r\n		System.out.printf(\"번호 : %d, 이름 : %s\\n\", articles.get(0).number, articles.get(0).title);\r\n	}\r\n\r\n	public class Article {\r\n		private int number = 0;\r\n		private String title = \"\";\r\n	}\r\n}\r\n                                ---- 출력 결과 ----\r\n번호 : 1, 이름 : 홍길동\r\n번호 : 2, 이름 : 임꺽정\r\n리스트 갯수 = 1\r\n```\r\nset을 사용하여 변경할 수 있습니다.\r\n\r\n삭제는 .remove(리스트번호)로 삭제할 수 있고\r\n값을 가져오는것은 get(리스트번호)로 값을 가져올 수 있습니다.'),
(15,1,6,0,0,'2021-01-21 00:05:28','2021-01-27 01:20:07',0,'JSP 커뮤니티 개발일지','블로그와 함께 JSP로 커뮤니티 사이트도 같이 만들어보고 있다.\r\n지금은 로그인,회원가입 등 기초적인 기능들 중점으로 하고 있어서\r\n디자인이 많이 촌스럽다. 손에 익으면 디자인도 점점 블로그와 같이 바꿔나가야겠다.\r\n컨셉은 지나가다 쉬어가는 휴게소 처럼 편안한 분위기로 만들고 싶다.\r\n글귀나 사진 또는 그림들 위주로 게시 됐으면 하는 바람!\r\n```youtube\r\n-ceyX2FjSUI\r\n```'),
(16,1,5,0,0,'2021-01-21 22:25:34','2021-01-27 01:20:06',0,'[자바 스크립트]현재 클릭된 요소 말고 다른부분이 클릭되면 remove 하기','자바 스크립트에서 특정 태그가 클릭 되면 addClass를 사용하여 이벤트를 걸어주는 경우가 많습니다.\r\n근데 onClick 은 있지만 offClick은 없습니다.\r\n이번에는 비슷하게 사용하는 코드를 가져왔습니다.\r\n\r\n```codepen\r\nhttps://codepen.io/hyeseong123/embed/gOwyXyP?height=655&theme-id=light&default-tab=css,result&editable=true\r\n```\r\n여기서 사용된 자바 스크립트는\r\nmouseenter : 마우스 진입 시에 이벤트가 발동됩니다.\r\nmouseleave: 마우스가 나갔을 때 이벤트가 발동됩니다.\r\n```js\r\n$(\'html\').click(function(e){\r\n  if(!$(e.target).hasClass(\'active\')){\r\n  $(\'.top-bar__form > input\').removeClass(\'active-hold\');\r\n   }\r\n});\r\n```\r\nhtml 전체에서 현재 클릭된 곳의 클래스를 검사하여 특정 클래스를 가지고 있지 않으면\r\n제거 합니다.\r\n인풋 박스를 클릭 했을 때 active-hold란 클래스가 추가되는데,\r\n만약 이 때 다른 곳을 클릭하면 active-hold 클래스가 없기 때문에 removeClass 시켜줍니다.\r\n'),
(17,1,5,0,0,'2021-01-27 00:56:42','2021-01-27 01:20:06',0,'input 안에 fontAwesome 넣기','검색칸을 만들다보면 아래 제출표시 대신 돋보기를 넣어야 하는 경우가 있습니다.\r\n```codepen\r\nhttps://codepen.io/hyeseong123/embed/oNzKZKK?height=650&theme-id=light&default-tab=css,result\r\n```\r\n\r\n예제2 같이 하시면 폰트어썸 첨부가 가능합니다.\r\n유니코드 형식 첨부라고 들었습니다.\r\n\r\n```\r\n<h1> 예제 1 </h1>\r\n<div class=\"form1\">\r\n  <form action=\"\">\r\n    <input type=\"text\" placeholder=\"검색어를 입력하세요\">\r\n    <input type=\"submit\" value=\"제출\">\r\n  </form>\r\n</div>\r\n```\r\n에서 value 부분을\r\n```\r\n<input type=\"submit\" value=\"&#xf002;\">\r\n```\r\n로 변경 하신 뒤 css에서\r\n```\r\n.form2 > form > input[type=\"submit\"]{\r\n  font-family: \"Font Awesome 5 Free\";\r\n  font-weight : 900;\r\n}\r\n```\r\n까지 추가 해주시면 첨부가 가능합니다.'),
(18,1,6,0,0,'2021-01-28 03:17:43','2021-01-28 03:17:44',0,'JSP 커뮤니티 개발일지-2','```youtube\r\njEdFYKn0kI8\r\n```'),
(19,1,7,0,0,'2021-01-28 03:31:38','2021-01-28 03:31:39',0,'SQL AUTO_INCREMENT 값 초기화','SQL을 하면서 AUTO_INCREMENT를 한 뒤 삭제를 하거나 강제로 중간에\r\n값을 주는 일이생기면 AUTO_INCREMENT는 제일 마지막 값부터 이어 나가게 됩니다.\r\n그 때\r\n```sql\r\nALTER TABLE `테이블명` AUTO_INCREMENT= num ;\r\n```\r\n를 해주신다면 원하는 값에서 이어 나가기가 가능합니다.');

/*Table structure for table `board` */

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
  `boardNum` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `name` varchar(100) NOT NULL,
  `code` varchar(100) NOT NULL,
  PRIMARY KEY (`boardNum`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

/*Data for the table `board` */

insert  into `board`(`boardNum`,`regDate`,`updateDate`,`name`,`code`) values 
(1,'2020-12-21 09:15:56','2020-12-21 09:15:56','Notice','공지사항'),
(2,'2020-12-21 09:16:13','2020-12-21 09:16:13','Study Record','공부게시판'),
(3,'2020-12-21 09:16:26','2020-12-21 09:16:26','Free','자유게시판'),
(4,'2020-12-28 17:22:39','2020-12-28 17:22:12','Java','공부게시판 - 자바'),
(5,'2020-12-28 20:07:07','2020-12-28 20:07:10','Web','공부게시판 - 웹'),
(6,'2020-12-29 08:00:14','2020-12-29 08:00:20','JSP','공부게시판 - JSP'),
(8,'2021-01-28 03:31:14','2021-01-28 03:31:16','SQL','공부게시판 - SQL');

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
) ENGINE=InnoDB AUTO_INCREMENT=4006 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `ga4DataPageHit` */

insert  into `ga4DataPageHit`(`num`,`regDate`,`updateDate`,`pagePath`,`hit`) values 
(337,'2021-01-06 23:58:10','2021-01-06 23:58:10','/7.html',1),
(598,'2021-01-07 10:17:15','2021-01-07 10:17:15','/8.html',2),
(738,'2021-01-07 23:17:35','2021-01-07 23:17:35','/2.html',2),
(739,'2021-01-07 23:17:35','2021-01-07 23:17:35','/5.html',2),
(1929,'2021-01-11 23:43:17','2021-01-11 23:43:17','/11.html',2),
(2924,'2021-01-18 00:03:34','2021-01-18 00:03:34','/article_detail_2.html',3),
(3525,'2021-01-21 22:40:45','2021-01-21 22:40:45','/article_detail_12.html',3),
(3975,'2021-01-23 02:27:44','2021-01-23 02:27:44','/loginPage.html',5),
(3996,'2021-01-27 01:20:15','2021-01-27 01:20:15','/',47),
(3997,'2021-01-27 01:20:15','2021-01-27 01:20:15','/article_list_Java_1.html',14),
(3998,'2021-01-27 01:20:15','2021-01-27 01:20:15','/article_list_Free_1.html',10),
(3999,'2021-01-27 01:20:15','2021-01-27 01:20:15','/article_list_Notice_1.html',10),
(4000,'2021-01-27 01:20:15','2021-01-27 01:20:15','/index.html',10),
(4001,'2021-01-27 01:20:15','2021-01-27 01:20:15','/article_list_Web_1.html',9),
(4002,'2021-01-27 01:20:15','2021-01-27 01:20:15','/article_search.html',7),
(4003,'2021-01-27 01:20:15','2021-01-27 01:20:15','/joinPage.html',6),
(4004,'2021-01-27 01:20:15','2021-01-27 01:20:15','/article_detail_14.html',5),
(4005,'2021-01-27 01:20:15','2021-01-27 01:20:15','/article_list_JSP_1.html',5);

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
