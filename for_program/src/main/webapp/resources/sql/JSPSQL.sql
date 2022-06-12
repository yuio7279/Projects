drop schema if exists `jspsql`;
CREATE SCHEMA `jspsql` ;

CREATE TABLE `jspsql`.`membertbl` (
  `mID` VARCHAR(45) NOT NULL,			-- 아이디, 기본키
  `mPW` VARCHAR(45) NOT NULL,			-- 비밀번호
  `mName` VARCHAR(45) NOT NULL,			-- 회원명
  `mTel` VARCHAR(45) NOT NULL,			-- 연락처
  `mMail` VARCHAR(45) NULL,				-- 이메일
  `mAddress` VARCHAR(45) NULL,			-- 주소
  `mText` VARCHAR(100) NULL,			-- ??
  `mSkill` VARCHAR(100) NULL,			-- 기술 스택
  PRIMARY KEY (`mID`));

CREATE TABLE `jspsql`.`posttbl` (
  `pID` VARCHAR(45) NOT NULL,			-- 포스터아이디, 기본키
  `pTitle` VARCHAR(45) NOT NULL,		-- 제목
  `pWriter` VARCHAR(45) NOT NULL,		-- 글쓴이, 외래키
  `pPrice` VARCHAR(45) NOT NULL,		-- 가격
  `pText` TEXT(10000) NOT NULL,			-- 포스팅 글
  `pSkill` VARCHAR(45) NULL,			-- 포스터 기술 스택
  PRIMARY KEY (`pID`),
  FOREIGN KEY (pWriter) REFERENCES membertbl(mID) ON UPDATE CASCADE ON delete cascade
  );
  
  
  