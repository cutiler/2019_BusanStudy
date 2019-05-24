<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.sql.*" %>
<%@page import="util.*" %>
<%@page import="vo.*" %>

<script>
	var isDelete = confirm('회원정보를 삭제 하시겠습니까?');
	if(!isDelete){
		location.href="index.jsp?page=member";
	}
</script>

<%
	request.setCharacterEncoding("UTF-8");
	String num = request.getParameter("num");
	Connection conn = util.DBCPUtil.getConnection();
	PreparedStatement pstmt = null;
	
	String sql = "DELETE FROM test_member WHERE num=?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1,Integer.parseInt(num));
	pstmt.executeUpdate();
	
	util.DBCPUtil.close(pstmt);
	util.DBCPUtil.close(conn);
	
	response.sendRedirect("index.jsp?page=member");
%>

<script>
	alert('삭제완료');
	location.href='index.jsp?page=member';
</script>