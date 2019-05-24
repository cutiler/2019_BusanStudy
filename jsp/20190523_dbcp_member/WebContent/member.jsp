<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="vo.*" %>
<%@page import="util.*" %>

<%-- <jsp:include page="checkAdmin.jsp"/> --%>
<%@include file="checkAdmin.jsp" %>

<%
	ArrayList<MemberVO> list = new ArrayList<>();

	Connection conn = DBCPUtil.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try{
		String sql="SELECT num,id,pass,name,addr,phone FROM test_member";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			MemberVO m = new MemberVO();
			m.setNum(rs.getInt(1));
			m.setId(rs.getString(2));
			m.setPass(rs.getString(3));
			m.setName(rs.getString(4));
			m.setAddr(rs.getString(5));
			m.setPhone(rs.getString(6));
			list.add(m);
			//out.println(m.toString()+"<br/>");
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		DBCPUtil.close(rs);
		DBCPUtil.close(pstmt);
		DBCPUtil.close(conn);
	}

%>
<h1>회원목록</h1>
<table border=1>
	<tr>
		<th>회원번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>주소</th>
		<th>전화번호</th>
	</tr>
	<%for(MemberVO m : list){ %>
		<tr onclick="location.href='memberInfo.jsp?num=<%=m.getNum()%>'">
			<td><%=m.getNum()%></td>
			<td><%=m.getId()%></td>
			<td><%=m.getName()%></td>
			<td><%=m.getAddr()%></td>
			<td><%=m.getPhone()%></td>
		</tr>
	<%} %>
</table>



