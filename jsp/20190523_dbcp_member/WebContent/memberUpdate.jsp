<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="util.*" %>
<%@page import="vo.*" %>
<%@include file="checkAdmin.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	String num = request.getParameter("num");
	

	Connection conn = DBCPUtil.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	MemberVO m = null;
	
	try{
		
		String sql = "SELECT * FROM test_member WHERE num = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(num));
		rs = pstmt.executeQuery();
		
		m = new MemberVO();
		if(rs.next()){
			m.setNum(rs.getInt(1));
			m.setId(rs.getString(2));
			m.setPass(rs.getString(3));
			m.setName(rs.getString(4));
			m.setAddr(rs.getString(5));
			m.setPhone(rs.getString(6));
		}else{
			out.print("<script>");
			out.print("alert('등록된 회원정보가 없습니다.');");
			out.print("location.href='index.jsp?page=member'");
			out.print("</script>");
		}		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		DBCPUtil.close(rs);
		DBCPUtil.close(pstmt);
		DBCPUtil.close(conn);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>
	<h1>회원정보 수정</h1>
	<form action="updateSubmit.jsp" method="post">
		<table border=1>
			<tr>
				<td>회원번호</td>
				<td><input type="text" name="num" value="<%=m.getNum()%>" readonly/></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="<%=m.getId()%>" readonly/></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="pass" value="<%=m.getPass()%>"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="<%=m.getName()%>" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" value="<%=m.getAddr()%>"/></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" value="<%=m.getPhone()%>"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정완료"/>
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>