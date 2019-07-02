package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.QNABoardDAO;
import dao.QNABoardDAOImpl;
import util.OraclePageMaker;
import vo.BoardVO;
import vo.CommentVO;

public class QNABoardServiceImpl implements QNABoardService{
	
	private static QNABoardServiceImpl boardService;
	
	private QNABoardServiceImpl() {}
	
	public static QNABoardServiceImpl getInstance() {
		if(boardService == null) {
			boardService = new QNABoardServiceImpl();
		}
		return boardService;
	}	
	
	QNABoardDAO dao = QNABoardDAOImpl.getInstance();

	@Override
	public ArrayList<BoardVO> getBoardList() {
		return null;
	}

	@Override
	public ArrayList<BoardVO> getBoardList(HttpServletRequest request) {
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int listCount = dao.getListCount();
		
		OraclePageMaker pageMaker = new OraclePageMaker(page,listCount);
		pageMaker.setPageCount(5);
		
		request.setAttribute("pageMaker", pageMaker);
		System.out.println(pageMaker);
		return dao.getBoardList(pageMaker);
	}

	// 새글 등록
	@Override
	public void boardWrite(HttpServletRequest request) {
		String saveDir = "/upload";
		
		try {
			String realPath = request.getSession().getServletContext().getRealPath(saveDir);
			System.out.println("realPath : " + realPath);
			
			MultipartRequest multi = new MultipartRequest(
					request,
					realPath,
					1024*1024*10,
					"utf-8",
					new DefaultFileRenamePolicy()
			);
			
			BoardVO board = new BoardVO();
			String board_name = multi.getParameter("board_name");
			String board_pass = multi.getParameter("board_pass");
			String board_title = multi.getParameter("board_title");
			String board_content = multi.getParameter("board_content");
			
			String file = (String)multi.getFileNames().nextElement();
			String board_file = multi.getFilesystemName(file);
			String board_file_origin = multi.getOriginalFileName(file);
			
			board.setBoard_name(board_name);
			board.setBoard_pass(board_pass);
			board.setBoard_title(board_title);
			board.setBoard_content(board_content);
			board.setBoard_file(board_file);
			board.setBoard_file_origin(board_file_origin);		
			
			dao.boardWrite(board);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public BoardVO getBoardVO(HttpServletRequest request) {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		dao.updateReadCount(board_num);
		return dao.getBoardVO(board_num);
	}

	@Override
	public void fileDown(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("file_down 요청");
		try {
			String realPath = request.getServletContext().getRealPath("/upload");
			String file_name = request.getParameter("board_file");
			System.out.println(file_name);
			String filePath = realPath+File.separator+file_name;
			System.out.println("filePath : "+filePath);
			String mimeType = request.getServletContext().getMimeType(filePath);
			System.out.println("mimeType : "+mimeType);
			
			if(mimeType == null) {
				// 8비트 바이너리 배열을 의미
				// http 또는  이메일 상에서 application 형식이 지정되지 않았거나 형식을 모를때 사용
				// 브라우저는 octet-stream 으로 MIME타입이 지정된 경우 
				// 단지 바이너리 데이터로서 다운로드만 가능하게 처리
				mimeType="application/actet-stream";
			}
			
			response.setContentType(mimeType);
			
			// 사용자의 브라우저 정보 확인.
			String agent = request.getHeader("User-Agent");
			System.out.println("agent : " + agent);
			
			boolean isBrowser = (agent.indexOf("MSIE") > -1 || agent.indexOf("Trident") > -1);
			System.out.println("isBrowser : " + isBrowser);
			// 브라우저에 따라 한글 파일명 인코딩을 지정한다.
			if(isBrowser) {
				// 인터넷 익스플러러 일 경우 인코딩을 URL이 알아먹을수 있는 인코딩으로 변경하고
				// 공백 표현을 이스케이프 문자열을 이용 하여 변환 해준다.
				// 파일이름의 공백이 생길경우 공백에 + 가 삽입되는데 그걸 공백 출력형태로 변경해준다.
				// ASCII코드를 16진수화한 결과를 두자리의 대문자 -> %20(0x20)은 공백(space)을 의미 
				file_name = URLEncoder.encode(file_name,"utf-8").replaceAll("\\+", "%20");
				/*
				 * URLEncoder 클래스는 운영체제마다 일부 문자를 인식하는 방식이 다르기 때문 URLEncoder 클래스는 일반 문자열을 웹에서
				 * 통용되는 'x-www-form-urlencoded' 형식으로 변환하는 역할을 담당
				 * 그럴경우 공백을 +로 표현하기때문에 + 를 공백으로 변환한다.
				 */
				
			}else {
				// 아닐 경우 브라우저에 인코딩된 (우리가 사용하는) utf-8 형태의 url값을
				// latin1 형태의 iso-8859-1 형태로 변환한다. 
				file_name = new String(file_name.getBytes("utf-8"),"iso-8859-1");
			}
			// 프로젝트 워크스페이스 인코딩이 utf-8이기 때문에 한글이 깨진 형태로 보이지만
			// 응답 객체를 통해 헤더에 노출이 될때는 브라우저에서 인식하는 ISO-8859-1 타입으로
			// 나타내어 정상적으로 한글 파일이 노출된다.
			System.out.println(file_name);
			
			// Content-disposition 헤더는 본문 부분에 대한 표시 정보를 제공
			// 이 헤더를 첨부 파일에 추가하여 첨부 파일의 본문 부분을 표시할지(inline)
			// 복사할 파일 이름으로 표시할지(attachment) 
			response.setHeader("Content-Disposition", "attachment;fileName="+file_name);
			// 본문을 바로 표시
			//response.setHeader("Content-Disposition", "inline");
			
			// 이하 파일 정보를 읽어와 출력하는 내용
			FileInputStream fis = new FileInputStream(filePath);
			OutputStream out = response.getOutputStream();
			int numRead;
			
			byte[] bytes = new byte[4096];
			while((numRead = fis.read(bytes,0, bytes.length)) != -1) {
				out.write(bytes,0,numRead);
			}
			out.flush();
			out.close();
			fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public BoardVO boardReply(HttpServletRequest request) {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		return dao.getBoardVO(board_num);
	}

	@Override
	public void boardReplySubmit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String board_name = request.getParameter("board_name");
		String board_pass = request.getParameter("board_pass");
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		int board_re_ref = Integer.parseInt(request.getParameter("board_re_ref"));
		int board_re_lev = Integer.parseInt(request.getParameter("board_re_lev"));
		int board_re_seq = Integer.parseInt(request.getParameter("board_re_seq"));
		
		BoardVO board = new BoardVO();
		board.setBoard_num(board_num);
		board.setBoard_name(board_name);
		board.setBoard_pass(board_pass);
		board.setBoard_title(board_title);
		board.setBoard_content(board_content);
		board.setBoard_re_ref(board_re_ref);
		board.setBoard_re_lev(board_re_lev);
		board.setBoard_re_seq(board_re_seq);
		
		dao.boardReplySubmit(board);
		
		response.sendRedirect("boardList.bo");
	}

	@Override
	public BoardVO getBoardVOByUpdate(HttpServletRequest request) {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		return dao.getBoardVO(board_num);
	}

	@Override
	public void boardUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String board_name = request.getParameter("board_name");
		String board_pass = request.getParameter("board_pass");
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		
		BoardVO board = new BoardVO();
		board.setBoard_num(board_num);
		board.setBoard_name(board_name);
		board.setBoard_pass(board_pass);
		board.setBoard_title(board_title);
		board.setBoard_content(board_content);
		
		dao.boardUpdate(board);
		System.out.println(board);
		response.sendRedirect("boardDetail.bo?board_num="+board_num);
		
	}

	@Override
	public void boardDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String board_pass = request.getParameter("board_pass");
		
		boolean isSuccess = dao.boardDelete(board_num, board_pass);
		if(isSuccess) {
			response.sendRedirect("boardList.bo");
		}else {
			response.sendRedirect("boardDeleteForm.bo?board_num="+board_num);
		}
		
		
	}

	@Override
	public void insertComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String comment_content = request.getParameter("comment_content");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		CommentVO cv = new CommentVO();
		cv.setComment_board_num(board_num);
		cv.setComment_id(id);
		cv.setComment_name(name);
		cv.setComment_content(comment_content);
		
		boolean isSuccess = dao.insertComment(cv);
		
		if(isSuccess) {
			// 작성 성공
			response.sendRedirect("boardDetail.bo?board_num="+board_num);
		} else {
			// 작성 실패
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('댓글 등록 실패');");
			out.print("history.back();");
			out.print("</script>");
		}
		
	}

	@Override
	public ArrayList<CommentVO> getCommentList(HttpServletRequest request) {
		ArrayList<CommentVO> list = null;
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int commentListCount = dao.getCommentListCount(board_num);
		
		OraclePageMaker pageMaker = new OraclePageMaker(page,commentListCount);
		pageMaker.setPerPage(5);	// 한번에 보여줄 댓글의 개수가 5
		pageMaker.setPageCount(5);  // 한번에 보여줄 페이지 블럭의 개수가 5
		
		//list = dao.getCommentList(board_num);
		list = dao.getCommentList(board_num, pageMaker);
		request.setAttribute("pageMaker", pageMaker);
		return list;
	}

	@Override
	public void deleteComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		System.out.println(board_num+" // "+ comment_num);
		
		dao.deleteComment(comment_num);
		
		response.sendRedirect("boardDetail.bo?board_num="+board_num);
		
	}
	
	

}
