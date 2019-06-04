package service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.BoardVO;

public interface QNABoardService {
	// 게시물 전체 목록 정보 요청
	public ArrayList<BoardVO> getBoardList();
	
	// 페이징 처리된 전체 목록 정보 요청
	public ArrayList<BoardVO> getBoardList(HttpServletRequest request);
	
	// 게시물 등록 요청
	public void boardWrite(HttpServletRequest request);
	
	// 게시물 상세보기 페이지 요청, 파일 업로드
	public BoardVO getBoardVO(HttpServletRequest request);
	
	//파일 다운로드 처리
	public void fileDown(HttpServletRequest request, HttpServletResponse response);
	
	// 답글 작성 화면 
	public BoardVO boardReply(HttpServletRequest request);
	
	// 답변글 작성 요청
	public void boardReplySubmit(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	// 수정창 게시물 정보 요청
	public BoardVO getBoardVOByUpdate(HttpServletRequest request);
	
	// 게시물 수정 요청
	public void boardUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	// 게시물 삭제 요청
	public void boardDelete(HttpServletRequest request, HttpServletResponse response) 
	throws IOException;
	
	
}
