package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;

import util.DBCPUtil;

@WebServlet("*.mb")
public class MemberController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	MemberService service = new MemberService();	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController GET 요청");
		
		request.setCharacterEncoding("UTF-8");
		
		MemberService.loginCheck(request);
		
		String requestPath = request.getRequestURI();
		System.out.println("전체 요청 경로 : " + requestPath);
		String contextPath = request.getContextPath();
		System.out.println("요청 프로젝트 경로 : " + contextPath);
		String command = requestPath.substring(contextPath.length());
		System.out.println("실제 요청(command) 경로 : " + command);
		
		String nextPage ="";
		
		if(command.equals("/login.mb")) {
			System.out.println("로그인 화면 요청");
			nextPage = "/member/login.jsp";
		}
		
		if(command.equals("/memberLogin.mb")) {
			System.out.println("로그인 처리 요청");
			if(service.memberLogin(request, response)) {
				response.sendRedirect(request.getContextPath()+"/test");
				System.out.println("로그인 성공");
			}else {
				response.sendRedirect(request.getContextPath()+"/login.mb");
				System.out.println("로그인 실패");
			}
		}
		
		if(command.equals("/join.mb")) {
			System.out.println("회원가입 화면 요청");
			nextPage = "/member/join.jsp";
		}
		
		if(command.equals("/memberJoin.mb")) {
			System.out.println("회원가입 처리 요청");
			service.memberJoin(request, response);
		}
		
		if(command.equals("/info.mb")) {
			System.out.println("회원정보 요청");
			nextPage="/member/info.jsp";
		}
		
		if(command.equals("/logOut.mb")) {
			service.logOut(request,response);
			nextPage="/common/main.jsp";
		}
		
		
		if(nextPage != null && !nextPage.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

