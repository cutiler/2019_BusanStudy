-- Ctrl + enter
DESC ENROL;

SELECT * FROM ENROL;

DESC subject;

SELECT * FROM scott.subject;

-- student table ���� stu_no, stu_name �� ������ Ȯ��

SELECT stu_no, stu_name FROM student ORDER BY stu_no;

-- student ���̺��� dept ������ ��ȸ
DESC student;

SELECT stu_dept FROM student;

-- �ߺ� ����
SELECT DISTINCT stu_dept FROM student;

SELECT stu_grade, stu_class FROM student;

SELECT DISTINCT stu_grade, stu_class FROM student;

-- ������
SELECT stu_no, sub_no, enr_grade FROM enrol;

SELECT stu_no, sub_no, enr_grade+10 FROM enrol;

-- ��Ī AS
SELECT stu_no AS �й�, stu_name AS �̸� FROM student;

-- ���� ������ ||
SELECT stu_dept || stu_name AS �а����� FROM student;

SELECT stu_dept ||','|| stu_name || '�Դϴ�.' AS �а����� FROM student;

-- �˻� ���� WHERE(>, >=, <, <=, =,  <>, != , ^=)

SELECT stu_name, stu_dept, stu_grade, stu_class
FROM student
WHERE stu_dept = '��ǻ������';

SELECT stu_name, stu_height
FROM student
WHERE stu_height > 170;

SELECT stu_name, stu_height
FROM student
WHERE stu_height <= 180;

-- ���ǿ� �� ������ �߰� (NOT AND OR)

SELECT stu_name, stu_dept, stu_grade, stu_class
FROM student
WHERE stu_dept = '��ǻ������' OR stu_dept = '��������';

SELECT stu_name, stu_dept, stu_grade, stu_class
FROM student
WHERE stu_dept = '��ǻ������' AND stu_grade=2;

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
WHERE stu_name LIKE '��%';

SELECT * FROM student
WHERE stu_name LIKE '��%'
OR stu_name LIKE '��%';

-- _ �ѱ��ڸ� ����

SELECT * FROM student
WHERE stu_name LIKE '��%'
AND stu_name LIKE '_��%';

-- IN ������. OR ������

SELECT * FROM student
WHERE stu_dept IN('��ǻ������','���');

-- null
SELECT stu_name, stu_height/10 AS average 
FROM student;

-- is null �ش� �Ӽ����� null�� Ʃ��
SELECT stu_no, stu_name, stu_height
FROM student
WHERE stu_height IS NULL;

- is not null
SELECT stu_no, stu_name, stu_height
FROM student
WHERE stu_height IS NOT NULL;

-- ORDER BY - ASC, �������� - ��������.
-- ORDER BY - DESC ��������

SELECT stu_no, stu_name
FROM student
ORDER BY stu_no;

SELECT stu_no, stu_name
FROM student
ORDER BY stu_no DESC;

SELECT stu_no, stu_name AS �̸� FROM student
ORDER BY �̸� DESC;

SELECT stu_no, stu_name, stu_dept, stu_weight AS ������
FROM student
ORDER BY stu_dept, ������ DESC;

-- dual <-- dummy table sys�� �������ִ� �ӽ����̺�
--�Լ�
-- �����Լ�

SELECT round(123456.45) From dual;
SELECT round(123456.45,2) From dual;

SELECT 
round(123456.45),
round(123456.45,-1),
round(123456.45,2),
round(123456.45,3),
round(123456.1567,2)
FROM dual;

-- �������� ��ȯ�ϴ� mod
SELECT mod(30,7) FROM dual;

-- �Ҽ��� �ڸ��� ������ floor
SELECT floor(123456.1234) FROM dual;

-- student ���̺� �ݿø�
SELECT stu_no, stu_name, stu_height, round(stu_height, -1) AS round
FROM student WHERE stu_height IS NOT NULL;

-- ���� �Լ�
SELECT LOWER('HELLO ORACLE') FROM dual;

SELECT UPPER('Hello World') FROM dual;

-- ù���ڸ� �빮�ڷ� ����
SELECT INITCAP('hello world') FROM dual;

-- ���ڿ��� �̾��ִ� �Լ�
SELECT concat('Hello','World') FROM dual;

-- ���ڿ��� �ڶ�� substr
SELECT substr('Hello World',7,5) FROM dual;
SELECT substr('Hello World',1,5) FROM dual;

SELECT substr('�ȳ��ϼ��� �ݰ�����',1,5) FROM dual;
SELECT substr('�ȳ��ϼ��� �ݰ�����',7,4) FROM dual;

-- ���ڿ��� ���� ��ȯ
SELECT length('Hello world') FROM dual;

-- Ư�� ������ ���� ��ġ�� ��ȯ instr
-- instr(�˻��� ���ڿ�, ã�� ���ڿ�, �˻� ������ġ, �˻��� ����)
SELECT instr('Hello world','o') FROM dual;

SELECT instr('hello world', 'o',1,2) FROM dual;

-- �˻� �������� ��� ������� ã�� �� ����. 0��ȯ
SELECT instr('hello world', 'o',0,2) FROM dual;

-- ������� ä�� �ִ� �Լ� LPAD, RPAD
SELECT lpad('hello world',15,'$') FROM dual;
SELECT rpad('hello world',15,'&') FROM dual;
SELECT lpad(123,20,0) FROM dual;


-- ��¥ �Լ�
-- �ý����� ���� �ð��� ��ȯ
 SELECT sysdate FROM dual;
 
 alter session set nls_date_format = 'yyyy-mm-dd HH:MI:ss';
 alter session set nls_date_format = 'yyyy-mm-dd HH24:MI:ss';
 
 --��¥ ����, ��Ī �ֵ���ǥ ���� ���ڴ� ��ҹ��� ����.
SELECT
    sysdate+1 AS �Ϸ���ϱ�,
    sysdate+(1/24) "1�ð� ���ϱ�",
    sysdate+((1/24)/60) "1�� ���ϱ�",
    sysdate+(((1/24)/60)/60) "1�� ���ϱ�"
FROM dual;

-- ��¥�� ��¥ ������ ���� ���� ��ȯ.
SELECT months_between(sysdate, sysdate+31) FROM dual;

SELECT MONTHS_BETWEEN(SYSDATE+31, SYSDATE) FROM dual;

-- �ش� ��¥ �������� ��õ� ���Ͽ� �ش��ϴ� ��¥�� ���� �Լ� NEXT_DAY
-- 1 : �Ͽ��� 2: ������ 3: ȭ 4: �� 5: �� 6: �� 7: ��
-- '��'        '��'..........

SELECT next_day(sysdate,2) FROM dual;

SELECT next_day(sysdate,'��') FROM dual;
SELECT next_day(sysdate,'��') FROM dual;

-- Ư�� ���� ���� ���� ��¥�� ��ȯ�ϴ� �Լ� add_months
SELECT
sysdate,
add_months(sysdate,1) add_months,
add_months(sysdate,-1) add_months2
FROM dual;

-- ���� ���� ��¥�� �̿��ؼ� ù°���� ������ ���� �˷��ִ� �ݿø� �Լ� round
SELECT round(sysdate-2, 'MON') FROM dual;
SELECT round(sysdate, 'YEAR') FROM dual;
SELECT round(sysdate, 'DAY') FROM dual;

SELECT sysdate FROM dual;

-- ��¥ �����ؼ� ù°��. trunc
SELECT TRUNC(sysdate, 'MON') FROM dual;

-- ��ȯ�Լ�
-- to_number �� to_char
SELECT to_char(1) FROM dual;


SELECT to_char(to_number('1234.5678'),'9999.9999') FROM dual;
-- ���� �ڸ��� ���� ���� �ÿ��� ���� ǥ��
SELECT to_char(to_number('1234.5678'),'999.9999') FROM dual;
-- �Ҽ��� ���� �ڸ��� �ݿø� �ؼ�ǥ��
SELECT to_char(to_number('1234.5678'),'9999.999') FROM dual;

DESC emp;

SELECT empno, ename, sal FROM emp;

SELECT empno, ename, to_char(sal,'$999') FROM emp;

SELECT empno, ename, to_char(sal,'L9,999') FROM emp;
SELECT empno, ename, concat(to_char(sal,'09,999'),'����') FROM emp;
SELECT empno, ename, concat(to_char(sal,'L09,999'),'��') FROM emp;

-- to_date
-- ��¥ ������ ���ڸ� ��¥�� ��ȯ �Ҷ� ���

SELECT * FROM emp;
DESC emp;

-- ������ �� ��ȯ.
SELECT empno, ename
FROM emp
WHERE hiredate = '1980-12-17';

SELECT empno, ename
FROM emp
WHERE hiredate = to_date('1980-12-17','yy-mm-dd');

-- �Ϲ� �Լ�
-- nvl ù��° ���ڰ��� �ΰ����� üũ�Ͽ� 
-- ������ ������ ��(�ι�° ���ڰ�)���� ��ȯ�Ͽ� ��ȯ�ϴ� �Լ�.

SELECT nvl(MGR,0) FROM emp;

-- nvl2(�μ�1,�μ�2,�μ�3)
-- �μ�1���� ��null �ƴϸ� �μ�2, null�̸� �μ�3 �� ��ȯ,.
SELECT ename, comm, sal, nvl2(comm, sal+comm, sal)
FROM emp;

SELECT ename, comm, sal, nvl2(comm, to_char(sal+comm, '$99,999'), to_char(sal, '$99,999'))
FROM emp;

SELECT ename,comm,sal,
to_char(nvl2(comm,sal+comm,sal),'$99,999') AS ���޾�
FROM emp;

SELECT ename, comm, sal, sal+comm FROM emp;

-- nullif(����1, ����2)
-- ����1�� ���� 2�� �����ϸ� �ΰ��� ��ȯ

SELECT nvl(nullif('A','A'),'���Դϴ�.')
FROM dual;

SELECT nvl(nullif('A','B'),'���Դϴ�.' )
FROM dual;

SELECT COALESCE(null,null,null,100,10,null,null) FROM dual;

-- CASE �Ӽ� WHEN ~ THEN ~ else END;

SELECT * FROM emp;

SELECT empno, ename, job, sal,
    CASE job WHEN 'SALESMAN' THEN sal * 1.1
             WHEN 'CLERK'    THEN sal * 1.15
             WHEN 'MANAGER' THEN sal * 1.2
             else sal
    END AS �޿��λ�
FROM emp;

-- DECODE
SELECT empno, ename, job, sal,
    DECODE(job,'SALESMAN',sal*1.1,
                'CLERK', sal*1.15,
                'MANEGER',sal*1.2,
                sal) AS �޿��λ�
FROM emp;

-- �׷� �Լ�
-- �����࿡ ���� ������ ������� ��ȯ�ϴ� �Լ�

-- MIN, MAX

SELECT max(sal), MIN(sal)
FROM emp;

SELECT max(nvl2(comm,sal+comm,sal)), MIN(nvl2(comm,sal+comm,sal))
FROM emp;

SELECT max(nvl2(comm,sal+comm,sal)), MIN(sal)
FROM emp
WHERE job = 'SALESMAN';

-- ���� ������ ��ȯ�ϴ� count
SELECT count(*),count(ALL comm) FROM emp;
SELECT * FROM emp;

-- distinct �ߺ�����
SELECT count(job), count(distinct job) FROM emp;

-- sum(), avg()
-- job�� salesman�� ����� �޿� �հ�� ���
SELECT sum(sal), to_char(avg(sal),'9999.99')
FROM emp
WHERE job = 'SALESMAN';

SELECT count(job) FROM emp
WHERE job ='SALESMAN';

SELECT sum(sal) FROM emp WHERE job = 'SALESMAN';

-- ��Ī ������� �Ұ�.
SELECT count(*) ȸ�����,
       sum(nvl2(comm,sal+comm,sal)) �޿��հ�,       
       count(comm) �μ�Ƽ���,
       to_char(avg(nvl2(comm,sal+comm,sal)),'$99999.99')
FROM emp;

-- Group by �׸��� ���� �׷캰 ��ǥ ���� ��ȯ�ϴµ� �ַ� ���
-- ����� ���� ����ȭ�� �ϱ� ���� ORDER BY ���� ����� �� �ִ�.

SELECT job, to_char(avg(nvl2(comm,sal+comm,sal)),'99999,99') ���
FROM emp
GROUP BY job ORDER BY job;

SELECT job, sal
FROM emp
ORDER BY job;

-- ������ 1000�޶� �Ѵ� ����������� �������� ī��Ʈ
SELECT job, count(*)
FROM emp
WHERE sal >= 1000
GROUP BY job;

SELECT deptno, job, count(*)
FROM emp
GROUP BY deptno, job
ORDER BY deptno, job;

-- HAVING �� ��� �׷�ȭ �� �Ἦ �߿� ���� �߰�
SELECT job, count(*)
FROM emp
WHERE sal >= 1000
GROUP BY job HAVING job ='SALESMAN';

SELECT job, avg(sal)
FROM emp
WHERE sal >= 1000
GROUP BY job HAVING avg(sal) >= 2000;

-- JOIN �� ������
-- cross join

SELECT * from emp CROSS JOIN dept CROSS JOIN salgrade;

SELECT count(*) FROM emp;
SELECT count(*) FROM dept;
SELECT count(*) FROM salgrade;

SELECT count(*) FROM emp, dept, salgrade;

-- EQUI join ���� ����
-- WHERE =('equals') �񱳸� ���� ���� ���� ���� ���� ����

SELECT ename, job, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- EQUI JOIN AND �����ڸ� �߰�
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

-- ������ ���� �ʹ� �� ��� ��Ī ���
SELECT empno, ename, dname, e.deptno
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND empno = 7788;

-- NATURAL JOIN
-- �ΰ��� ���̺��� ���� �̸��� ���� ���� �ڵ����� �̿��Ͽ� JOIN
SELECT empno, ename, dname, deptno
FROM emp NATURAL JOIN dept;

-- Join Using 
SELECT ename, job, deptno, dname
FROM emp JOIN dept using(deptno);

-- JOIN ~ ON
SELECT ename, job, emp.deptno, dname
FROM emp join dept on emp.deptno = dept.deptno;

-- emp dept �ΰ��� ���̺��� �����Ͽ� �Ŵ����� ���μ��� �ֳ� Ȯ��

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
-- EQUI JOIN ���� ���Ǵ� = �����ڰ� �ƴ� �����ڸ� ����ϴ� ���.
DESC salgrade;

SELECT * FROM salgrade;

SELECT empno, ename, sal, grade
FROM emp, salgrade
WHERE sal BETWEEN losal AND hisal;

-- SELF JOIN
-- ������ ���̺��� �̿��ؼ� ���δٸ� ������ ����.
SELECT
    e1.empno AS �����ȣ,
    e1.ename ����̸�,
    e2.empno ����ڹ�ȣ,
    e2.ename "����� �̸�"
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno;

SELECT
    e1.empno AS �����ȣ,
    e1.ename ����̸�,
    e2.empno ����ڹ�ȣ,
    e2.ename "����� �̸�"
FROM emp e1 JOIN emp e2 ON e1.mgr = e2.empno;

SELECT 
    e1.ename || '�� ���ӻ���� ' || e2.ename || ' �Դϴ�.'
FROM emp e1 JOIN emp e2 ON e1.mgr = e2.empno;

-- OUTER JOIN
-- ���� ������ �������� �ʴ� ��鵵 ���� ����� �����ϱ� ���� ����
SELECT
    e.*, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno ORDER BY empno;

SELECT e.*, d.dname
FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno = d.deptno
ORDER BY empno;

SELECT
    e1.empno �����ȣ, 
    e1.ename ����̸�,
    e2.empno ����ڹ�ȣ,
    e2.ename ������̸�
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno;

SELECT * FROM emp;

-- ����ڰ� ���� �츶�� �˻� ���ǿ� �����Ͽ� ����� ���
SELECT
    e1.empno �����ȣ, 
    e1.ename ����̸�,
    e2.empno ����ڹ�ȣ,
    e2.ename ������̸�
FROM emp e1 LEFT OUTER JOIN emp e2 ON e1.mgr = e2.empno;

--subquery �� ����
-- ���� �ȿ� ����
-- CLARK ��� ������� ������ ���� �޴� ��� ã��.

--�ݾ� Ȯ��
SELECT ename, sal FROM emp
ORDER BY sal DESC;

-- 2450
SELECT sal FROM emp WHERE ename = 'CLARK';

SELECT empno, ename, sal
FROM emp
WHERE sal > 2450;

-- ��ġ��
SELECT empno, ename, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'CLARK')
ORDER BY sal DESC;

-- SELF JOIN ���� �Ѵٸ�...
SELECT
    e1.empno, e1.ename, e1.sal
FROM emp e1, emp e2
WHERE e1.sal > e2.sal AND e2.ename = 'CLARK'
ORDER BY sal DESC;

-- ���Ͽ� ������
-- SCOTT �� �޿��� ���� �༮
SELECT * FROM emp
WHERE sal = (SELECT sal FROM emp WHERE ename = 'SCOTT');

-- SCOTT ����
SELECT * FROM emp
WHERE sal = (SELECT sal FROM emp WHERE ename = 'SCOTT')
AND ename != 'SCOTT';

-- 30�� �μ����� �ּ� �޿��� ���� �� 
-- �μ��� �ּ� �޿��� ���� 30�� �μ��� �ּұ޿����� ū �μ��� ���.

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

-- ���� ���� ���ؾ��ϴµ� ���ǿ� 2���̻��� ������� ���� ���
SELECT * FROM emp where deptno='10';
-- MANAGER PRESIDENT CLERK
SELECT * FROM emp
WHERE job = (SELECT job FROM emp WHERE deptno='10');

--  
SELECT * FROM emp
WHERE job IN (SELECT job FROM emp WHERE deptno='10')
AND deptno <> '10';

-- >= == IN
-- < ANY �ִ밪 ���� ����
-- > ANY �ּҰ����� ŭ

SELECT sal FROM emp WHERE deptno='10';

--�ּҰ� �ϳ��� ������ Ŀ���Ѵ�.
SELECT * FROM emp
WHERE sal > ANY (SELECT sal FROM emp WHERE deptno='10');

-- �ּ��� �ϳ��� ������ �۾ƾ��Ѵ�.
SELECT * FROM emp
WHERE sal < ANY (SELECT sal FROM emp WHERE deptno='10');

-- ������ SALESMAN �� �ƴϸ鼭 �޿��� ������ SALESMAN ���� ���� ���.
-- empno, ename, job, sal
SELECT empno, ename, job, sal
FROM emp
WHERE job != 'SALESMAN' AND sal < ANY(SELECT sal FROM emp WHERE job = 'SALESMAN');

-- ALL ������ 
--  > ALL �ִ밪 ���� ŭ
--  < ALL �ּҰ� ���� ���� 

SELECT sal FROM emp WHERE deptno='20';
-- �ּ� 800 ���� 3000

-- 20������ �ִ� �޿��� ���� ���� ���� �޴� ���
SELECT *
FROM emp
WHERE sal > ALL(SELECT sal FROM emp WHERE deptno = '20');

-- �ٸ� ���Ǿ�� ��밡��
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

-- ����(SET) ������
-- �ΰ� �̻��� ���� ����� ���� �ϱ� ���� ���
-- UNION �� ������ ����� �ߺ��� �����ϰ� ������
-- UNION ALL �ߺ��� ������ �� ������ ��� ��.
-- INTERSECT �� ������ ������� ����Ǵ� ��(������)
-- MINUS ù��° ������ ��������� �ι�° ������ ����� �ִ� ���� �����ϰ� ���� ��.

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

-- ���Ұ�
SELECT * FROM emp
UNION
SELECT * FROM dept;

--------------------------------------------------------------------
--- DML
-- ������ ���̺� ����(emp table ����)
CREATE TABLE emp_copy
AS SELECT empno, ename, job, hiredate, deptno FROM emp
WHERE 0=1;

SELECT * FROM emp_copy;

-- ���� ����
-- INSERT INTO table_name (�Ӽ���, �Ӽ���,....) VALUES(��, ��,........);
INSERT INTO emp_copy(empno, ename, job, hiredate, deptno)
VALUES(7000,'CANDY','MANAGER','2012/05/01',10);

SELECT * FROM emp_copy;

INSERT INTO emp_copy
VALUES(7010,'TOM','MANAGER','2015/06/02',20);

SELECT * FROM emp_copy;

INSERT INTO emp_copy
VALUES(7020,'JERRY','MANAGER',sysdate,30);

SELECT * FROM emp_copy;

-- ������ dept table ����
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

-- �Ͻ��� null ����
INSERT INTO dept_copy(deptno, dname)
VALUES(30,'SALES');

-- ����� null ����
INSERT INTO dept_copy
VALUES(40,'OPERATIONS',null);

SELECT * FROM dept_copy;

INSERT INTO dept_copy
VALUES(50,'COMPUTTING','');

INSERT INTO dept_copy
VALUES(60,'AAAA',' ');

SELECT * FROM dept_copy;

-- UPDATE ����
-- UPDATE ���̺��̸� SET �Ӽ��̸� = ������ ��, �Ӽ��̸� = ������ ��....
-- WHERE ����(�� �˻� ����)

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
-- DELETE FROM ���̺� �̸� WHERE ����
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
-- ���ο� transaction
-- TCL 
-- commit & rollback
DELETE FROM emp_copy2;

SELECT * FROM emp_copy2;

rollback;


---------------------------------------------------------------------
-- DDL
-- CREATE TABLE
-- TABLE ���� ��Ģ
-- ���� (A~Z, a~z)�� ���� 30�� �̳�
-- ����(A~Z, a~z), ����(0~9), Ư������(_,$,#)�� ��밡��.
-- ��ҹ��� ������ ���� �ҹ��ڷ� �����ϰ� ������ '' ��������ǥ�� ����
-- ���� ����ڰ� ������ �ٸ� ���̺� �̸��� �ߺ����� �ʾƾ� �Ѵ�.

CREATE TABLE dep(
    dno NUMBER(2),
    dname VARCHAR2(14),
    loc VARCHAR2(13)
);

DESC dep;

INSERT INTO dep VALUES(12,'�ֱ��','BUSAN');

SELECT * FROM dep;

-- ���� ���̺��� ������ �����͸� �����Ͽ� ���̺� �����
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

-- ���̺� ���� ����
-- �߰� add
ALTER TABLE dept20 add(birth date);

DESC dept20;

rollback;

DESC dept20;

SELECT * FROM dept20;

-- ���� modify
ALTER TABLE dept20
MODIFY ename VARCHAR2(50 BYTE);

DESC dept20;

-- �Ӽ� ���� DROP
ALTER TABLE dept20
DROP COLUMN ename;

DESC dept20;

SELECT * FROM dept20;

-- ���̺� �̸����� RENAME Table_Source TO Table_Target
RENAME dept20 TO dept2019;

-- ���̺� ����
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

-- DELETE FROM dept20�� ����
TRUNCATE TABLE dept20;

SELECT * FROM dept20;

rollback;

-- ��������
-- NOT NULL - NULL ���� �������� �ʴ´�.
-- UNIQUE   - ���������� �˻��Ǵ� ��� �࿡ ���ؼ� ������ ���̾�� �Ѵ�.
--PRIMARY KEY - ���̺� ������ �������� ��
-- NOT NULL + UNIQUE
-- FOREIGN KEY �����Ǵ� ���̺� �÷����� �׻� ���� �ؾ��Ѵ�.
-- CHECK ���� ������ ������ ���� ������ ������ ����.

-- clumn ���� �������� ����
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

-- ���̺� ���� �������� ����
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
VALUES('pwd','�ֱ��','01094867166','���');

INSERT INTO customer
VALUES(null,null,null,'01094867166','���');

INSERT INTO customer
VALUES('','pwd','�ֱ��','01094867166','���');

INSERT INTO customer
VALUES(' ','pwd','�ֱ��','01094867166','���');

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
VALUES('greentea','1234','�����ư���','01011111111','BOSUNG');

SELECT * FROM customer;

INSERT INTO customer
VALUES('greentea1','1234','�����ư���','01011111111','BOSUNG');

INSERT INTO customer
VALUES('','1234','�����ư���','01011111111','BOSUNG');

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
VALUES('choi','1234','�ֱ��','010-1111-1111','NEWYORK');

SELECT * FROM customer;

INSERT INTO customer
VALUES('choi','1234','�ֱ��','010-1111-1111','NEWYORK');

INSERT INTO customer
VALUES('','1234','�ֱ��','010-1111-1111','NEWYORK');

SELECT * FROM customer;

-------------------------------------------------------------------------
-- 2019.05.02
-- FOREIGN KEY
-- ���� ���� �����ϰ� �ִ� ���̺��� ���� �����ؾ��Ѵ�.
-- ���� ���Ἲ ���� ���� -> null �� �����ϴ�.
SELECT * FROM dept;

INSERT INTO emp(empno,ename,deptno) VALUES(8000,'�ֱ��',40);

SELECT * FROM emp;

rollback;

-- Check ���� ������ �����ϴ� ��������

CREATE TABLE emp_second(
    empno number(4) CONSTRAINT emp_second_pk PRIMARY KEY,
    ename varchar(10) NOT NULL,
    deptno NUMBER(2,0),
    sal NUMBER(7,2) CONSTRAINT emp_second_sal_check CHECK(sal > 0) NOT NULL,
    CONSTRAINT emp_second_fk FOREIGN KEY(deptno) REFERENCES dept(deptno)
);

-- ���Ἲ �������� ����
INSERT INTO emp_second(empno,ename,deptno,sal)
VALUES(8000,'�ֱ��',50,5000);
-- üũ �������� ����
INSERT INTO emp_second(empno,ename,deptno,sal)
VALUES(8000,'�ֱ��',40,-200);
-- NOT NULL �������� ����
INSERT INTO emp_second(empno,ename,deptno,sal)
VALUES(8000,'�ֱ��',40,null);
-- ���� ����
INSERT INTO emp_second(empno,ename,deptno,sal)
VALUES(8000,'�ֱ��',40,5000);

DROP TABLE emp_second PURGE;

-- default ����.
CREATE TABLE emp_second(
    empno NUMBER(4) PRIMARY KEY,
    ename VARCHAR2(10) NOT NULL,
    sal NUMBER(7,2) DEFAULT 1000
);

INSERT INTO emp_second(empno, ename)
VALUES(8000,'�ֱ��');

SELECT * FROM emp_second;


-- ���� ������ ����.
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
-- SEQUENCE�� �⺻Ű�� ������ ���� ������
-- ����ڰ� ���� ������ ���� �δ㰨�� �ٿ��ִ� ��ü�̴�.

CREATE SEQUENCE sample_seq
 INCREMENT BY 10
 START WITH 10;
 
 
 -- SEQUENCE.nextval ������ ȣ��
 -- SEQUENCE.currval ���� ����� ��

SELECT sample_seq.nextval FROM dual;
 
SELECT sample_seq.currval FROM dual;
 
 -- DEPT �׽�Ʈ��
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


