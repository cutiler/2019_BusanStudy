

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;

@WebServlet("/test")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		MemberService.loginCheck(request);
		
		System.out.println("GET 요청");
		
		/*
		 * PrintWriter out = response.getWriter(); out.print("안녕하세요");
		 */
		
		request.setAttribute("test", "MAIN PAGE");
		
		RequestDispatcher rd = request.getRequestDispatcher("/common/main.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("POST 요청");
		doGet(request, response);
		
	}

}
