package net.koreate.testboard.dao;

import java.util.List;

import net.koreate.testboard.util.Criteria;
import net.koreate.testboard.vo.BoardVO;

public interface BoardDAO {

	// 삽입
	int register(BoardVO board);

	// 게시글 목록 리스트
	List<BoardVO> readList();
	
	// 게시글 목록 리스트
	List<BoardVO> readListCri(Criteria cri);
	
	// 총 게시물 수
	int readTotalCount();

	// 게시물 읽기
	BoardVO readPage(int bno);

	// 조회수 증가
	int updateViewCount(int bno);

	// 게시물 수정
	int updatePage(BoardVO board);

	int remove(int bno);

}
