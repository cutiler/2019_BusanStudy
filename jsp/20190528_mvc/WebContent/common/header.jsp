<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	*{
		padding:0;
		margin:0;
	}
	
	body{
		width:900px;
		margin:auto;
	}
	header{
		border-bottom:1px solid #ccc;
	}
	
	ul{
		list-style:none;
		float:right;
		height:50px;
		line-height:50px;
	}
	ul li{
		float:left;
		padding:10px;
	}
	
	ul li a{
		text-decoration:none;
		color:#000;
	}
	
	ul li a:hover{
		cursor:pointer;
		color:#ccc;
	}
	
	div{
		overflow:hidden;
	}
	
</style>
<header>
	<div>
		<ul>
			<c:choose>
				<c:when test="${!empty member}">
					<li><a href="info.mb">${member.name}</a></li>
					<li><a href="logOut.mb">로그아웃</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="login.mb">로그인</a></li>
					<li><a href="join.mb">회원가입</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</header>