<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
	.fileDrop{
		width : 100%;
		height : 200px;
		border : 1px solid blue;
	}
</style>
</head>
<body>
	<h1>upload Ajax</h1>
	<div class="fileDrop">
	</div>
	<div class="uploadList">
	</div>
	
	<script>
		$(".fileDrop").on("dragenter dragover",function(event){
			event.preventDefault();
		});
		
		$(".fileDrop").on("drop",function(event){
			event.preventDefault();
			
			var files = event.originalEvent.dataTransfer.files;
			var file = files[0];
			console.log(file);
			
			var maxSize = 10485760;
			
			if(file.size > maxSize){
				alert("파일의 크기가 너무 큽니다."+file.size);
				return ;
			}
			
			var formData = new FormData();
			formData.append("file",file);
			
			$.ajax({
				type : "post",
				url : "uploadAjax",
				data : formData,
				dataType : "text",
				contentType : false,
				processData : false,
				success : function(data){
					console.log(data);
					var str = "";
					if(checkImageType(data)){
						// 이미지 파일
						//alert(getOriginalName(getImageLink(data)));
						
						str += "<div>";
						str += "<a href='displayFile?fileName="+getImageLink(data)+"' target='_blank'>";
						str += "<img src='displayFile?fileName='"+data+"/>";
						str += "</a>";
						str += "</div>";
						
					}else{
						//일반 파일
						//alert(getOriginalName(data));
						
						str += "<div>";
						str += "<a href='displayFile?fileName="+data+"'>";
						str += getOriginalName(data);
						str += "</a>";
						str += "</div>";
					}
					$(".uploadList").append(str);
				}
			});
			
		});
		
		
		
		
		// 이미지 체크
		function checkImageType(fileName){
			var pattern = /jpg|gif|png|jpeg/i;
			return fileName.match(pattern);
		}
		
		// 원본 파일 이름
		function getOriginalName(fileName){
			var idx = fileName.indexOf("_")+1;
			return fileName.substr(idx);
		}
		
		// 원본 이미지 이름
		function getImageLink(fileName){
			if(!checkImageType(fileName)){
				return;
			}
			console.log(fileName);
			
			return fileName.replace("s_","");
		}
		
		
	</script>
	
	
</body>
</html>