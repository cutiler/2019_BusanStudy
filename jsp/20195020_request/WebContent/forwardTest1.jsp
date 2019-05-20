<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이동된 페이지(fowardTest1.jsp)</title>
</head>
<body>
<h1>이동된 페이지(fowardTest1.jsp)</h1>
	<table>
			<tr>
				<td>이름</td>
				<td><%=request.getParameter("name") %></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><%=request.getParameter("age") %></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><%=request.getParameter("addr") %></td>
			</tr>
			<tr>			
				<td></td>
			</tr>
		</table>
</body>
</html>