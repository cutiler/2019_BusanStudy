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
	<h1>공지사항</h1>
	<c:if test="${member.id eq 'admin'}">
		<a href="noticeWriteForm.do">공지글 작성</a>
	</c:if>
	
	<div>
		<!-- 공지글 리스트 -->
		<table border=1>
			<tr>
				<td>글번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
			</tr>
			<c:choose>
				<c:when test="${!empty noticeList}">
					<c:forEach var="n" items="${noticeList}">
						<tr>
							<td>${n.notice_num}</td>
							<td>[${n.notice_category}]${n.notice_title}</td>
							<td>${n.notice_author}</td>
							<td>${n.notice_date}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">등록된 게시물이 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>		
	</div>
	<div>
		<c:forEach var="i" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
		 	${i}
		</c:forEach>
	</div>
</body>
</html>