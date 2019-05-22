-- alt + x, alt + c
SELECT * FROM SCOTT.DEP;

CREATE TABLE member(
	num NUMBER,
	name VARCHAR2(50),
	addr VARCHAR2(300)	
);

CREATE SEQUENCE m_num increment by 1 start with 1;

SELECT * FROM member;

INSERT INTO member(num,name,addr)VALUES(m_num.nextval,'홍길동','서울');

SELECT * FROM member;

SELECT * FROM member;