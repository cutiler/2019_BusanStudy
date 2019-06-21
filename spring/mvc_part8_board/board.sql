-- 답변형 게시판
CREATE TABLE re_tbl_board(
	bno INT PRIMARY KEY auto_increment,
	title VARCHAR(200) NOT NULL,
	content TEXT NOT NULL,
	writer VARCHAR(45) NOT NULL,	
	origin INT NULL DEFAULT 0,
	depth INT NULL DEFAULT 0,
	seq INT NULL DEFAULT 0,
	regdate TIMESTAMP NULL DEFAULT now(),
	updatedate TIMESTAMP NULL DEFAULT now(),
	viewcnt INT NULL DEFAULT 0,
	showboard VARCHAR(10) NULL DEFAULT 'y',
	uno INT NOT NULL
);

CREATE TABLE tbl_comment(
	cno INT PRIMARY KEY auto_increment,
	bno INT NOT NULL default 0,
	commentText TEXT NOT NULL,
	commentAuth VARCHAR(50) NOT NULL,
	regdate TIMESTAMP NOT NULL DEFAULT now(),
	updatedate TIMESTAMP NOT NULL DEFAULT now(),
	uno int not null default 1
	
	
);

ALTER TABLE tbl_comment ADD COLUMN uno int not null default 1 AFTER updatedate;

DELETE FROM tbl_comment;
commit

ALTER TABLE re_tbl_board add constraint fk_re_tbl_board_uno
FOREIGN KEY(uno) REFERENCES tbl_user(uno);

ALTER TABLE tbl_comment add constraint fk_tbl_comment_bno
FOREIGN KEY(bno) REFERENCES re_tbl_board(bno);

DESC tbl_comment;

-- 첨부파일
CREATE TABLE tbl_attach(
	fullname VARCHAR(200) NOT NULL,
	bno INT NOT NULL,
	regdate TIMESTAMP NULL default now(),
	constraint fk_tbl_attach FOREIGN KEY(bno) REFERENCES re_tbl_board(bno)
);

SELECT * FROM tbl_user;













