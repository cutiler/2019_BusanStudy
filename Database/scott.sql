-- Ctrl + enter
DESC ENROL;

SELECT * FROM ENROL;

DESC subject;

SELECT * FROM scott.subject;

-- student table 에서 stu_no, stu_name 열 정보만 확인

SELECT stu_no, stu_name FROM student ORDER BY stu_no;

-- student 테이블에서 dept 정보만 조회
DESC student;

SELECT stu_dept FROM student;

-- 중복 제외
SELECT DISTINCT stu_dept FROM student;

SELECT stu_grade, stu_class FROM student;

SELECT DISTINCT stu_grade, stu_class FROM student;

-- 연산자
SELECT stu_no, sub_no, enr_grade FROM enrol;

SELECT stu_no, sub_no, enr_grade+10 FROM enrol;

-- 별칭 AS
SELECT stu_no AS 학번, stu_name AS 이름 FROM student;

-- 연결 연산자 ||
SELECT stu_dept || stu_name AS 학과성명 FROM student;

SELECT stu_dept ||','|| stu_name || '입니다.' AS 학과성명 FROM student;

-- 검색 조건 WHERE(>, >=, <, <=, =,  <>, != , ^=)

SELECT stu_name, stu_dept, stu_grade, stu_class
FROM student
WHERE stu_dept = '컴퓨터정보';

SELECT stu_name, stu_height
FROM student
WHERE stu_height > 170;

SELECT stu_name, stu_height
FROM student
WHERE stu_height <= 180;

-- 조건에 논리 연산자 추가 (NOT AND OR)

SELECT stu_name, stu_dept, stu_grade, stu_class
FROM student
WHERE stu_dept = '컴퓨터정보' OR stu_dept = '전기전자';

SELECT stu_name, stu_dept, stu_grade, stu_class
FROM student
WHERE stu_dept = '컴퓨터정보' AND stu_grade=2;

SELECT stu_name, stu_height
FROM student
WHERE stu_height >= 170 AND stu_height <= 180;

== Betweeen ~ AND ~
SELECT stu_name, stu_height
FROM student
WHERE stu_height BETWEEN 170 AND 180;

SELECT * FROM student
WHERE stu_no BETWEEN '20140001' AND '20149999';

-- like
SELECT * FROM student
WHERE stu_no LIKE '2014%';

SELECT * FROM student
WHERE stu_name LIKE '유%';

SELECT * FROM student
WHERE stu_name LIKE '유%'
OR stu_name LIKE '심%';

-- _ 한글자를 포함

SELECT * FROM student
WHERE stu_name LIKE '옥%'
AND stu_name LIKE '_한%';

-- IN 연산자. OR 연산자

SELECT * FROM student
WHERE stu_dept IN('컴퓨터정보','기계');

-- null
SELECT stu_name, stu_height/10 AS average 
FROM student;

-- is null 해당 속성값이 null인 튜플
SELECT stu_no, stu_name, stu_height
FROM student
WHERE stu_height IS NULL;

- is not null
SELECT stu_no, stu_name, stu_height
FROM student
WHERE stu_height IS NOT NULL;

-- ORDER BY - ASC, 오름차순 - 생략가능.
-- ORDER BY - DESC 내림차순

SELECT stu_no, stu_name
FROM student
ORDER BY stu_no;

SELECT stu_no, stu_name
FROM student
ORDER BY stu_no DESC;

SELECT stu_no, stu_name AS 이름 FROM student
ORDER BY 이름 DESC;

SELECT stu_no, stu_name, stu_dept, stu_weight AS 몸무게
FROM student
ORDER BY stu_dept, 몸무게 DESC;

-- dual <-- dummy table sys가 제공해주는 임시테이블
--함수
-- 숫자함수

SELECT round(123456.45) From dual;
SELECT round(123456.45,2) From dual;

SELECT 
round(123456.45),
round(123456.45,-1),
round(123456.45,2),
round(123456.45,3),
round(123456.1567,2)
FROM dual;

-- 나머지를 반환하는 mod
SELECT mod(30,7) FROM dual;

-- 소수점 자리를 버리는 floor
SELECT floor(123456.1234) FROM dual;

-- student 테이블 반올림
SELECT stu_no, stu_name, stu_height, round(stu_height, -1) AS round
FROM student WHERE stu_height IS NOT NULL;

-- 문자 함수
SELECT LOWER('HELLO ORACLE') FROM dual;

SELECT UPPER('Hello World') FROM dual;

-- 첫글자를 대문자로 지정
SELECT INITCAP('hello world') FROM dual;

-- 문자열을 이어주는 함수
SELECT concat('Hello','World') FROM dual;

-- 문자열을 자라는 substr
SELECT substr('Hello World',7,5) FROM dual;
SELECT substr('Hello World',1,5) FROM dual;

SELECT substr('안녕하세요 반가워요',1,5) FROM dual;
SELECT substr('안녕하세요 반가워요',7,4) FROM dual;

-- 문자열의 길이 반환
SELECT length('Hello world') FROM dual;

-- 특정 문자의 절대 위치를 반환 instr
-- instr(검색할 문자열, 찾을 문자열, 검색 시작위치, 검색시 순서)
SELECT instr('Hello world','o') FROM dual;

SELECT instr('hello world', 'o',1,2) FROM dual;

-- 검색 범위에서 벗어나 결과값을 찾을 수 없음. 0반환
SELECT instr('hello world', 'o',0,2) FROM dual;

-- 빈공간을 채워 주는 함수 LPAD, RPAD
SELECT lpad('hello world',15,'$') FROM dual;
SELECT rpad('hello world',15,'&') FROM dual;
SELECT lpad(123,20,0) FROM dual;


-- 날짜 함수
-- 시스템의 현재 시간을 반환
 SELECT sysdate FROM dual;
 
 alter session set nls_date_format = 'yyyy-mm-dd HH:MI:ss';
 alter session set nls_date_format = 'yyyy-mm-dd HH24:MI:ss';
 
 --날짜 연산, 별칭 쌍따움표 안의 문자는 대소문자 구별.
SELECT
    sysdate+1 AS 하루더하기,
    sysdate+(1/24) "1시간 더하기",
    sysdate+((1/24)/60) "1분 더하기",
    sysdate+(((1/24)/60)/60) "1초 더하기"
FROM dual;

-- 날짜와 날짜 사이의 개월 수를 반환.
SELECT months_between(sysdate, sysdate+31) FROM dual;

SELECT MONTHS_BETWEEN(SYSDATE+31, SYSDATE) FROM dual;

-- 해당 날짜 기준으로 명시된 요일에 해당하는 날짜를 같는 함수 NEXT_DAY
-- 1 : 일요일 2: 월요일 3: 화 4: 수 5: 목 6: 금 7: 토
-- '일'        '월'..........

SELECT next_day(sysdate,2) FROM dual;

SELECT next_day(sysdate,'월') FROM dual;
SELECT next_day(sysdate,'수') FROM dual;

-- 특정 개월 수를 더한 날짜를 반환하는 함수 add_months
SELECT
sysdate,
add_months(sysdate,1) add_months,
add_months(sysdate,-1) add_months2
FROM dual;

-- 월의 절반 날짜를 이용해서 첫째날과 마지막 날을 알려주는 반올림 함수 round
SELECT round(sysdate-2, 'MON') FROM dual;
SELECT round(sysdate, 'YEAR') FROM dual;
SELECT round(sysdate, 'DAY') FROM dual;

SELECT sysdate FROM dual;

-- 날짜 절삭해서 첫째날. trunc
SELECT TRUNC(sysdate, 'MON') FROM dual;

-- 변환함수
-- to_number 와 to_char
SELECT to_char(1) FROM dual;


SELECT to_char(to_number('1234.5678'),'9999.9999') FROM dual;
-- 정수 자리가 맞지 않을 시에는 에러 표현
SELECT to_char(to_number('1234.5678'),'999.9999') FROM dual;
-- 소수점 이하 자리는 반올림 해서표현
SELECT to_char(to_number('1234.5678'),'9999.999') FROM dual;

DESC emp;

SELECT empno, ename, sal FROM emp;

SELECT empno, ename, to_char(sal,'$999') FROM emp;

SELECT empno, ename, to_char(sal,'L9,999') FROM emp;
SELECT empno, ename, concat(to_char(sal,'09,999'),'만원') FROM emp;
SELECT empno, ename, concat(to_char(sal,'L09,999'),'만') FROM emp;

-- to_date
-- 날짜 형태의 문자를 날짜로 변환 할때 사용

SELECT * FROM emp;
DESC emp;

-- 묵시적 형 변환.
SELECT empno, ename
FROM emp
WHERE hiredate = '1980-12-17';

SELECT empno, ename
FROM emp
WHERE hiredate = to_date('1980-12-17','yy-mm-dd');

-- 일반 함수
-- nvl 첫번째 인자값이 널값인지 체크하여 
-- 연산이 가능한 값(두번째 인자값)으로 반환하여 반환하는 함수.

SELECT nvl(MGR,0) FROM emp;

-- nvl2(인수1,인수2,인수3)
-- 인수1값이 널null 아니면 인수2, null이면 인수3 을 반환,.
SELECT ename, comm, sal, nvl2(comm, sal+comm, sal)
FROM emp;

SELECT ename, comm, sal, nvl2(comm, to_char(sal+comm, '$99,999'), to_char(sal, '$99,999'))
FROM emp;

SELECT ename,comm,sal,
to_char(nvl2(comm,sal+comm,sal),'$99,999') AS 지급액
FROM emp;

SELECT ename, comm, sal, sal+comm FROM emp;

-- nullif(인자1, 인자2)
-- 인자1과 인자 2가 동일하면 널값을 반환

SELECT nvl(nullif('A','A'),'널입니다.')
FROM dual;

SELECT nvl(nullif('A','B'),'널입니다.' )
FROM dual;

SELECT COALESCE(null,null,null,100,10,null,null) FROM dual;

-- CASE 속성 WHEN ~ THEN ~ else END;

SELECT * FROM emp;

SELECT empno, ename, job, sal,
    CASE job WHEN 'SALESMAN' THEN sal * 1.1
             WHEN 'CLERK'    THEN sal * 1.15
             WHEN 'MANAGER' THEN sal * 1.2
             else sal
    END AS 급여인상
FROM emp;

-- DECODE
SELECT empno, ename, job, sal,
    DECODE(job,'SALESMAN',sal*1.1,
                'CLERK', sal*1.15,
                'MANEGER',sal*1.2,
                sal) AS 급여인상
FROM emp;

-- 그룹 함수
-- 여러행에 대한 연산의 결과값을 반환하는 함수

-- MIN, MAX

SELECT max(sal), MIN(sal)
FROM emp;

SELECT max(nvl2(comm,sal+comm,sal)), MIN(nvl2(comm,sal+comm,sal))
FROM emp;

SELECT max(nvl2(comm,sal+comm,sal)), MIN(sal)
FROM emp
WHERE job = 'SALESMAN';

-- 행의 개수를 반환하는 count
SELECT count(*),count(ALL comm) FROM emp;
SELECT * FROM emp;

-- distinct 중복제외
SELECT count(job), count(distinct job) FROM emp;

-- sum(), avg()
-- job이 salesman인 사람의 급여 합계와 평균
SELECT sum(sal), to_char(avg(sal),'9999.99')
FROM emp
WHERE job = 'SALESMAN';

SELECT count(job) FROM emp
WHERE job ='SALESMAN';

SELECT sum(sal) FROM emp WHERE job = 'SALESMAN';

-- 별칭 띄워쓰기 불가.
SELECT count(*) 회사원수,
       sum(nvl2(comm,sal+comm,sal)) 급여합계,       
       count(comm) 인센티브수,
       to_char(avg(nvl2(comm,sal+comm,sal)),'$99999.99')
FROM emp;

-- Group by 그릅을 지어 그룹별 대표 값을 반환하는데 주로 사용
-- 결과에 대한 순서화를 하기 위해 ORDER BY 절을 사용할 수 있다.

SELECT job, to_char(avg(nvl2(comm,sal+comm,sal)),'99999,99') 평균
FROM emp
GROUP BY job ORDER BY job;

SELECT job, sal
FROM emp
ORDER BY job;

-- 월급이 1000달라가 넘는 사람들의직급 기준으로 카운트
SELECT job, count(*)
FROM emp
WHERE sal >= 1000
GROUP BY job;

SELECT deptno, job, count(*)
FROM emp
GROUP BY deptno, job
ORDER BY deptno, job;

-- HAVING 절 사용 그룹화 된 녁석 중에 조건 추가
SELECT job, count(*)
FROM emp
WHERE sal >= 1000
GROUP BY job HAVING job ='SALESMAN';

SELECT job, avg(sal)
FROM emp
WHERE sal >= 1000
GROUP BY job HAVING avg(sal) >= 2000;

-- JOIN 과 부질의
-- cross join

SELECT * from emp CROSS JOIN dept CROSS JOIN salgrade;

SELECT count(*) FROM emp;
SELECT count(*) FROM dept;
SELECT count(*) FROM salgrade;

SELECT count(*) FROM emp, dept, salgrade;

-- EQUI join 이쿼 조인
-- WHERE =('equals') 비교를 통해 같은 값을 가진 행을 연결

SELECT ename, job, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- EQUI JOIN AND 연산자를 추가
SELECT
    emp.ename,
    emp.job,    
    dept.dname
FROM emp, dept
WHERE emp.deptno = dept.deptno
AND empno = 7788;

SELECT empno FROM emp;

SELECT emp.empno, emp.ename, dept.dname, emp.deptno
FROM emp, dept
WHERE emp.deptno = dept.deptno
AND empno = 7788;

-- 테이을 영문 너무 길 경우 별칭 사용
SELECT empno, ename, dname, e.deptno
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND empno = 7788;

-- NATURAL JOIN
-- 두개의 테이블의 열중 이름이 같은 열을 자동으로 이용하여 JOIN
SELECT empno, ename, dname, deptno
FROM emp NATURAL JOIN dept;

-- Join Using 
SELECT ename, job, deptno, dname
FROM emp JOIN dept using(deptno);

-- JOIN ~ ON
SELECT ename, job, emp.deptno, dname
FROM emp join dept on emp.deptno = dept.deptno;

-- emp dept 두개의 테이블을 연결하여 매니져가 어디부서에 있나 확인

SELECT ename, job, emp.deptno, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno
AND job = 'MANAGER';

SELECT ename, job, emp.deptno, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno
AND job = 'MANAGER' OR job = 'SALESMAN';

SELECT ename, job, emp.deptno, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno
AND (job = 'MANAGER' OR job = 'SALESMAN');

SELECT ename, job, deptno, dname
FROM emp NATURAL JOIN dept
WHERE job = 'MAMAGER' OR job = 'SALESMAN'
ORDER BY job;

SELECT ename, job, deptno, dname
FROM emp JOIN dept USING(deptno)
WHERE job in('MANAGER','SALESMAN')
ORDER BY job;

SELECT ename, job, emp.deptno, dname
FROM emp JOIN dept on emp.deptno = dept.deptno
WHERE job in('MANAGER','SALESMAN')
ORDER BY job;

------------------------ 20190501
-- NON - EQUI JOIN
-- EQUI JOIN 에서 사용되는 = 연사자가 아닌 연사자를 사용하는 경우.
DESC salgrade;

SELECT * FROM salgrade;

SELECT empno, ename, sal, grade
FROM emp, salgrade
WHERE sal BETWEEN losal AND hisal;

-- SELF JOIN
-- 동일한 테이블을 이용해서 서로다른 정보를 도출.
SELECT
    e1.empno AS 사원번호,
    e1.ename 사원이름,
    e2.empno 상급자번호,
    e2.ename "상급자 이름"
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno;

SELECT
    e1.empno AS 사원번호,
    e1.ename 사원이름,
    e2.empno 상급자번호,
    e2.ename "상급자 이름"
FROM emp e1 JOIN emp e2 ON e1.mgr = e2.empno;

SELECT 
    e1.ename || '의 직속상관은 ' || e2.ename || ' 입니다.'
FROM emp e1 JOIN emp e2 ON e1.mgr = e2.empno;

-- OUTER JOIN
-- 조인 조건을 만족하지 않는 행들도 질의 결과에 포함하기 위한 조인
SELECT
    e.*, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno ORDER BY empno;

SELECT e.*, d.dname
FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno = d.deptno
ORDER BY empno;

SELECT
    e1.empno 사원번호, 
    e1.ename 사원이름,
    e2.empno 상급자번호,
    e2.ename 상급자이름
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno;

SELECT * FROM emp;

-- 상급자가 없는 살마도 검색 조건에 포함하여 결과를 출력
SELECT
    e1.empno 사원번호, 
    e1.ename 사원이름,
    e2.empno 상급자번호,
    e2.ename 상급자이름
FROM emp e1 LEFT OUTER JOIN emp e2 ON e1.mgr = e2.empno;

--subquery 부 질의
-- 질의 안에 질의
-- CLARK 라는 사원보다 월급을 많이 받는 사원 찾기.

--금액 확인
SELECT ename, sal FROM emp
ORDER BY sal DESC;

-- 2450
SELECT sal FROM emp WHERE ename = 'CLARK';

SELECT empno, ename, sal
FROM emp
WHERE sal > 2450;

-- 합치기
SELECT empno, ename, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'CLARK')
ORDER BY sal DESC;

-- SELF JOIN 으로 한다면...
SELECT
    e1.empno, e1.ename, e1.sal
FROM emp e1, emp e2
WHERE e1.sal > e2.sal AND e2.ename = 'CLARK'
ORDER BY sal DESC;

-- 단일열 부질의
-- SCOTT 과 급여가 같은 녀석
SELECT * FROM emp
WHERE sal = (SELECT sal FROM emp WHERE ename = 'SCOTT');

-- SCOTT 제외
SELECT * FROM emp
WHERE sal = (SELECT sal FROM emp WHERE ename = 'SCOTT')
AND ename != 'SCOTT';

-- 30번 부서에서 최소 급여를 구한 후 
-- 부서별 최소 급여가 구한 30번 부서의 최소급여보다 큰 부서만 출력.

SELECT min(sal) FROM emp WHERE deptno = 30;
SELECT min(sal) FROM emp WHERE deptno = 20;
SELECT min(sal) FROM emp WHERE deptno = 10;

SELECT ename, deptno
FROM emp
WHERE sal > (SELECT min(sal) FROM emp WHERE deptno = 30);

SELECT deptno, min(sal) AS minsal
FROM emp
GROUP BY deptno
HAVING min(sal) > (SELECT min(sal) FROM emp WHERE deptno=30);

SELECT emp.deptno, dept.dname, min(sal) AS minsal
FROM emp JOIN dept ON emp.deptno = dept.deptno
GROUP BY emp.deptno, dept.dname
HAVING min(sal) > (SELECT min(sal) FROM emp WHERE emp.deptno=30);

-- 단일 값을 비교해야하는데 질의에 2개이상의 결과값이 있을 경우
SELECT * FROM emp where deptno='10';
-- MANAGER PRESIDENT CLERK
SELECT * FROM emp
WHERE job = (SELECT job FROM emp WHERE deptno='10');

--  
SELECT * FROM emp
WHERE job IN (SELECT job FROM emp WHERE deptno='10')
AND deptno <> '10';

-- >= == IN
-- < ANY 최대값 보다 작음
-- > ANY 최소값보다 큼

SELECT sal FROM emp WHERE deptno='10';

--최소값 하나의 값보다 커야한다.
SELECT * FROM emp
WHERE sal > ANY (SELECT sal FROM emp WHERE deptno='10');

-- 최소한 하나의 값보다 작아야한다.
SELECT * FROM emp
WHERE sal < ANY (SELECT sal FROM emp WHERE deptno='10');

-- 직급이 SALESMAN 이 아니면서 급여가 임의의 SALESMAN 보다 낮은 사원.
-- empno, ename, job, sal
SELECT empno, ename, job, sal
FROM emp
WHERE job != 'SALESMAN' AND sal < ANY(SELECT sal FROM emp WHERE job = 'SALESMAN');

-- ALL 연산자 
--  > ALL 최대값 보다 큼
--  < ALL 최소값 보다 작음 

SELECT sal FROM emp WHERE deptno='20';
-- 최소 800 쵀대 3000

-- 20번수의 최대 급여자 보다 돈을 많이 받는 사람
SELECT *
FROM emp
WHERE sal > ALL(SELECT sal FROM emp WHERE deptno = '20');

-- 다른 질의어에도 사용가능
CREATE TABLE test(
    empno, 
    ename, 
    sal, 
    comm, 
    deptno
) AS SELECT empno, ename, sal, comm, deptno FROM emp;

CREATE TABLE test1(
    empno, 
    ename, 
    sal, 
    comm, 
    deptno
) AS SELECT empno, ename, sal, comm, deptno FROM emp
WHERE deptno = 1;

SELECT * FROM test1;

-- 집합(SET) 연산자
-- 두개 이상의 질의 결과를 결합 하기 위해 사용
-- UNION 두 질의의 결과를 중복을 제거하고 가져옴
-- UNION ALL 중복을 포함한 두 질의의 모든 합.
-- INTERSECT 두 질의의 결과값의 공통되는 값(교집합)
-- MINUS 첫번째 질의의 결과값에서 두번째 질의의 결과에 있는 행을 제거하고 남은 값.

CREATE TABLE a_emp
AS
SELECT * FROM emp
WHERE deptno in(10,20);

CREATE TABLE b_emp
AS
SELECT * FROM emp
WHERE deptno in(20,30);

SELECT * FROM a_emp
UNION
SELECT * FROM b_emp;

SELECT * FROM a_emp
UNION ALL
SELECT * FROM b_emp;

SELECT * FROM a_emp
INTERSECT
SELECT * FROM b_emp;

SELECT * FROM a_emp
MINUS
SELECT * FROM b_emp;

SELECT * FROM b_emp
MINUS
SELECT * FROM a_emp;

-- 사용불가
SELECT * FROM emp
UNION
SELECT * FROM dept;

--------------------------------------------------------------------
--- DML
-- 연습용 테이블 생성(emp table 복제)
CREATE TABLE emp_copy
AS SELECT empno, ename, job, hiredate, deptno FROM emp
WHERE 0=1;

SELECT * FROM emp_copy;

-- 값의 삽입
-- INSERT INTO table_name (속성명, 속성명,....) VALUES(값, 값,........);
INSERT INTO emp_copy(empno, ename, job, hiredate, deptno)
VALUES(7000,'CANDY','MANAGER','2012/05/01',10);

SELECT * FROM emp_copy;

INSERT INTO emp_copy
VALUES(7010,'TOM','MANAGER','2015/06/02',20);

SELECT * FROM emp_copy;

INSERT INTO emp_copy
VALUES(7020,'JERRY','MANAGER',sysdate,30);

SELECT * FROM emp_copy;

-- 연습용 dept table 생성
CREATE TABLE dept_copy
AS
SELECT * FROM dept
WHERE 0=1;

SELECT * FROM dept_copy;

INSERT INTO dept_copy(deptno, dname, loc)
VALUES (10,'ACCOUNTING','NEW YORK');

SELECT * FROM dept_copy;

INSERT INTO dept_copy
VALUES (20,'RESEARCH','DALLS');

SELECT * FROM dept_copy;

-- 암시적 null 삽입
INSERT INTO dept_copy(deptno, dname)
VALUES(30,'SALES');

-- 명시적 null 삽입
INSERT INTO dept_copy
VALUES(40,'OPERATIONS',null);

SELECT * FROM dept_copy;

INSERT INTO dept_copy
VALUES(50,'COMPUTTING','');

INSERT INTO dept_copy
VALUES(60,'AAAA',' ');

SELECT * FROM dept_copy;

-- UPDATE 수정
-- UPDATE 테이블이름 SET 속성이름 = 변경할 값, 속성이름 = 변경할 값....
-- WHERE 조건(행 검색 조건)

UPDATE dept_copy
SET dname = 'PROGRAMING'
WHERE deptno=60;

SELECT * FROM dept_copy;

UPDATE dept_copy
SET dname='HR', loc='SEOUL'
WHERE deptno = 50;

SELECT * FROM dept_copy;

UPDATE dept_copy
SET loc=(SELECT loc FROM dept_copy WHERE deptno=20)
WHERE deptno = 30;

SELECT * FROM dept_copy;

--DELETE
-- DELETE FROM 테이블 이름 WHERE 조건
DELETE FROM dept_copy;

SELECT * FROM dept_copy;

INSERT INTO dept_copy
(SELECT * FROM dept);

SELECT * FROM dept_copy;

DELETE FROM dept_copy WHERE dname ='SALES';

SELECT * FROM dept_copy;

SELECT * FROM emp_copy;

CREATE TABLE emp_copy2
AS SELECT * FROM emp;

SELECT * FROM emp_copy2;

DELETE FROM emp_copy2
WHERE deptno = (SELECT deptno FROM dept WHERE dname='SALES');


SELECT * FROM emp_copy2;

commit;
-- 새로운 transaction
-- TCL 
-- commit & rollback
DELETE FROM emp_copy2;

SELECT * FROM emp_copy2;

rollback;


---------------------------------------------------------------------
-- DDL
-- CREATE TABLE
-- TABLE 생성 규칙
-- 문자 (A~Z, a~z)로 시작 30자 이내
-- 문자(A~Z, a~z), 숫자(0~9), 특수문자(_,$,#)만 사용가능.
-- 대소문자 구분은 없고 소문자로 지정하고 싶으면 '' 작은따움표로 묶음
-- 동일 사용자가 소유한 다른 테이블 이름과 중복되지 않아야 한다.

CREATE TABLE dep(
    dno NUMBER(2),
    dname VARCHAR2(14),
    loc VARCHAR2(13)
);

DESC dep;

INSERT INTO dep VALUES(12,'최기근','BUSAN');

SELECT * FROM dep;

-- 기존 테이블의 구조와 데이터를 복사하여 데이블 만들기
DROP TABLE dept_copy purge;

CREATE TABLE dept_copy
AS SELECT * FROM dept;

SELECT * FROM dept_copy;

CREATE TABLE dept20
AS
SELECT empno, ename, sal*12 annsal
FROM emp WHERE deptno=20;

DESC dept20;

CREATE TABLE dept_third
AS
SELECT * FROM dept
WHERE 0=1;

-- 테이블 구조 변경
-- 추가 add
ALTER TABLE dept20 add(birth date);

DESC dept20;

rollback;

DESC dept20;

SELECT * FROM dept20;

-- 수정 modify
ALTER TABLE dept20
MODIFY ename VARCHAR2(50 BYTE);

DESC dept20;

-- 속성 삭제 DROP
ALTER TABLE dept20
DROP COLUMN ename;

DESC dept20;

SELECT * FROM dept20;

-- 테이블 이름변경 RENAME Table_Source TO Table_Target
RENAME dept20 TO dept2019;

-- 테이블 삭제
-- DROP TABLE
DROP TABLE dept2019;

SELECT * FROM dept2019;


show recyclebin;

DESC recyclebin;

SELECT object_name, Original_name, dropscn FROM recyclebin;

FLASHBACK TABLE dept2019 TO BEFORE DROP;

show recyclebin;

DROP TABLE dept2019 purge;

SELECT * FROM dept2019;

show recyclebin;

SELECT object_name, Original_name, dropscn FROM recyclebin;

CREATE TABLE dept20
AS
SELECT * FROM dept;

DROP TABLE dept20;

show recyclebin;

PURGE TABLE dept20;

show recyclebin;

CREATE TABLE dept20
AS
SELECT * FROM dept;

-- DELETE FROM dept20과 동일
TRUNCATE TABLE dept20;

SELECT * FROM dept20;

rollback;

-- 제약조건
-- NOT NULL - NULL 값을 포함하지 않는다.
-- UNIQUE   - 테이을에서 검색되는 모든 행에 대해서 유일한 값이어야 한다.
--PRIMARY KEY - 테이블에 각행을 구분짓는 값
-- NOT NULL + UNIQUE
-- FOREIGN KEY 참조되는 테이블 컬럼값이 항상 존재 해야한다.
-- CHECK 저장 가능한 데이터 값의 범위나 조건을 지정.

-- clumn 단위 제약조건 지정
CREATE TABLE dept_second(
    deptno number(2) CONSTRAINT dept_second_pk primary key,
    dname VARCHAR2(16) CONSTRAINT dept_second_uk UNIQUE,
    loc VARCHAR2(14)
);

CREATE TABLE dept_third(
    deptno number(2) primary key,
    dname VARCHAR2(16) UNIQUE,
    loc VARCHAR2(14)
);

SELECT * FROM USER_CONSTRAINTS;

DROP TABLE dept_second purge;
DROP TABLE dept_third purge;

SELECT * FROM USER_CONSTRAINTS;

-- 테이블 단위 제약조건 지정
CREATE TABLE dept_second
(
    deptno number(2),
    dname VARCHAR2(15),
    loc VARCHAR2(16),
    CONSTRAINT dept_deptno_pk PRIMARY KEY(deptno),
    CONSTRAINT dept_deptno_uk UNIQUE(dname)
);

CREATE TABLE dept_third
(
    deptno number(2),
    dname VARCHAR2(15),
    loc VARCHAR2(16),
    PRIMARY KEY(deptno),
    UNIQUE(dname)
);

DROP TABLE dept_second purge;
DROP TABLE dept_third purge;

CREATE TABLE dept_second(
    deptno NUMBER(2),
    dname VARCHAR(16) UNIQUE,
    loc VARCHAR2(16),
    PRIMARY KEY(deptno)
);

-- NOT NULL
SELECT * FROM dept2019;


INSERT INTO customer(pwd,name,phone,address)
VALUES('pwd','최기근','01094867166','평양');

INSERT INTO customer
VALUES(null,null,null,'01094867166','평양');

INSERT INTO customer
VALUES('','pwd','최기근','01094867166','평양');

INSERT INTO customer
VALUES(' ','pwd','최기근','01094867166','평양');

DROP TABLE customer purge;

--UNIQUE
CREATE TABLE customer(
    id VARCHAR2(20) UNIQUE,
    pwd VARCHAR2(20) NOT NULL,
    name VARCHAR2(20) NOT NULL,
    phone VARCHAR2(30),
    address VARCHAR2(100)    
);

INSERT INTO customer
VALUES('greentea','1234','녹차아가씨','01011111111','BOSUNG');

SELECT * FROM customer;

INSERT INTO customer
VALUES('greentea1','1234','녹차아가씨','01011111111','BOSUNG');

INSERT INTO customer
VALUES('','1234','녹차아가씨','01011111111','BOSUNG');

SELECT * FROM customer;


DROP TABLE customer purge;

--PRIMARY KEY
CREATE TABLE customer(
    id VARCHAR2(20) PRIMARY KEY,
    pwd VARCHAR2(20) NOT NULL,
    name VARCHAR2(20) NOT NULL,
    phone VARCHAR2(30),
    address VARCHAR2(100)    
);

INSERT INTO customer
VALUES('choi','1234','최기근','010-1111-1111','NEWYORK');

SELECT * FROM customer;

INSERT INTO customer
VALUES('choi','1234','최기근','010-1111-1111','NEWYORK');

INSERT INTO customer
VALUES('','1234','최기근','010-1111-1111','NEWYORK');

SELECT * FROM customer;

-------------------------------------------------------------------------
-- 2019.05.02
-- FOREIGN KEY
-- 들어가는 값이 참조하고 있는 테이블의 열에 존재해야한다.
-- 참조 무결성 제약 조건 -> null 은 가능하다.
SELECT * FROM dept;

INSERT INTO emp(empno,ename,deptno) VALUES(8000,'최기근',40);

SELECT * FROM emp;

rollback;

-- Check 값의 범위를 설정하는 제약조건

CREATE TABLE emp_second(
    empno number(4) CONSTRAINT emp_second_pk PRIMARY KEY,
    ename varchar(10) NOT NULL,
    deptno NUMBER(2,0),
    sal NUMBER(7,2) CONSTRAINT emp_second_sal_check CHECK(sal > 0) NOT NULL,
    CONSTRAINT emp_second_fk FOREIGN KEY(deptno) REFERENCES dept(deptno)
);

-- 무결성 제약조건 위반
INSERT INTO emp_second(empno,ename,deptno,sal)
VALUES(8000,'최기근',50,5000);
-- 체크 제약조건 위반
INSERT INTO emp_second(empno,ename,deptno,sal)
VALUES(8000,'최기근',40,-200);
-- NOT NULL 제약조건 위반
INSERT INTO emp_second(empno,ename,deptno,sal)
VALUES(8000,'최기근',40,null);
-- 정상 실행
INSERT INTO emp_second(empno,ename,deptno,sal)
VALUES(8000,'최기근',40,5000);

DROP TABLE emp_second PURGE;

-- default 설정.
CREATE TABLE emp_second(
    empno NUMBER(4) PRIMARY KEY,
    ename VARCHAR2(10) NOT NULL,
    sal NUMBER(7,2) DEFAULT 1000
);

INSERT INTO emp_second(empno, ename)
VALUES(8000,'최기근');

SELECT * FROM emp_second;


-- 제약 조건의 수정.
CREATE TABLE temp_emp
AS SELECT * FROM emp
WHERE 0=1;

--
ALTER TABLE temp_emp
ADD CONSTRAINT pkpk_emp PRIMARY KEY(empno);

ALTER TABLE temp_emp
MODIFY sal CONSTRAINT temp_emp_sal_nn NOT NULL;

ALTER TABLE temp_emp
ADD CONSTRAINT fkfk_emp FOREIGN KEY(deptno) REFERENCES dept(deptno);



-- SEQUENCE
-- SEQUENCE는 기본키가 유일한 값을 갖도록
-- 사용자가 직접 생성해 내는 부담감을 줄여주는 개체이다.

CREATE SEQUENCE sample_seq
 INCREMENT BY 10
 START WITH 10;
 
 
 -- SEQUENCE.nextval 다음값 호출
 -- SEQUENCE.currval 현재 저장된 값

SELECT sample_seq.nextval FROM dual;
 
SELECT sample_seq.currval FROM dual;
 
 -- DEPT 테스트용
CREATE TABLE dept_second
 AS SELECT * FROM dept WHERE 0=1;

ALTER TABLE dept_second
ADD CONSTRAINT pkpk_dept PRIMARY KEY(deptno);

SELECT * FROM dept_second;

INSERT INTO dept_second
VALUES(10,'OPERATIONS','BUSAN');

SELECT * FROM dept_second;

INSERT INTO dept_second
VALUES(20,'SALES','SEOUL');

DELETE dept_second;

commit;

CREATE SEQUENCE deptno_seq
    INCREMENT BY 10
    START WITH 10;
    
INSERT INTO dept_second
VALUES (deptno_seq.nextval,'ACCOUNTING','NEW YORK');

SELECT * FROM dept_second;

INSERT INTO dept_second
VALUES (deptno_seq.nextval,'OPERATIONS','BOSTON');

SELECT * FROM dept_second;

DROP SEQUENCE sample_seq;

show recyclebin;

DROP SEQUENCE deptno_seq;

show recyclebin;

SELECT * FROM dept_copy;

DROP TABLE dept_copy;

CREATE TABLE dept_copy
AS
SELECT * FROM dept;

DROP SEQUENCE deptno_seq;

CREATE SEQUENCE deptno_seq
    INCREMENT BY 10
    START WITH 10;
    
INSERT INTO dept_second
VALUES (deptno_seq.nextval,'ACCOUNTING','NEW YORK');

SELECT * FROM dept_second;

ALTER SEQUENCE deptno_seq increment by -10 minvalue  0;

SELECT deptno_seq.nextval FROM dual;

ALTER SEQUENCE deptno_seq increment by 10 minvalue  0;

SELECT deptno_seq.nextval FROM dual;


