<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="util.*"%>
<%@include file="checkAdmin.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="updateMember" class="vo.MemberVO" />
<jsp:setProperty property="*" name="updateMember" />

<%
	Connection conn = DBCPUtil.getConnection();
	PreparedStatement pstmt = null;
	
	try{
		String sql = "UPDATE test_member SET "
					+" pass = ? ,"
					+" name = ? ,"	
					+" addr = ? ,"
					+" phone = ?"
					+" WHERE num = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,updateMember.getPass());
		pstmt.setString(2,updateMember.getName());
		pstmt.setString(3,updateMember.getAddr());
		pstmt.setString(4,updateMember.getPhone());
		pstmt.setInt(5,updateMember.getNum());
		pstmt.executeUpdate();
		
	}catch(Exception e){
		
	}finally{
		DBCPUtil.close(pstmt);
		DBCPUtil.close(conn);
		response.sendRedirect("index.jsp?page=member");
	}
%>