-- alt + x, alt + c
SELECT * FROM tab;

DROP TABLE tbl_book PURGE;

CREATE TABLE tbl_book(
	num NUMBER(8),
	title VARCHAR2(300),
	author VARCHAR2(300),
	regdate DATE,
	CONSTRAINT tbl_book_pk PRIMARY KEY(num)
);

CREATE SEQUENCE book_seq
INCREMENT BY 1
START WITH 1;

INSERT INTO tbl_book VALUES(book_seq.nextval,'DOit 자바프로그래밍','미상',sysdate);

SELECT * FROM tbl_book;

commit

SELECT * FROM tbl_book;

SELECT ROWNUM AS rnum, tbl_book.* FROM tbl_book ORDER BY num DESC;

-- 

SELECT ROWNUM AS rnum, num, title, author, regdate FROM tbl_book WHERE num = 3;

SELECT A.rnum, num, title, author, regdate FROM
(SELECT ROWNUM AS rnum, tbl_book.* FROM tbl_book ORDER BY rnum DESC) A
WHERE num = 3;