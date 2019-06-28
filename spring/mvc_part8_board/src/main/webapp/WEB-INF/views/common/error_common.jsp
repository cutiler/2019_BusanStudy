<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR PAGE</title>
</head>
<body>
	<h1><a href="/">KOREATE MAIN</a></h1>
	
	<h1>${exception.getMessage()}</h1>
	<h1>${exception.message}</h1>
	<ul>	
		<li>${exception}</li>
		<c:forEach var ="stack" items="${exception.getStackTrace()}">
			<li>${stack.toString()}</li>
		</c:forEach>
	</ul>
</body>
</html>