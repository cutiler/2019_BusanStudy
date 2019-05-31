package service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface NoticeService {
	
	// 게시물 작성
	public boolean noticeWrite(HttpServletRequest request, HttpServletResponse response);
	
	// 게시물 목록
	public void noticeList(HttpServletRequest request);
	
	// 게시물 상세보기
	public void noticeDetail(HttpServletRequest request);
	
	// 게시물 정보수정
	public boolean noticeUpdate(HttpServletRequest request);
	
	// 게시물 삭제
	public boolean noticeDelete(HttpServletRequest request);

}
