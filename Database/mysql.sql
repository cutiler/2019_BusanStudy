CREATE TABLE test(
	num INT primary key auto_increment,
    id VARCHAR(50),
    pw VARCHAR(50),
    content TEXT
);

INSERT INTO test(id,pw,content)
VALUES('test','test','장문입니다~~~~~~~~~~~~~~~~~~~~');

SELECT * FROM test;

SELECT * FROM test WHERE ORDER BY num DESC limit 0, 10;