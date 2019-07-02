package net.koreate.comment.dao;

import java.util.List;
import java.util.Map;

import net.koreate.comment.vo.CommentVO;

public interface CommentDAO {
	
	// 삽입
	void addComment(CommentVO vo) throws Exception;

	// 댓글 목록
	List<CommentVO> list(int bno) throws Exception;
	
	// 수정
	void update(CommentVO vo) throws Exception;
	
	// 삭제	
	void delete(int cno) throws Exception;
	
	// 전체 게시물 개수
	int count(int bno) throws Exception;
	
	// 페이지 처리된 게시물 목록
	List<CommentVO> listPage(Map<String, Object> map) throws Exception;
	
}
