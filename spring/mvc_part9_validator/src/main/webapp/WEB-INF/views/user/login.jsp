<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<style>
	.error{
		color:red;
	}

</style>

<div class="container">
	<form id="LoginForm" action="${path}/user/login" method="post">
		<table class="container table tabled-bordered">
			<tr>
				<th colspan=2><h1>LOGIN PAGE</h1></th>
			</tr>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" class="form-control" name="u_id" id="u_id" />
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" class="form-control" name="u_pw" id="u_pw" />
				</td>
			</tr>
			<tr>
				<td colspan="2" class="text-center">
					<label>
						<input type="checkbox" name="rememberme" id="rememberme"/>
						로그인정보 저장
					</label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" class="form-control btn btn-primary" id="loginBtn" value="로그인"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<lable>
					<input type="button" class="form-control btn btn-primary" id="loginBtn" onclick="location.href='${path}/user/join';" value="회원가입"/>
				</lable>
			</tr>			
		</table>	
	</form>
</div>

<script>
 
$("#LoginForm").validate({
		rules : {
			u_id : {
				required : true,
				email : true,
			},
			u_pw : {
				required : true,
				minlength : 6,
				maxlength : 20
			}
		}, messages: {
			u_id : {
				required : "아이디를 입력하세요",
				email : "올바른 이메일을 입력하세요.",
			},
			u_pw : {
				required : "비밀번호를 입력하세요",
				minlength : "비밀번호는 최소 6자리 이상입니다.",
				maxlength : "비밀번호는 최대 20자리 입니다."
			}
			
		}
});
 
</script>

</body>
</html>