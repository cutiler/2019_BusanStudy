<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@page import="com.cutiler.tetris.exam.TetrisArray" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TetrisBoardExam</title>
</head>
<body>
<%
	TetrisArray tetrisArray = new TetrisArray();
	tetrisArray.init();
 %>

	<table border = 1>
			<%
				for(int i = 0; i < tetrisArray.getMaxRow(); i++){					
			%>
			<tr>
			
				<%
					for(int j =0; j < tetrisArray.getMaxColumn(); j++){				
				%>
				<td>
					<%
						if(tetrisArray.board[i][j] == 0) {
					%>
						&nbsp;
					<%
						}else if(i > 4){
					%>
						X
					<%	
						}
					%>
				</td>	
				<%
					}
				
				%>
			</tr>
			<%
				}
			%>
	</table>

</body>
</html>