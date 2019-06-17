<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Javascript Test</h1>
	<input type="button" id="testBtn" value="testBtn"/>
	<div id="box"></div>
	<div id="box2"></div>
	
	<script>
		/* window.onlaod = function(){}; */
		
		(function(){
			var httpRequest;
			document.getElementById("testBtn").onclick = function(){
				makeRequest("getSample");
			};
			
			function makeRequest(url){
				httpRequest = new XMLHttpRequest();
				if(!httpRequest){
					alert("XMLHtp 인스턴스가 없습니다.");
					return false;
				}
				
/* 				httpRequest.open('GET',url+"?name=최기근&age=20");
				httpRequest.setRequestHeader('Content-Type','application/json');
				httpRequest.onreadystatechange = receiveContent;
				httpRequest.send();		 */
				
				httpRequest.open('POST',url);
				httpRequest.setRequestHeader('Content-Type','application/json');
				httpRequest.onreadystatechange = receiveContent;
				httpRequest.send('{"name":"최기근","age":"25"}');
			}
			
			function receiveContent(){
				/*  
					0 == request 초기화 되지 않음
					1 == 서버와의 연결이 성사됨
					2 == request요청을 서버가 받음
					3 == request(요청)를 서버가 처리중
					4 == request에 대한 처리가 끝났고 응답할 준비가 완료됨
				*/
				
				if(httpRequest.readyState === 4 ){
					// 정상처리 코드가 왔을때
					if(httpRequest.status === 200){
						alert(httpRequest.responseText);
						
						var obj = JSON.parse(httpRequest.responseText);						
						/* alert("name : "+ obj.name +" / age : "+obj.age);
						var html="<table border=1>";
						html += "<tr>";
						html += "<th>이름</th>";
						html += "<th>나이</th>";
						html += "</tr>";
						html += "<tr>";
						html += "<td>"+obj.name+"</td>";
						html += "<td>"+obj.age+"</td>";
						html += "</tr>";
						html +="</table>";
						document.getElementById("box").innerHTML = html; */
						
						var html="<table border=1>";
						html += "<tr>";
						html += "<th>이름</th>";
						html += "<th>나이</th>";
						html += "</tr>";
						for(var i=0; i<obj.length; i++){
							html += "<tr>";
							html += "<td>"+obj[i].name+"</td>";
							html += "<td>"+obj[i].age+"</td>";
							html += "</tr>";
							}
						html +="</table>";
						document.getElementById("box").innerHTML = html;
						
					}
				}
			}
			
		})();
	</script>
	
</body>
</html>