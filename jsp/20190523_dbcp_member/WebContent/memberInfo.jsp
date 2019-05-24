<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="util.*" %>
<%@page import="vo.*" %>    
<%@include file="checkAdmin.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	String num = request.getParameter("num");

	MemberVO m = null;
	
	Connection conn = DBCPUtil.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try{
		
		String sql = "SELECT * FROM test_member WHERE num = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,Integer.parseInt(num));
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
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보</h1>
	<table border=1>
		<tr>
			<td>회원번호</td>
			<td><%=m.getNum() %></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><%=m.getId() %></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=m.getName() %></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><%=m.getAddr() %></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%=m.getPhone() %></td>
		</tr>
		<tr>
			<td colspan="2">
				<a href='memberUpdate.jsp?num=<%=m.getNum()%>'>수정</a>
				<a href='memberDelete.jsp?num=<%=m.getNum()%>' onclick='memberDelete(<%=m.getNum()%>)'>삭제</a>
			
			</td>			
		</tr>
	</table>
	<script>
		function memberDelete(num){
			var isDelete = confirm('회원정보를 삭제 하시겠습니까?');
			if(!isDelete){
				location.href="memberDelete.jsp?num="+num;
			}
		}
	
</script>
</body>
</html>