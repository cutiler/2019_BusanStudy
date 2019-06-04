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
	<jsp:include page="../../common/header.jsp"/>
	<h1>게시물 상세내용</h1>
	<table>
		<tr>
			<td>작성자</td>
			<td>${boardVO.board_name}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${boardVO.board_title}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<textarea readonly cols=40 rows=10>${boardVO.board_content}</textarea>
			</td>
		</tr>
		<c:if test="${!empty boardVO.board_file}">
		<tr>
			<td>첨부파일</td>
			<td>
			<a href="file_down.bo?board_file=${boardVO.board_file}">
				${boardVO.board_file_origin}
			</a>	
			||
			<a href="upload/${boardVO.board_file}" download="${boardVO.board_file_origin}">
				${boardVO.board_file_origin}
			</a>
			</td>
		</tr>
		</c:if>
		<tr>
			<td colspan=2>
				<a href="boardReplyForm.bo?board_num=${boardVO.board_num}">[답글]</a>
				<a href="boardUpdateForm.bo?board_num=${boardVO.board_num}">[수정]</a>
				<a href="boardDeleteForm.bo?board_num=${boardVO.board_num}">[삭제]</a>
				<a href="boardList.bo">[목록]</a>
			</td>
		</tr>
	</table>
</body>
</html>