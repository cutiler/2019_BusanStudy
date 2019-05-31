package service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDAO;
import dao.NoticeDAOImpl;
import util.OraclePageMaker;
import vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	
	NoticeDAO dao = new NoticeDAOImpl();

	@Override
	public boolean noticeWrite(HttpServletRequest request, HttpServletResponse response) {
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
		
		OraclePageMaker pageMaker = new OraclePageMaker(page, listCount);
		pageMaker.setPerPage(5);
		pageMaker.setPageCount(5);
		
		System.out.println(pageMaker);
		
		ArrayList<NoticeVO> noticeList = dao.getNoticeList(pageMaker.getStartRow(), pageMaker.getEndRow());
		System.out.println("getNoticeList : "+noticeList);
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("pageMaker", pageMaker);
	}

	@Override
	public void noticeDetail(HttpServletRequest request) {
	
	}

	@Override
	public boolean noticeUpdate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean noticeDelete(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

}

