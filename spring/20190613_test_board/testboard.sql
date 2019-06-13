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
		VALUES('title','test','ttt');