DROP DATABASE IF EXISTS jspCommunity;
CREATE DATABASE jspCommunity;
USE jspCommunity;

CREATE TABLE article(
    num INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    memberNum INT(10) UNSIGNED NOT NULL,
    boardNum INT(10) UNSIGNED NOT NULL,
    title CHAR(100) NOT NULL,
    `body` LONGTEXT NOT NULL,
    views INT(10) UNSIGNED NOT NULL
);

CREATE TABLE board(
    boardNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    `code` CHAR(10) NOT NULL UNIQUE,
    `name` CHAR(10) NOT NULL UNIQUE
);

CREATE TABLE `member`(
    memberNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    `name` CHAR(50) NOT NULL,
    `nickname` CHAR(50) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    loginId CHAR(50) NOT NULL UNIQUE,
    loginPw VARCHAR(200`member`) NOT NULL,
    adminLevel TINYINT(2) UNSIGNED NOT NULL DEFAULT 2 COMMENT '등록자 코멘트: 0= 탈퇴/1=정지회원/2=일반/3=인증된회원/4관리자'
);
# adminLevel(0 = 탈퇴, 1= 정지회원, 2= 일반, 3= 인증된 회원, 4관리자)

#회원1 생성
INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
`name` = "홍길동",
nickname = "의적홍길동",
email = "banggu1997@gamil.com",
loginId = "baobab612",
loginPw = "baobab0612"

#회원2 생성
INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
`name` = "홍길순",
nickname = "홍길동동생",
email = "banggu1997@gamil.com",
loginId = "hong",
loginPw = "hong"

#공지사항 생성
INSERT INTO board
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'notice',
`name` = '공지사항';

#방명록 생성
INSERT INTO board
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'guestBook',
`name` = '방명록';

#공지사항 생성
INSERT INTO board
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'Free',
`name` = '자유게시판';

#게시물1 생성
INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
memberNum = 1,
boardNum = 1,
`views` = 0,
title = "제목1",
`body` = "내용1"

#게시물2 생성
INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
memberNum = 1,
boardNum = 1,
`views` = 0,
title = "제목2",
`body` = "내용2"

#게시물3 생성
INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
memberNum = 1,
boardNum = 1,
`views` = 0,
title = "제목3",
`body` = "내용3"

/* 시험 범위 */
DROP DATABASE comm;
CREATE DATABASE comm;
USE comm;

CREATE TABLE `member`(
    memberNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    `name` CHAR(30) NOT NULL,
    loginId CHAR(30) NOT NULL UNIQUE,
    loginPw VARCHAR(200) NOT NULL UNIQUE,
    `email` CHAR(100) NOT NULL,
    hpNum CHAR(20) NOT NULL,
    authLevel TINYINT(1) UNSIGNED NOT NULL
);

CREATE TABLE `cMsg`(
    msgNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    senderId INT(10) UNSIGNED NOT NULL,
    receiverId INT(10) UNSIGNED NOT NULL,
    content TEXT NOT NULL,
    receiveDate DATETIME
);

CREATE TABLE board(
    boardNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    `name` CHAR(30) NOT NULL UNIQUE,
    `code` CHAR(30) NOT NULL UNIQUE
);

CREATE TABLE article(
    articleNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    boardNum INT(10) UNSIGNED NOT NULL,
    memberNum INT(10) UNSIGNED NOT NULL,
    title CHAR(100) NOT NULL,
    `body` LONGTEXT NOT NULL,
    recommendNum INT(10) UNSIGNED NOT NULL,
    hitsCount INT(10) UNSIGNED NOT NULL
);

CREATE TABLE reply(
    replyNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    memberNum INT(10) UNSIGNED NOT NULL,
    `relNum` INT(10) UNSIGNED NOT NULL,
    `relTypeCode` VARCHAR(30) NOT NULL,
    `body` TEXT NOT NULL
);

CREATE TABLE recommend(
    recommendNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    memberNum INT(10) UNSIGNED NOT NULL,
    `relNum` INT(10) UNSIGNED NOT NULL,
    `relTypeCode` VARCHAR(30) NOT NULL,
    `point` TINYINT(1)
);

CREATE TABLE `file` (
    fileNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    memberNum INT(10) UNSIGNED  NOT NULL,
    relTypeCode CHAR(30) NOT NULL,
    relNum INT(10) UNSIGNED NOT NULL,
    originalFileName VARCHAR(100) NOT NULL, # 원본 파일 이름
    fileExt CHAR(10) NOT NULL, # 파일 확장자
    typeCode CHAR(20) NOT NULL, # 파일 종류 예)이미지 pdf 등등
    type2Code CHAR(20) NOT NULL, # 파일 세부 종류 예)이미지=jpg,png 비디오 = mp4, avi
    fileSize INT(10) UNSIGNED NOT NULL, # 파일 크기
    fileExtTypeCode CHAR(10) NOT NULL, 
    fileExtType2Code CHAR(10) NOT NULL,
    fileNo TINYINT(2) UNSIGNED NOT NULL, # 파일 번호
    fileDir CHAR(20) NOT NULL, # 파일의 저장 경로
    delDate DATETIME, 
    delStatus TINYINT(1) UNSIGNED NOT NULL DEFAULT 0
);

CREATE TABLE `chatRoom`(
    chatRoomNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    memberNum INT(10) UNSIGNED NOT NULL,    
    title CHAR(100) NOT NULL,
    delDate DATETIME,
    delStatus TINYINT(1) UNSIGNED NOT NULL DEFAULT 0
);

CREATE TABLE `chatMessage`(
    chatMsgNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    memberNum INT(10) UNSIGNED NOT NULL,
    chatRoomNum INT(10) UNSIGNED NOT NULL,
    `body` TEXT NOT NULL
);

CREATE TABLE `chatRoomMember` (
    chatMemberNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    memberNum INT(10) UNSIGNED NOT NULL, 
    chatRoomNum INT(10) UNSIGNED NOT NULL 
);