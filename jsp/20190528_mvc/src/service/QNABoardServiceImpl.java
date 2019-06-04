package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.QNABoardDAO;
import dao.QNABoardDAOImpl;
import util.OraclePageMaker;
import vo.BoardVO;

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
		return dao.getBoardList();
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
		
		try {
			
			String realPath = request.getServletContext().getRealPath("/upload");
			String file_name = request.getParameter("board_file");
			
			String filePath = realPath+File.separator+file_name;
			System.out.println("filePath : "+filePath);
			String mimeType = request.getServletContext().getMimeType(filePath);
			System.out.println("mimeType : "+mimeType);
			
			if(mimeType == null) {
				mimeType="application/actet-stream";
			}
			
			response.setContentType(mimeType);
			
			String agent = request.getHeader("User-Agent");
			System.out.println("agent : " + agent);
			boolean isBrowser = (agent.indexOf("MSIE") > -1 || agent.indexOf("Trident") > -1);
			System.out.println("isBrowser : " + isBrowser);
			if(isBrowser) {
				file_name = URLEncoder.encode(file_name,"utf-8").replaceAll("\\+", "%20");
			}else {
				file_name = new String(file_name.getBytes("utf-8"),"iso-8859-1");
			}
			
			FileInputStream fis = new FileInputStream(filePath);
			response.setHeader("Content-Disposition", "attachment;fileName="+file_name);
			ServletOutputStream out = response.getOutputStream();
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
	
	

}
