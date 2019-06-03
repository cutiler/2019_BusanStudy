package service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.NoticeDAO;
import dao.NoticeDAOImpl;
import util.OraclePageMaker;
import vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService{
	
	NoticeDAO dao = new NoticeDAOImpl();

	@Override
	public boolean noticeWrite(HttpServletRequest request) {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNotice_author(request.getParameter("notice_author"));
		noticeVO.setNotice_category(request.getParameter("notice_category"));
		noticeVO.setNotice_title(request.getParameter("notice_title"));
		noticeVO.setNotice_content(request.getParameter("notice_content"));
		System.out.println("noticeWrite : "+noticeVO);
		return dao.noticeWrite(noticeVO);
	}

	@Override
	public void noticeList(HttpServletRequest request) {
		int page = 1;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int listCount = dao.getListCount();
		
		OraclePageMaker pageMaker = new OraclePageMaker(page,listCount);
		pageMaker.setPerPage(5);
		pageMaker.setPageCount(5);
		
		System.out.println("getNoticeList : "+pageMaker);
		
		ArrayList<NoticeVO> noticeList 
		= dao.getNoticeList(pageMaker.getStartRow(), pageMaker.getEndRow());
		System.out.println("getNoticeList : "+noticeList);
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("pageMaker", pageMaker);
	}

	@Override
	public void noticeDetail(HttpServletRequest request) {
		String num = request.getParameter("notice_num");
		int notice_num = Integer.parseInt(num);
		NoticeVO notice = dao.getNoticeVO(notice_num);
		request.setAttribute("notice", notice);
	}

	@Override
	public boolean noticeUpdate(HttpServletRequest request) {
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		String notice_category = request.getParameter("notice_category");
		String notice_author = request.getParameter("notice_author");
		String notice_title = request.getParameter("notice_title");
		String notice_content = request.getParameter("notice_content");
		
		NoticeVO notice = new NoticeVO();
		notice.setNotice_num(notice_num);
		notice.setNotice_category(notice_category);
		notice.setNotice_author(notice_author);
		notice.setNotice_title(notice_title);
		notice.setNotice_content(notice_content);
		return dao.noticeUpdate(notice);
	}

	@Override
	public boolean noticeDelete(HttpServletRequest request) {
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		return dao.noticeDelete(notice_num);
	}

	@Override
	public void search(HttpServletRequest request) {
		
		int page = 1;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		String searchName = request.getParameter("searchName");
		String searchValue = request.getParameter("searchValue");
		
		System.out.println("searchName : " + searchName);
		System.out.println("searchValue : " + searchValue);
		
		int listCount = dao.getSearchListCount(searchName,searchValue);
		System.out.println("listCount : "+listCount);
		
		OraclePageMaker pageMaker = new OraclePageMaker(page,listCount);
		pageMaker.setPerPage(10);
		pageMaker.setPageCount(5);
		
		ArrayList<NoticeVO> noticeList = 
				dao.getSearchNoticeList(searchName,searchValue,pageMaker);
		
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("pageMaker", pageMaker);
		request.setAttribute("searchName", searchName);
		request.setAttribute("searchValue", searchValue);
		
	}
}
