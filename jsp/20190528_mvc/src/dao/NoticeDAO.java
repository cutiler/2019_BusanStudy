package dao;

import java.util.ArrayList;

import util.OraclePageMaker;
import vo.NoticeVO;

public interface NoticeDAO {
	
	// 게시물 작성
	public boolean noticeWrite(NoticeVO noticeVO);
	
	// 게시물 상세보기
	public NoticeVO getNoticeVO(int notice_num);
	
	// 게시물 수정
	public boolean noticeUpdate(NoticeVO noticeVO);
	
	// 게시물 삭제
	public boolean noticeDelete(int notice_num);
	
	// 게시물 리스트
	public ArrayList<NoticeVO> getNoticeList(int startRow, int endRow);
	
	// 등록된 게시물의 개수
	public int getListCount();

	// 검색 결과에 따른 전체 게시물 개수 
	public int getSearchListCount(String searchName, String searchValue);

	// 페이징 처리된 검색 목록
	public ArrayList<NoticeVO> getSearchNoticeList(String searchName, String searchValue, OraclePageMaker pageMaker);
	
}
