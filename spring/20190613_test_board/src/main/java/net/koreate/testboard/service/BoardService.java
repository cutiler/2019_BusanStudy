package net.koreate.testboard.service;

import java.util.List;

import net.koreate.testboard.util.Criteria;
import net.koreate.testboard.vo.BoardVO;

public interface BoardService {

	// 글쓰기
	String register(BoardVO board);

	// 글 목록 불러오기
	List<BoardVO> readList();
	
	// 글 목록 불러오기
	List<BoardVO> readListCri(Criteria cri);
	
	// 총 게시물 수
	int readTotalCount();

	// 게시물 읽기
	BoardVO readPage(int bno);

	// 게시물 조회수 증가
	String updateViewCount(int bno);

	// 게시글 수정
	String updatePage(BoardVO board);

	String remove(int bno);

}
