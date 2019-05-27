<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<c:set var="res" value="<%=response%>" />

<jsp:useBean id="cookies" class="util.Cookies" />

<jsp:setProperty property="cookieMap" name="cookies" value="<%=request.getCookies()%>" />

<c:out value="${cookies.removeCookie(res,'id')}" />

<c:remove var="member" scope="session"/>

<script>
	alert('로그아웃 완료');
	location.href='main.jsp';
</script>