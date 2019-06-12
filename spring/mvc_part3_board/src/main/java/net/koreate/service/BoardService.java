package net.koreate.service;

import java.util.List;

import net.koreate.util.Criteria;
import net.koreate.vo.BoardVO;

public interface BoardService {
	
	// 게시물 등록
	String register(BoardVO board);
	
	// 전체 게시물 목록 
	List<BoardVO> listAll();
	
	// 게시물 상세보기
	BoardVO read(int bno);
	
	// 조회수 증가
	void updateViewCnt(int bno);
	
	// 게시물 수정
	String modify(BoardVO board);
	
	// 게시물 삭제
	String remove(int bno);

	// Cri 게시물
	List<BoardVO> listCri(Criteria cri);

	int totalCount();
}
