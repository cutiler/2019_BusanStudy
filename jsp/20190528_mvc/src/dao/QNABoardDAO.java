package dao;

import java.util.ArrayList;

import util.OraclePageMaker;
import vo.BoardVO;
import vo.CommentVO;

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

	// 190605 comment 추가 -----------------------------------------

   	// comment 등록
	public boolean insertComment(CommentVO cv);
	
	// 게시물의 comment 목록
	public ArrayList<CommentVO> getCommentList(int board_num);
	
	// comment 삭제 요청
	public void deleteComment(int comment_num);
	
	// 해당 게시물 번호의 전체 comment 개수 반환
	public int getCommentListCount(int board_num);
	
	// paging 처리가된 comment 리스트
	public ArrayList<CommentVO> getCommentList(int board_num,OraclePageMaker pageMaker);
	
}
