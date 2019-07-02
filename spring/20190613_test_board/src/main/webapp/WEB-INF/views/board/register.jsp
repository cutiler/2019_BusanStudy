<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body>
<h1>REGISTER BOARD</h1>
<form method="POST">
	Title <input type="text" name="title" required /><br/>
	Content<textarea rows=4 name="content" ></textarea><br/>
	Writer<input type="text" name="writer" required /><br/>
	<input type="submit" value="Submit"/>
</form>


</body>
</html>