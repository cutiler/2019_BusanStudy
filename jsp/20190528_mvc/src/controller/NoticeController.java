package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticeService;
import service.NoticeServiceImpl;

@WebServlet("*.do")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	NoticeService service = new NoticeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestUri.substring(contextPath.length()+1);
		System.out.println("공지 Controller 요청 정보 : " + command);
		
		String nextPage = null;
		
		boolean isSuccess = false;
		
		// 요청 처리 성공시 보여줄 화면
		String suc = "/board/notice/notice_success.jsp";
		// 요청 처리 실패시 보여줄 화면
		String fail = "/board/notice/notice_fail.jsp";
		
		if(command.equals("notice.do")) {
			System.out.println("공지사항 목록 화면 요청");
			service.noticeList(request);
			nextPage = "/board/notice/notice_list.jsp";
		}
		
		if(command.equals("noticeWriteForm.do")) {
			System.out.println("공지 작성 페이지 요청");
			nextPage = "/board/notice/notice_write.jsp";
		}
		
		if(command.equals("noticeWrite.do")) {
			System.out.println("공지글 등록 요청");
			isSuccess = service.noticeWrite(request, response);
			if(isSuccess) {
				nextPage = suc;
			}else {
				nextPage = fail;
			}
		}
		
		
		if(nextPage != null) {
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(fail);
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
