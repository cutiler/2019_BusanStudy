CREATE TABLE test_board(
	bno int PRIMARY KEY auto_increment,
	title VARCHAR(200) NOT NULL,
	content text NOT NULL,
	writer VARCHAR(50) NOT NULL,
	regdate TIMESTAMP NOT NULL DEFAULT now(),
	viewcnt int DEFAULT 0
);

SELECT * FROM test_board;

INSERT INTO test_board(title,content,writer)
		VALUES('제목','내용','작성자');
		
SELECT * FROM test_board ORDER BY bno DESC;

INSERT INTO test_board(title,content, writer)
SELECT title, content, writer FROM test_board;

SELECT * FROM test_board ORDER BY bno DESC limit 0, 10;

SELECT COUNT(*) FROM test_board;

SELECT * FROM test_board ORDER BY bno DESC limit 0, 10;

UPDATE test_board SET viewcnt = viewcnt + 1 WHERE bno = 408;

DELETE from test_board WHERE bno = 404;