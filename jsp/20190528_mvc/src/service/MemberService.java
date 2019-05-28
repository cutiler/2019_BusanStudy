package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

public class MemberService {
	
	MemberDAO dao = new MemberDAO();	
	
	public boolean memberLogin(
			HttpServletRequest request,
			HttpServletResponse response) {
		boolean isLogin = false;
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String login = request.getParameter("login");
		
		MemberVO member = dao.memberLogin(id,pass);
		
		if(member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			if(login != null) {
				Cookie cookie = new Cookie("id",member.getId());
				cookie.setMaxAge(60*60*24*7);
				cookie.setPath("/");
				response.addCookie(cookie);
			}			
			isLogin = true;
		}else {
			isLogin = false;
		}		
		return isLogin;
	}
	
	public void memberJoin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		
		MemberVO member = new MemberVO(id,pass,name,age,gender);
		
		boolean isSuccess = dao.memberJoin(member);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String url = "login.mb";
		out.println("<script>");
		if(isSuccess) {
			out.print("alert('회원가입 성공');");
		}else {
			out.print("alert('회원가입 실패');");
			url="join.mb";
		}
		out.print("location.href='"+url+"';");
		out.println("</script>");
	}
	
	// static이라서 전역변수 dao 사용불가. 
	public static void loginCheck(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(int i=0; i < cookies.length;i++){
				if(cookies[i].getName().equals("id")) {
					String id = cookies[i].getValue();
					MemberDAO dao = new MemberDAO();
					MemberVO member = dao.getMemberById(id);
					if(member != null) {
						HttpSession session = request.getSession();
						session.setAttribute("member", member);
					}
				}
			}
		}
		
	}

	
	public void logOut(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(int i=0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("id")) {
					Cookie cookie = new Cookie("id","");
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
					System.out.println("Cookie 삭제 완료");
				}
			}
		}
		
	}
	
	
}
