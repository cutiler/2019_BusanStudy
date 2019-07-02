<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>메인 페이지 입니다.</h1>
<c:set var="pageSelect" value="${param.page}"/>
<c:out value="${pageSelect}"/>
