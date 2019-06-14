<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>listPage</title>
<script src="http://code.jQuery.com/jQuery-latest.min.js"></script>
<script>

	$(function(){			
		
		if('${result}' == 'SUCCESS' ){
			alert('처리가 완료 되었습니다.');
		}
		
	});


</script>

</head>
<body>
<h1>Board List</h1>
<form action="/board/register" method="get">
<input type="submit" value="New Board" />
</form>
<h2>LIST PAGING</h2>
<table border=1>
	<tr>
		<th>BNO</th>
		<th>TITLE</th>
		<th>WRITER</th>
		<th>REGDATE</th>
		<th>VIEWCNT</th>
	</tr>
		<c:forEach var="board" items="${boardList}">
		<tr>
			<td>${board.bno}</td>
			<td><a href="/board/readPage?bno=${board.bno}&page=${pageMaker.cri.page}&pagePerNum=${pageMaker.cri.pagePerNum}">${board.title}</a></td>
			<td>${board.writer}</td>
			<td>${board.regdate}</td>
			<td>${board.viewcnt}</td>		
		</tr>
		</c:forEach>
</table>
<c:if test="${pageMaker.prev}">
	<a href="/board/listPage?page=${pageMaker.startPage-pageMaker.displayPageNum}&pagePerNum=${pageMaker.cri.pagePerNum}">&laquo;</a>
</c:if>
<c:forEach var="i" begin="${pageMaker.startPage}" end="${ pageMaker.endPage}" step="1">
	<a href="/board/listPage?page=${i}&pagePerNum=${pageMaker.cri.pagePerNum}">
	${pageMaker.cri.page == i ? [i] : i}
	</a>
</c:forEach>
<c:if test="${pageMaker.next}">
<a href="/board/listPage?page=${pageMaker.endPage+1}&pagePerNum=${pageMaker.cri.pagePerNum}">&raquo;</a>
</c:if>
</body>
</html>