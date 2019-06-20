CREATE TABLE tbl_user(
	uno int PRIMARY KEY auto_increment,
	uid VARCHAR(50) NOT NULL unique,
	upw VARCHAR(50) NOT NULL,
	uname VARCHAR(50) NOT NULL,
	upoint int NOT NULL default 0
);

CREATE TABLE tbl_message(
	mno int PRIMARY KEY auto_increment,
	targetid VARCHAR(50) NOT NULL,
	sender VARCHAR(50) NOT NULL,
	message text NOT NULL,
	opendate TIMESTAMP,
	senddate TIMESTAMP NOT NULL default now()
);

DROP TABLE tbl_user;
DROP TABLE tbl_message;


ALTER TABLE tbl_message add constraint fk_user_targetid 
FOREIGN KEY(targetid) REFERENCES tbl_user(uid); 

ALTER TABLE tbl_message add constraint fk_user_sender 
FOREIGN KEY(sender) REFERENCES tbl_user(uid); 

INSERT INTO tbl_user(uid,upw,uname) 
VALUES('id001','id001','IRON MAN');

INSERT INTO tbl_user(uid,upw,uname) 
VALUES('id002','id002','THOR');

INSERT INTO tbl_user(uid,upw,uname) 
VALUES('id003','id003','Dr.strange');

SELECT * FROM tbl_user;

-----------------------------------------------------

INSERT INTO tbl_message(targetid,sender,message) 
VALUES('id001','id002','안녕하세요... 대출 이자가 체납되었....');

UPDATE tbl_user 
SET upoint = upoint + 10 WHERE uid = 'id002';

------------------------------------------------------

UPDATE tbl_message  
SET opendate = now() 
WHERE targetid = 'id001';

UPDATE tbl_user 
SET upoint = upoint + 5 WHERE uid = 'id001';

-------------------------------------------------------

SELECT * FROM tbl_user;

SELECT * FROM tbl_message;

















