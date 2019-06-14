<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>READ BOARD</title>
<script src="http://code.jQuery.com/jQuery-latest.min.js"></script>
<script>

	$(function(){
		
		$("#modify").click(function(){			
			$("#readForm").attr("action","/board/modify");
			$("#readForm").attr("method","GET");
			$("#readForm").submit();				
		});
		
		$("#remove").click(function(){
			$("#readForm").attr("action","/board/remove");
			$("#readForm").submit();
		});
		
		$("#list").click(function(){
			$("#readForm").attr("action","/board/listPage");
			$("#readForm").attr("method","GET");
			$("#readForm").submit();		
		});
		
	});
	
</script>
</head>
<body>
<h1>READ BOARD</h1>
Title<input type="text" name="title" value="${board.title}" readonly/><br/>
Content<textarea rows=3 name="content" readonly>${board.content}</textarea><br/>
Writer<input type="text" name="writer" value="${board.writer}" readonly/><br/>

	<input type="button" id="modify" value="Modify"/>
	<input type="button" id="remove" value="REMOVE"/>
	<input type="button" id="list" value="GO LIst"/>
	<form id="readForm" method="POST">
		<input type="hidden" name="bno" value="${board.bno}"/>
		<input type="hidden" name="page" value="${cri.page}"/>
		<input type="hidden" name="pagePerNum" value="${cri.pagePerNum}"/>		
	</form>
</body>


</html>