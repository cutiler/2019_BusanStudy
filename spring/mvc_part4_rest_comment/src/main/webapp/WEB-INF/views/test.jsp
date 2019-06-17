<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Comment Test</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div>
		<div>
			commentAuth <input type="text" id="newCommentAuth" />
		</div>
		<div>
			commentText <input type="text" id="newCommentText" />
		</div>
		<button id="commentAddBtn">ADD COMMENT</button>
		<button id="commentListBtn">List ALL</button>
	</div>
	<ul id="comments"></ul>
</body>
</html>