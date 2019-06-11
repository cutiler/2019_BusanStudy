<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp"/>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">게시글 목록</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th>BNO</th>
							<th>TITLE</th>
							<th>WRITER</th>
							<th>REGDATE</th>
							<th>VIEWCNT</th>
						</tr>
						<!-- 내용 -->
						<c:forEach var="board" items="${boardList}">
							<tr>
								<td>${board.bno}</td>
								<td>${board.title}</td>
								<td>${board.writer}</td>
								<td><f:formatDate pattern="yyyy-MM-dd HH:mm" value="${board.regdate}" /></td>
								<td><span class="bodge bg-red">${board.viewcnt}</span></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="box-footer">
					<!-- bottom -->
				</div>
			</div>
		</div>
	</div>

</section>
<jsp:include page="../include/footer.jsp" />