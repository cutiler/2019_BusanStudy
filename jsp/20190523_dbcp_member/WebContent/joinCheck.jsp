<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="util.DBCPUtil" %>
<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="joinMember" class="vo.MemberVO" />
<jsp:setProperty property="*" name="joinMember" />

<%=joinMember.toString() %>

<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String msg = "";
	String nextPage = "";
	
	try{
		conn = util.DBCPUtil.getConnection();
		
		// 동일한 아이디 존재 유무 확인
		String sql = "SELECT * FROM test_member WHERE id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,joinMember.getId());
		
		rs = pstmt.executeQuery();
		if(rs.next()){
			out.print("<script>");
			out.print("alert('이미 존재하는 아이디입니다.');");
			out.print("location.href='index.jsp?page=join'");
			out.print("</script>");
			return;
		}
		
		DBCPUtil.close(rs);
		DBCPUtil.close(pstmt);
		
		// 회원 정보 등록		
		sql = "INSERT INTO test_member(num,id,pass,name,addr,phone)"
			+ " VALUES(test_member_seq.nextval,?,?,?,?,?)";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,joinMember.getId());
		pstmt.setString(2,joinMember.getPass());
		pstmt.setString(3,joinMember.getName());
		pstmt.setString(4,joinMember.getAddr());
		pstmt.setString(5,joinMember.getPhone());
		pstmt.executeUpdate();
		msg = "회원가입 완료";
		nextPage = "login";
		
	}catch(Exception e){
		msg = "회원가입 실패";
		nextPage = "join";
		
	}finally{
		DBCPUtil.close(rs);
		DBCPUtil.close(pstmt);
		DBCPUtil.close(conn);
		
		out.print("<script>");
		out.print("alert('"+msg+"');");
		out.print("location.href='index.jsp?page="+nextPage+"'");
		out.print("</script>");
		
	}
%>