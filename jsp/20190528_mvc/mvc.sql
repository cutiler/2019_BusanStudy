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

INSERT INTO test_code VALUES('maile@mail','code12212');