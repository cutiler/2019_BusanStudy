CREATE TABLE tbl_memer(
	userid VARCHAR(50) NOT NULL,
	userpw VARCHAR(50) NOT NULL,
	username VARCHAR(50) NOT NULL,
	regdate DATE NULL,
	updatedate DATE null
);

RENAME TABLE tbl_memer to tbl_member;

SELECT * FROM tbl_member;