
--id / pass / name / addr / phone
DROP TABLE test_member PURGE;

CREATE TABLE test_member(
	num NUMBER primary key,
	id VARCHAR2(30) UNIQUE,	
	pass VARCHAR2(30),
	name VARCHAR2(30),
	addr VARCHAR2(30),
	phone VARCHAR2(30)
);

DROP SEQUENCE test_member_seq;

CREATE SEQUENCE test_member_seq start with 0 increment by 1 minvalue 0;

INSERT INTO test_member(num,id,pass,name,addr,phone)
VALUES(test_member_seq.nextval,'admin','admin','blank','blank','blank');

SELECT * FROM test_member;