<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Header</h1>
	<table border=1>
		<tr>
			<form action="/start" method="post">
				<td onclick="">게임시작</td>
			</form>
			<form action="/end" method="post">
				<td>게임종료</td>
			</form>
		</tr>
	</table>
</body>
</html>