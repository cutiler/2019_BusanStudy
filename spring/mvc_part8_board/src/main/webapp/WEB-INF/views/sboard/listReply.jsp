<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REPLY BOARD LIST</title>
</head>
<body>
	<div>
		<select name="searchType">
			<option value="n">-------------------</option>
			<option value="t">TITLE</option>
			<option value="c">CONTENT</option>
			<option value="w">WRITER</option>
			<option value="tc">TITLE&CONTENT</option>
			<option value="cw">CONTENT&WRITER</option>
			<option value="tcw">TITLE*CONTENT&WRITER</option>
		</select>
		<input type="text" name="keyword" id="keyword"/>
		<input type="button" id="searchBtn" value="검색"/>
		<input type="button" id="newBtn" value="글작성"/>
	</div>
	<table border=1>
		<tr>
			<th>BNO</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<th>REGDATE</th>
			<th>VIEWCNT</th>
		</tr>
		<!-- 게시글 항목 출력 -->
		<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.bno}</td>
				<td>${board.title}</td>
				<td>${board.writer}</td>
				<td><f:formatDate pattern="yyyy-MM-dd HH:mm" value="${board.regdate}"/></td>
				<td>${board.viewcnt}</td>
			</tr>
		</c:forEach>
		
	</table>
	<!-- paging 블럭 -->

</body>
</html>