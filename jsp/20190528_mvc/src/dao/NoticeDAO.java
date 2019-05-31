package dao;

import java.util.ArrayList;

import vo.NoticeVO;

public interface NoticeDAO {

	// 게시물 작성
	public boolean noticeWrite(NoticeVO noticeVO);
	
	// 게시물 수정
	public boolean noticeUpdate(NoticeVO noticeVO);
	
	// 게시물 삭제
	public boolean noticeDelete(int notice_num);
	
	// 게시물 리스트
	public ArrayList<NoticeVO> getNoticeList(int startRow, int endRow);
	
	// 등록된 게시물의 갯수
	public int getListCount();
	
}
