<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("UTF-8"); %>
	
	session : <%=session.getAttribute("test") %>
	EL Scope Session : ${sessionScope.test} <br/>
	El session : ${test} <br/>
	
	parameter : <%= request.getParameter("aaa") %> <br/>
	
	EL param : ${param.aaa}
	
	<input type="text" value="${param.aaa}" />
		
</body>
</html>