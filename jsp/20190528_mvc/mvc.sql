-- 회원관련

CREATE TABLE mvc_member(
	num NUMBER(10) PRIMARY KEY,
	id VARCHAR2(30) UNIQUE,
	pass VARCHAR2(30) NOT NULL,
	name VARCHAR2(20),
	age NUMBER(3),
	gender VARCHAR2(10),
	regdate DATE default sysdate,
	updatedate DATE default sysdate
);

CREATE SEQUENCE m_num_seq start with 0 increment by 1 minvalue 0 nocache;

INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'admin','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y21@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y22@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y23@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y24@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y25@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y26@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y27@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y28@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y29@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y210@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y211@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y212@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y213@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y214@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y215@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y216@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y217@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y218@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y219@nate.com','admin','최기근',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval,'hap0p9y220@nate.com','admin','최기근',20,'male');

SELECT * FROM mvc_member;

SELECT * FROM mvc_member WHERE num >= 11 AND num <= 20;

SELECT * FROM
	(SELECT ROWNUM AS rnum, TEMP.* FROM
		(SELECT * FROM mvc_member ORDER BY num ASC) 
	TEMP)
WHERE rnum >= 11 AND rnum <= 20 ORDER BY num DESC;


SELECT * FROM
	(SELECT ROWNUM AS rnum, TEMP.* FROM
		(SELECT * FROM mvc_member ORDER BY num DESC) 
	TEMP)
WHERE rnum between 1 AND 20;

SELECT ROWNUM AS rnum, TEMP.* FROM
	(SELECT * FROM mvc_member ORDER BY num DESC) 
TEMP;









SELECT * FROM mvc_member;

DELETE FROM mvc_member WHERE id != 'admin';

CREATE TABLE test_code(
	id VARCHAR2(30),
	code char(5)
);

SELECT * FROM test_code;

-- 공지용 게시판  notice_board
CREATE TABLE notice_board(
	notice_num NUMBER primary key,
	notice_category VARCHAR2(20),
	notice_author VARCHAR2(50),
	notice_title VARCHAR2(50),
	notice_content VARCHAR2(3000),
	notice_date DATE	
);

CREATE SEQUENCE notice_board_seq increment by 1 minvalue 0 start with 0;

INSERT INTO notice_board
VALUES(notice_board_seq.nextval,'공지','운영자','장난입니다.','내용이 없습니다.내용이 없습니다.',sysdate);
INSERT INTO notice_board 
VALUES(notice_board_seq.nextval,'공지','최기근','장난입니다.','내용이 없습니다.내용이 없습니다.',sysdate);
INSERT INTO notice_board 
VALUES(notice_board_seq.nextval,'공지','admin','장난입니다.','내용이 없습니다.내용이 없습니다.',sysdate);

SELECT * FROM notice_board;


CREATE TABLE qna_board(
	board_num NUMBER PRIMARY KEY,    		-- 글번호
	board_name VARCHAR2(20) NOT NULL,		-- 작성자
	board_pass VARCHAR2(50) NOT NULL,		-- 비밀번호
	board_title VARCHAR2(50) NOT NULL,		-- 글제목
	board_content VARCHAR2(2000) NOT NULL,  -- 글내용
	board_file VARCHAR2(50),				-- 파일 이름
	board_file_origin VARCHAR2(50),			-- 원본파일 이름
	board_re_ref NUMBER NOT NULL,			-- 원본 글 번호
	board_re_lev NUMBER NOT NULL,			-- 답변글 뷰 번호
	board_re_seq NUMBER NOT NULL,			-- 답변글 정렬 번호
	board_readcount	NUMBER default 0,		-- 조회 수
	board_date DATE							-- 작성 시간
);

CREATE SEQUENCE qna_board_seq 
increment by 1 
start with 0
minvalue 0
nocache;


SELECT * FROM qna_board ORDER BY board_num DESC;

INSERT INTO qna_board VALUES(qna_board_seq.nextval,'최기근','12345','게시물입니다.','내용입니다.','','',qna_board_seq.currval,0,0,0,sysdate);

INSERT INTO qna_board VALUES(qna_board_seq.nextval,'최기근','12345','게시물입니다.','내용입니다.','','',1,1,1,0,sysdate);


SELECT * FROM qna_board ORDER BY board_re_ref DESC , board_re_seq ASC;

INSERT INTO qna_board VALUES(qna_board_seq.nextval,'최기근','12345','9번글의 답변.','9번글의 답변 내용입니다.','','',1,2,2,0,sysdate);


















