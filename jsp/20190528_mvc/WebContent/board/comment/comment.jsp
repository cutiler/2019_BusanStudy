<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	textarea{
		border:none;
		resize:none;
		outline:0;
		font-size:1.1em;
		color:#333;	
	}
	
	.commentWrap{
		width:100%;
		border:1px solid #ddd;
		padding:15px;
		margin-top:15px;
	}
	
	.commentWrite{
		border:1px solid #CCC;
	}
	
	.commentWrite textarea{
		float:left;
		height:70px;
		padding:5px;
		width:85%;
	}
	
	.commentWrite input[type='submit']{
		float:right;
		width:13%;
		height:80px;
		font-weight:bold
	}
	
	.pagingWrap{
		width: 100%;
		text-align: center;
		margin-top:15px;
		margin-bottom:50px;
	}

</style>
<c:if test="${!empty member}">
	<div class="commentWrap">		
		<h3>댓글 작성</h3>
		<br/>
		<div class="commentWrite">
			<form action="commentWrite.bo" method="post">
				<input type="hidden"  name="id" value="${member.id}"/>
				<input type="hidden"  name="name" value="${member.name}"/>
				<input type="hidden"  name="board_num" value="${boardVO.board_num}"/>
				<textarea name="comment_content" required></textarea>
				<input type="submit" value="등록"/>			
			</form>
		</div>
	</div>
</c:if>
<c:if test="${!empty commentList}">
<!--  댓글 목록 -->
<h3>댓글 목록[${pageMaker.listCount}]</h3>
<c:forEach var="comment" items="${commentList}">
	<c:if test="${!empty member && member.id eq comment.comment_id}">
	<form action="commentDelete.bo" method="post">
		<input type="hidden" name="comment_num" value="${comment.comment_num}"/>
		<input type="hidden" name="board_num" value="${boardVO.board_num}"/>
		<input type="submit" value="X" />
	</form>
	</c:if>
	<div>
		${comment.comment_name}&nbsp;&nbsp;|&nbsp;&nbsp;${comment.comment_date}
	</div>
	<div>
		<textarea readonly>${comment.comment_content}</textarea>
	</div>
</c:forEach>
<div class="pagingWrap">
	<c:forEach var="i" begin="${pageMaker.startPage}" end="${pageMaker.endPage}" step="1">
		<a href="boardDetail.bo?board_num=${boardVO.board_num}&page=${i}">[${i}]</a>
	</c:forEach>
</div>
</c:if>