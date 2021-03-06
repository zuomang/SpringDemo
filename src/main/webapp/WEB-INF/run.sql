show tables;

create table if not exists T_USERS (
	ID INT PRIMARY KEY AUTO_INCREMENT,
	USERNAME VARCHAR(40) UNIQUE NOT NULL,
	EMAIL VARCHAR(40) UNIQUE NOT NULL,
	PASSWORD CHAR(32) NOT NULL,
	CREATE_TIME DATETIME NOT NULL,
	UPDATE_TIME TIMESTAMP NOT NULL
);

CREATE TABLE `T_ALL_QUESTION_LIBRARY` (
  `ID` tinyint(4) NOT NULL AUTO_INCREMENT,
  `CONTENT` varchar(250) NOT NULL,
  `COUNT_CHOICE` smallint(6) NOT NULL DEFAULT 0,
  `COUNT_OPINION` smallint(6) NOT NULL DEFAULT 0,
  `TITLE` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into test.T_ALL_QUESTION_LIBRARY (ID, CONTENT, COUNT_CHOICE, COUNT_OPINION, TITLE)
select ID, CONTENT,COUNT_CHOICE,COUNT_OPINION,TITLE from back.T_ALL_QUESTION_LIBRARY;
