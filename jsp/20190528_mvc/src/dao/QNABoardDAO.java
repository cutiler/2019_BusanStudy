package dao;

import java.util.ArrayList;

import util.OraclePageMaker;
import vo.BoardVO;

public interface QNABoardDAO {
	
	// 전체 게시물 개수
	public int getListCount();
	
	// 게시물 전체 목록  
	public ArrayList<BoardVO> getBoardList();
	
	// 페이징 처리된 게시물 목록
	public ArrayList<BoardVO> getBoardList(OraclePageMaker pageMaker);
	
	// 게시물 작성 요청
	public void boardWrite(BoardVO board);
	
	// 게시물 한개의 정보 요청
	public BoardVO getBoardVO(int board_num);
	
	// 조회수 증가
	public void updateReadCount(int board_num);
	
	// 답변글 작성 
	public void boardReplySubmit(BoardVO board);
	
	// 게시물 수정 처리
	public void boardUpdate(BoardVO board);
	
	// 게시물 삭제
	public boolean boardDelete(int board_num, String board_pass);
	
}
