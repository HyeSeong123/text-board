/* 회원가입
    로그인
    로그인아이디 찾기
    비번 찾기
    회원탈퇴
    탈퇴한 회원의 로그인아이디는 다른 누군가가 가입할 때 사용금지
    1:1 쪽지

* 게시판
    관리자가 게시판 추가 가능
    게시글, 조회수, 추천수
    추천은 로그인한 사람만 가능하고, 중복추천금지
    댓글은 로그인 한 사람만 작성가능
    댓글 추천
    본문에 이미지와 비디오 첨부 가능
    
* 채팅방
    회원이 채팅방 생성가능
    로그인한 사람이면 채팅참여가능
    채팅방에 참여한 누구나 채팅가능
*/
DROP DATABASE IF EXISTS comm
CREATE DATABASE comm;
USE comm;

CREATE TABLE `member`(
    memberNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    loginId CHAR(30) NOT NULL UNIQUE,
    loginPw VARCHAR(200) NOT NULL,
    `name` CHAR(30) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `hpNum` VARCHAR(20) NOT NULL,
    authLevel TINYINT(1) NOT NULL DEFAULT 2 COMMENT '0:삭제 1:정지 2:일반 3:인증된 4:관리자'
);

CREATE TABLE `cMsg`(
    memberNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    senderMemberNum INT(10) UNSIGNED NOT NULL,
    receiverMemberNum INT(10) UNSIGNED NOT NULL,
    `body` LONGTEXT NOT NULL,
    checkDate DATETIME
);

CREATE TABLE `article`(
    articleNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    boardNum INT(10) UNSIGNED NOT NULL,
    memberNum INT(10) UNSIGNED NOT NULL,
    title CHAR(100) NOT NULL,
    `body` LONGTEXT NOT NULL,
    recommandNum INT(10) UNSIGNED NOT NULL,
    replyNum INT(10) UNSIGNED NOT NULL,
    hitsCount INT(10) UNSIGNED NOT NULL
);

CREATE TABLE `recommend`(
    recommendNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    memberNum INT(10) UNSIGNED NOT NULL,
    relTypeCode VARCHAR(30) NOT NULL,
    relNum INT(10) UNSIGNED NOT NULL,
    `point` TINYINT(1)
);

CREATE TABLE `reply`(
    replyNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    memberNum INT(10) UNSIGNED NOT NULL,
    relTypeCode VARCHAR(30) NOT NULL,
    relNum INT(10) UNSIGNED NOT NULL,
    `body` TEXT NOT NULL
);

CREATE TABLE chatRoom(
    charRoomNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    memberNum INT(10) UNSIGNED NOT NULL,
    title CHAR(100) NOT NULL
);

CREATE TABLE chatMsg(
    chatMsgNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    memberNum INT(10) UNSIGNED NOT NULL,
    chatRoomNum INT(10) UNSIGNED NOT NULL,
    `body` TEXT NOT NULL
);

CREATE TABLE chatRoomMember(
    chatRoomMemberNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    memberNum INT(10) UNSIGNED NOT NULL,
    chatRoomNum INT(10) UNSIGNED NOT NULL
);

CREATE TABLE `file`(
    fileNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    memberNum INT(10) UNSIGNED NOT NULL,
    relTypeCode VARCHAR(30) NOT NULL,
    relNum INT(10) UNSIGNED NOT NULL,
    originFileName VARCHAR(100) NOT NULL UNIQUE,
    fileExt VARCHAR(30) NOT NULL,
    typeCode VARCHAR(30) NOT NULL,
    type2Code VARCHAR(30) NOT NULL,
    fileSize INT(10) UNSIGNED NOT NULL,
    fileExtTypeCode VARCHAR(30) NOT NULL,
    fileExtType2Code VARCHAR(30) NOT NULL,
    fileNo INT(10) UNSIGNED NOT NULL,
    fileDir CHAR(20) NOT NULL
    delDate DATETIME,
    delStatus TINYINT(1) UNSIGNED DEFAULT (0)
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