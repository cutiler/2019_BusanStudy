
CREATE TABLE board_test(
	b_num NUMBER PRIMARY KEY,
	b_auth VARCHAR2(50),
	b_contend VARCHAR2(300)
);

ALTER TABLE board_test RENAME COLUMN b_contend TO b_content;

CREATE SEQUENCE b_num_seq start with 0 increment by 1 minvalue 0;

INSERT INTO board_test VALUES(b_num_seq.nextval,'최초작성자','냉무');
INSERT INTO board_test VALUES(b_num_seq.nextval,'두번째작성자','냉무2');

SELECT * FROM board_test;

SELECT rownum AS r, board.* FROM
(SELECT * FROM board_test ORDER BY b_num ASC) board
ORDER BY r DESC;