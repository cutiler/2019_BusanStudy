<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="loginMember" class="vo.MemberVO" scope="page" />
<jsp:setProperty property="*" name="loginMember" />

<jsp:useBean id="joinMember" class="vo.MemberVO" scope="application" />
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN CHECK JSP</title>
</head>
<body>
	<%
		if(joinMember.getId() != null 
			&& 
		loginMember.getId().equals(joinMember.getId())
			&&
		loginMember.getPass().equals(joinMember.getPass())
		){
			session.setAttribute("loginMember", loginMember);
			
			Cookie cookie = new Cookie("id",loginMember.getId());
			cookie.setMaxAge(60*60*24*30);
			response.addCookie(cookie);
			
			
			out.print("<script>alert('로그인 성공');location.href='index.jsp';</script>");
		}else{
			out.print("<script>alert('로그인 실패');location.href='login.jsp';</script>");			
		}
	%>

</body>
</html>