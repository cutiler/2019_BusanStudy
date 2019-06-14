<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MODIFY BOARD</title>
<script src="http://code.jQuery.com/jQuery-latest.min.js"></script>
<script>

	$(function(){
		
		$("#save").click(function(){			
			$("#readForm").attr("action","/board/modify");			
			$("#readForm").submit();				
		});
		
		$("#cancel").click(function(){
			$("#readForm").attr("action","/board/readUpdate");
			$("#readForm").attr("method","GET");
			$("#readForm").submit();	
		});
		
		
	});
	
</script>
</head>
<body>
<h1>READ BOARD</h1>
<form id="readForm" method="post">
Title<input type="text" name="title" value="${board.title}"/><br/>
Content<textarea rows=3 name="content" >${board.content}</textarea><br/>
Writer<input type="text" name="writer" value="${board.writer}"/><br/>
	
	<input type="button" id="save" value="SAVE"/>
	<input type="button" id="cancel" value="CANCEL"/>	
		<input type="hidden" name="bno" value="${board.bno}"/>		
	</form>
</body>


</html>