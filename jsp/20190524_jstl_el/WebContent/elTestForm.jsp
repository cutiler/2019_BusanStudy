<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL TEST</title>
</head>
<body>
	<%
		pageContext.setAttribute("scopeName","pageContext 영역");
		request.setAttribute("scopeName", "request 영역");
		session.setAttribute("scopeName", "session 영역");
		application.setAttribute("scopeName", "application 영역");
	
	%>
	
	page영역 : <%=pageContext.getAttribute("scopeName")%><br/>
	request영역 : <%=request.getAttribute("scopeName")	%><br/>
	session영역 : <%=session.getAttribute("scopeName")	%><br/>
	application영역 : <%=application.getAttribute("scopeName")	%><br/><br/>
	
	pageContext EL 속성값 : ${pageScope.scopeName} <br/>
	requestContext EL 속성값 : ${requestScope.scopeName} <br/>
	sessionContext EL 속성값 : ${sessionScope.scopeName} <br/>
	applicationContext EL 속성값 : ${applicationScope.scopeName} <br/><br/>
	
	EL : ${scopeName} <br/>
	
	<% session.setAttribute("test","bbb");	%>
	
	<form action="elTest.jsp" method="post">
		<input type="text" name="aaa" />
		<input type="submit" value="확인" />
	</form>
	
	
	
	
	
</body>
</html>