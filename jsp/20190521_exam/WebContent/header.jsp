<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
    
<jsp:useBean id="joinMember" class="vo.MemberVO" scope="application" />
<jsp:useBean id="joinMember2" class="vo.MemberVO" scope="session" />
<%
	/* Cookie[] cookies = request.getCookies();
	
	if(cookies != null){
		for(int i=0; i <cookies.length; i++){
			if(cookies[i].getName().equals("id") ){				
				session.setAttribute("id", cookies[i].getValue());
				break;
			}		
		}
	}
	 */
	util.Cookies cookies = new util.Cookies(request);
	if(cookies.exists("id")){
		session.setAttribute("id", cookies.getValue("id") );
	}
	
	String id = (String)session.getAttribute("id");

%>  

<header>
	<ul>
		<%if( (id != null) && !id.equals("") ){ %>
		<li><a href="index.jsp?page=info"><%=id%></a>님 반갑습니다.</li>
		<li><a href="logOut.jsp">로그아웃</a></li>
		<%}else{ %>
		<li><a href="index.jsp?page=login">로그인</a></li>
		<li><a href="index.jsp?page=join">회원가입</a></li>
		<%} %>
	</ul>
</header>