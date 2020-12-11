USE a1;

DROP TABLE article;
CREATE TABLE article(
    num INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    views INT(10) UNSIGNED NOT NULL,
    replyNum INT(10) UNSIGNED NOT NULL,
    memberNum INT(10) UNSIGNED NOT NULL,
    boardNum INT(10) UNSIGNED NOT NULL,
    recommandNum INT(10) UNSIGNED NOT NULL,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    title VARCHAR(100) NOT NULL,
    `body` TEXT NOT NULL
);
DESC article;
SELECT * FROM article;

DROP TABLE `Member`;
CREATE TABLE `Member`(
    memberNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `id` VARCHAR(100) NOT NULL,
    `password` VARCHAR(100) NOT NULL
);
INSERT INTO `Member`
SET memberNum = 999,
regDate = NOW(),
`name` = '방혜성',
`id` = 'admin',
`password` = 'admin123';

SELECT article.* , `Member`.name AS extra__writer, board.name extra__board
FROM article
    INNER JOIN `Member`
    ON article.memberNum = Member.memberNum
    INNER JOIN board
    ON article.boardNum = board.boardNum;
DESC `Member`;
SELECT * FROM `Member`;

DROP TABLE board;
CREATE TABLE board(
    boardNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `code` VARCHAR(20) NOT NULL
);
DESC `board`;
SELECT * FROM `board`;

DROP TABLE Reply;
CREATE TABLE Reply(
    replyNum INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    articleNum INT(10) UNSIGNED NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    `body` TEXT NOT NULL
);
DESC Reply;
SELECT * FROM Reply;

DROP TABLE Recommand;

CREATE TABLE Recommand(
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    memberId INT(10) UNSIGNED NOT NULL,
    articleId INT(10) UNSIGNED NOT NULL
);
DESC Recommand;
SELECT * FROM Recommand;
