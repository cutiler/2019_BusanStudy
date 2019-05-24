<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <s:setDataSource 
		var="con" 
		driver="oracle.jdbc.driver.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:orcl"
		user="java"
		password="java"/>
	
	<s:update dataSource="${con}">
		INSERT INTO test_member VALUES(test_member_seq.nextval,'id002','id002','최기근','주소','전화번호')
	</s:update> 	 --%>
	
	<c:set var="id" value="id113" />
	<c:set var="pass" value="pw113" />
	
	<s:update dataSource = "jdbc/OracleDB">
		INSERT INTO test_member 
		VALUES(test_member_seq.nextval,'${id}','${pass}','최기근','주소','전화번호')
	</s:update>
	
<%-- <s:query var="rs" dataSource="jdbc/OracleDB">
		SELECT * FROM test_member WHERE id = ? AND pass = ?
		<s:param>${id}</s:param>
		<s:param>${pass}</s:param>
	</s:query> --%>
	
	<s:query var="rs" dataSource="jdbc/OracleDB">
		SELECT * FROM test_member ORDER BY num DESC
	</s:query>
	
	<c:forEach var="data" items="${rs.rows}">
		<c:out value="${data['id']}"/> &nbsp;
		<c:out value="${data['pass']}"/> &nbsp;
		<c:out value="${data['name']}"/> &nbsp;
		<c:out value="${data['addr']}"/> &nbsp;
		<c:out value="${data['phone']}"/> &nbsp;
		<br/>
	</c:forEach>
	
</body>
</html>