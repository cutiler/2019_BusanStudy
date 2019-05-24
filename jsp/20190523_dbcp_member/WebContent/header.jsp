<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@page import="java.sql.*"%>
<%@page import="util.*"%>
<%@page import="vo.*"%>

<%
	Cookies cookies = new Cookies(request);
	if(cookies.exists("id")){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = DBCPUtil.getConnection();
			String sql = "SELECT * FROM test_member WHERE id= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,cookies.getValue("id"));
			rs = pstmt.executeQuery();
			
			MemberVO m = null;
			if(rs.next()){
				m = new MemberVO();
				m.setNum(rs.getInt("num"));
				m.setId(rs.getString("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("name"));
				m.setAddr(rs.getString("addr"));
				m.setPhone(rs.getString("phone"));
				session.setAttribute("member",m);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBCPUtil.close(rs);
			DBCPUtil.close(pstmt);
			DBCPUtil.close(con);
		}
	}
	
	MemberVO sessionMember = (MemberVO)session.getAttribute("member");
	
	
%>


<header>
	<ul>
		<%if(sessionMember != null){ %>
			<li><a href="index.jsp?page=info"><%=sessionMember.getName() %></a>님 방가</li>
			<%if(sessionMember.getId().equals("admin")){ %>
			<li><a href="index.jsp?page=member">회원관리</a></li>
			<%} %>
			<li><a href="index.jsp?page=logOut">로그아웃</a></li>
		<%}else{ %>
			<li><a href="index.jsp?page=login">로그인</a></li>
			<li><a href="index.jsp?page=join">회원가입</a></li>
		<%} %>
		
	</ul>
</header>