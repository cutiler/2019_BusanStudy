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
VALUES(m_num_seq.nextval, 'admin','admin','관리자',20,'male');

SELECT * FROM mvc_member;

CREATE TABLE test_code(
	id VARCHAR2(30),
	code char(5)
);

INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval, 'test01','test','테스트',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval, 'test02','test','테스트',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval, 'test03','test','테스트',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval, 'test04','test','테스트',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval, 'test05','test','테스트',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval, 'test06','test','테스트',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval, 'test07','test','테스트',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval, 'test08','test','테스트',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval, 'test09','test','테스트',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval, 'test10','test','테스트',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval, 'test11','test','테스트',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval, 'test12','test','테스트',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval, 'test13','test','테스트',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval, 'test14','test','테스트',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval, 'test15','test','테스트',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval, 'test16','test','테스트',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval, 'test17','test','테스트',20,'male');
INSERT INTO mvc_member(num,id,pass,name,age,gender)
VALUES(m_num_seq.nextval, 'test18','test','테스트',20,'male');

SELECT * FROM mvc_member;

SELECT * FROM mvc_member WHERE num >= 1 AND num <= 10;

SELECT * FROM
	(SELECT ROWNUM AS rnum, TEMP.* FROM
		(SELECT * FROM mvc_member ORDER BY num DESC) 
	TEMP)
WHERE rnum >= 11 AND rnum <= 20 ORDER BY num DESC;

SELECT * FROM 
	(SELECT ROWNUM AS rnum, TEMP.* FROM 
		(SELECT * FROM mvc_member ORDER BY num DESC) 
	TEMP) 
WHERE between  1 AND 20 ORDER BY num DESC;


SELECT ROWNUM AS rnum, TEMP.* FROM 
		(SELECT * FROM mvc_member ORDER BY num DESC) 
TEMP;

-- 공지용 게시판 notice_board
CREATE TABLE notice_board(
	notice_num NUMBER primary key,
	notice_category VARCHAR2(20),
	notice_author VARCHAR2(50),
	notice_title VARCHAR2(50),
	notice_content VARCHAR2(3000),
	notice_date DATE
);

CREATE SEQUENCE notice_board_seq increment by 1 minvalue 0 start with 0;

INSERT INTO notice_board VALUES(notice_board_seq.nextval, '공지', 'admin', '장난입니다.','내용이 없습니다.내용이 없습니다.내용이 없습니다.내용이 없습니다.내용이 없습니다.',sysdate);

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

INSERT INTO qna_board VALUES(qna_board_seq.nextval,'테스트','12345','게시물입니다.','내용입니다','','',qna_board_seq.currval,0,0,0,sysdate);

INSERT INTO qna_board VALUES(qna_board_seq.nextval,'테스트','12345','게시물입니다.','내용입니다','','',1,1,1,0,sysdate);

SELECT * FROM qna_board ORDER BY board_re_ref DESC , board_re_seq ASC;

INSERT INTO qna_board VALUES(qna_board_seq.nextval,'테스트','12345','9번글의 답변.','9번글 답변 내용입니다','','',1,2,2,0,sysdate);



