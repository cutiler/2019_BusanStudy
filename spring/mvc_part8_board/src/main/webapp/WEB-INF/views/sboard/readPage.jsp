<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/upload.js"></script>
<style>
	.uploadedList{
		width:100%;
	}
	
	.uploadedList li{
		float:left;
		padding:20px;
	}
	
	ul li{		
		list-style:none;
	}
	
	.clear{
		clear:both;
	}
	
	#pagination li{
		float: left;
		padding: 10px;
	}

</style>
</head>
<body>
<h1>READ PAGE</h1>
<table border=1>
	<tr>
		<td>제목</td>
		<td>${boardVO.title}</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${boardVO.writer}</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>${boardVO.content}</td>
	</tr>
</table>
<div>
	<hr/>
	<div>
		<ul class="uploadedList">
		</ul>
	</div>
	<hr class="clear"/>
	<div>
		<c:if test="${!empty userInfo}">
			<c:if test="${userInfo.uno eq boardVO.uno}">
				<input type="button" id="modifyBtn" value="MODIFY"/>
				<input type="button" id="deleteBtn" value="DELETE"/>
			</c:if>
		<input type="button" id="replyBtn" value="REPLY"/>
		</c:if>
		<input type="button" id="listBtn" value="LIST"/>
		
		<form id="readForm" method="post">
			<input type="hidden" name="bno" value="${boardVO.bno}"/>
		</form>
		
	</div>
</div>
<br/>
<hr/>
<br/>
<div>
	<c:if test="${!empty userInfo}">
		<table border=1>
			<tr>
				<th colspan=2>ADD NEW COMMENT</th>
			</tr>
			<tr>
				<td>COMMENT AUTH</td>
				<td><input type="text" id="newCommentAuth" value="${userInfo.uname}" readonly/></td>
			</tr>
			<tr>
				<td>COMMENT TEXT</td>
				<td><input type="text" id="newCommentText" /></td>
			</tr>
			<tr>
				<td colspan=2><input type="button" id="commentAddBtn"  value="ADD COMMENT"/></td>
			</tr>
		</table>
	</c:if>
</div>
<br/>
<hr/>
<br/>
<div>
	<ul id="comments">
	</ul>
</div>
<div>
	<ul id="pagination"></ul>
</div>

<script>
	var bno = ${boardVO.bno};
	var commentPage = 1;
	
	getPageList(commentPage);
	
	String.prototype.replaceAll = function(old, dest){
		return this.split(old).join(dest);
	}
	
	// < &lt; > &gt;
	function changeEscape(text){
		var result = "";
		result = text.replaceAll("<","&lt;");
		result = result.replaceAll(">","&gt;");
		result = result.replaceAll("\"","'");
		return result;
	}
	
	// 작성자 확인
	function isCheckAuth(uno){
		var userUno = "${userInfo.uno}";
		console.log(userUno+"//"+uno);
		if(userUno != "" && userUno == uno){
			return true;
		}else {
			return false;
		}
	}
	
	function getDate(timeValue){
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth()+1;
		var date = dateObj.getDate();
		var hour = dateObj.getHours();
		var minute = dateObj.getMinutes();
		var seconds = dateObj.getSeconds();
		return year+"/"+month+"/"+date+" "+hour+":"+minute+":"+seconds;
	}
	
	// 페이징 처리된 댓글 목록
	function getPageList(page){
		// 해당 게시물의 페이징 처리된 댓글 목록
		// 페이징 블럭 정보
		commentPage = page;
		$.getJSON("/comments/"+bno+"/"+page,function(data){
			// data == Map
			console.log(data);
			// list 작성
			console.log(data.list);
			// 블럭처리
			console.log(data.pageMaker);
			
			var str = "";
			
			$(data.list).each(function(){
				// this == CommentVO
				console.log(this.commentText);
				var text = changeEscape(this.commentText);
				console.log(text);
				str += '<li data-cno="'+this.cno+'" ';
				str += 'data-text="'+text+'" class="commentLi">';
				str += '작성자 : '+ this.commentAuth + '- 작성시간: '+getDate(this.updatedate);
				str += ' 내용 : '+ text;
				if(isCheckAuth(this.uno)){
					str += ' - <button>MODIFY</button>';
				}
				str += '</li><li>--------------------------------</li>';
			});
			
			$("#comments").html(str);
			printPage(data.pageMaker);
		});
	}
	
	function printPage(pageMaker){
		var str = "";
		
		if(pageMaker.prev){
			str += "<li><a href='"+(pageMaker.startPage-1)+"'> << </a></li>";
		}
		for(var i=pageMaker.startPage; i<= pageMaker.endPage; i++){
			str += "<li><a href='"+i+"'> "+i+" </a></li>";
		}
		if(pageMaker.next){			
			str += "<li><a href='"+(pageMaker.endPage+1)+"'> << </a></li>";
		}

		
		$("#pagination").html(str);
	}
	
	$("#pagination").on("click","li a",function(event){
		event.preventDefault();
		var page = $(this).attr("href");
		getPageList(page);
		
	});
	
	// 댓글 등록
	
	// bno auth text uno
	
	$("#commentAddBtn").click(function(){
		var commentAuth = $("#newCommentAuth").val();
		var commentText = $("#newCommentText").val();
		
		$.ajax({
			type : "post",
			url : "/comments/add",
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : "text",
			data : JSON.stringify({
				bno : bno,
				commentAuth : commentAuth,
				commentText : commentText,
				uno : "${userInfo.uno}"
			}),
			success : function(data){
				alert(data);
				getPageList(1);
				$("#newCommentText").val("");
				$("#newCommentText").focus();
			} 
		});
		
		
	});
	
	

	$.getJSON("/sboard/getAttach/"+bno,function(data){
		console.log(data);
		$(data).each(function(){
			var fileInfo = getFileInfo(this);
			console.log(fileInfo);
			var html = "<li>";
				html += "<span>";
				html += "<img src='"+fileInfo.imgSrc+"' alt='attachment'/>";
				html += "</span>";
				html += "<div>";
				html += "<a href='"+fileInfo.getLink+"' target='blank'>";
				html += fileInfo.fileName;
				html += "</a>";
				html += "</div></li>";
			$(".uploadedList").append(html);
		});
	});

	

	var obj = $("#readForm");
	
	$("#replyBtn").click(function(){
		obj.attr("action","/sboard/replyRegister");
		obj.attr("method","get");
		obj.submit();
	});
	
	$("#listBtn").click(function(){
		obj.attr("action","/sboard/listReply");
		obj.attr("method","get");
		obj.submit();
	});
	
	$("#modifyBtn").click(function(){
		obj.attr("action","/sboard/modifyPage");
		obj.attr("method","get");
		obj.submit();
	});
	
	$("#deleteBtn").click(function(){
		var isDelete = confirm("첨부된 내용과 댓글이 모두 삭제 됩니다. 삭제하시겠습니까?");
		if(isDelete){
			console.log("삭제 요청");
			// 삭제 처리
		}else{
			alert("삭제 요청이 취소 되었습니다.");
		}
	});
</script>
</body>
</html>










