<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
/* 	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String login = request.getParameter("login");	 */
%>
<jsp:useBean id="loginDTO" class="dto.LoginDTO" scope="page"/>
<jsp:setProperty property="*" name="loginDTO"/>

<jsp:getProperty property="login" name="loginDTO"/>


<jsp:useBean id="joinMember" class="vo.MemberVO" scope="application"/>

<%
	if(joinMember.getId() != null && 
		joinMember.getId().equals(loginDTO.getId())
		&& joinMember.getPass().equals(loginDTO.getPass())){
		
		if(loginDTO.isLogin()){
			response.addCookie(util.Cookies.createCookie("id",loginDTO.getId(),60*60*24*7));
			
			/* Cookie cookie = new Cookie("id",loginDTO.getId() );
			cookie.setMaxAge(60*60*24*7);
			response.addCookie(cookie); */
			
		}
		
		session.setAttribute("id",loginDTO.getId());
		out.print("<script>alert('로그인 성공');location.href='index.jsp';</script>");
	}else{
		out.print("<script>alert('로그인 실패');location.href='index.jsp?page=login';</script>");
	}
%>




