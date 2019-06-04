package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.QNABoardService;
import service.QNABoardServiceImpl;
import vo.BoardVO;

@WebServlet("*.bo")
public class QNABoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	QNABoardService service = QNABoardServiceImpl.getInstance();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String requestURI  = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
		System.out.println("요청 URI : " + command);
		
		String nextPage = null;
		
		if(command.equals("boardList.bo")) {
			// 전체 항목
			//ArrayList<BoardVO> list = service.getBoardList();
			// 페이징 처리된 리스트정보
			ArrayList<BoardVO> list = service.getBoardList(request);
			request.setAttribute("boardList", list);
			nextPage = "/board/qna/qna_list.jsp";
		}
		
		if(command.equals("boardWrite.bo")) {
			nextPage = "/board/qna/qna_write.jsp";
		}
		
		if(command.equals("boardWriteSubmit.bo")) {
			System.out.println("게시글 등록 요청");
			service.boardWrite(request);
			
			response.sendRedirect("boardList.bo");
		}
		
		if(command.equals("boardDetail.bo")) {
			System.out.println("게시물 상세보기");
			BoardVO boardVO = service.getBoardVO(request);
			request.setAttribute("boardVO", boardVO);
			nextPage="/board/qna/qna_detail.jsp";
		}
		
		if(command.equals("boardReplyForm.bo")) {
			System.out.println("답변글 작성 화면 요청");
			
			BoardVO boardVO = service.boardReply(request);
			request.setAttribute("boardVO", boardVO);
			nextPage ="/board/qna/qna_reply.jsp";
		}
		
		if(command.equals("boardReplySubmit.bo")) {
			service.boardReplySubmit(request, response);
		}
		
		if(command.equals("boardUpdateForm.bo")) {
			System.out.println("수정 화면 요청");
			BoardVO board = service.getBoardVOByUpdate(request);
			request.setAttribute("boardVO", board);
			nextPage  = "/board/qna/qna_update.jsp";
		}
		
		if(command.equals("boardDeleteForm.bo")) {
			System.out.println("삭제화면요청");
			request.setAttribute("board_num", request.getParameter("board_num"));
			nextPage  = "/board/qna/qna_delete.jsp";
		}
		
		if(command.equals("boardDelete.bo")) {
			System.out.println("삭제 처리 요청");
			service.boardDelete(request, response);
		}
		
		if(command.equals("boardUpdate.bo")) {
			System.out.println("수정처리 요청");
			service.boardUpdate(request, response);
		}
		
		if(command.equals("file_down.bo")) {
			System.out.println("파일 다운로드 요청");
			service.fileDown(request, response);
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
