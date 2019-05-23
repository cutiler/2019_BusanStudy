<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="util.*"%>


<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String login = request.getParameter("login");
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String msg = "";
	String nextPage = "";
	
	try{
		con = DBCPUtil.getConnection();
		String sql = "SELECT * FROM test_member WHERE id = ? AND pass = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,pass);
		rs = pstmt.executeQuery();
		
		vo.MemberVO m = null;
		
		if(rs.next()){
			m = new MemberVO();
			m.setNum(rs.getInt("num"));
			m.setId(rs.getString("id"));
			m.setPass(rs.getString("pass"));
			m.setName(rs.getString("name"));
			m.setAddr(rs.getString("addr"));
			m.setPhone(rs.getString("phone"));
		}
		
		if(m != null){
			session.setAttribute("member", m);
			if(login != null){
				response.addCookie(Cookies.createCookie("id",m.getId(),60*60));
			}
			msg = "로그인 성공";			
		}else{
			msg="로그인 실패";
			nextPage ="login";
		}
		
	}catch(Exception e){
		msg="로그인 실패"+e.getMessage();
		nextPage ="login";
	}finally{
		DBCPUtil.close(rs);
		DBCPUtil.close(pstmt);
		DBCPUtil.close(con);
		
		out.print("<script>");
		out.print("alert('"+msg+"');");
		out.print("location.href='index.jsp?page="+nextPage+"'");
		out.print("</script>");
	}
	
	
	
%>