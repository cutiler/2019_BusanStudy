<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="joinMember" class="vo.MemberVO" scope="application"/>	
<table class="info">
	<tr>
		<td>아이디</td>
		<td><jsp:getProperty property="id" name="joinMember"/></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><jsp:getProperty property="pass" name="joinMember"/></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><jsp:getProperty property="name" name="joinMember"/></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><jsp:getProperty property="addr" name="joinMember"/></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><jsp:getProperty property="phone" name="joinMember"/></td>
	</tr>
	<tr>
		<td colspan=2><input type="button" value="메인"
			onclick="location.href='index.jsp'" /></td>
	</tr>
</table>