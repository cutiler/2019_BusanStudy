<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>

<s:update dataSource="jdbc/OracleDB">
	DELETE FROM iot_member WHERE u_num = ${param.u_num}
</s:update>

<script>
	alert('삭제완료');
	location.href='main.jsp?page=member';
</script>

