<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../../common/header.jsp" />
	<h1>글작성</h1>
	<form action="" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="board_name"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="board_pass"/></td>
			</tr>
			<tr>
				<td>글제목</td>
				<td><input type="text" name="board_title"/></td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td>
					<textarea name="board_content" cols=50 rows=10></textarea>					
				</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<input type="file" name="board_file" />
				</td>
			</tr>
			<tr>
				<td colspan=2>
					<input type="submit" name="작성완료"/>
					<input type="reset" name="새로작성"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>