<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="util.*"%>
<%
	Cookies cookies = new Cookies(request);
	cookies.removeCookie(response, "id");
	//session.removeAttribute("member");
	session.invalidate();
	response.sendRedirect("index.jsp");
%>
