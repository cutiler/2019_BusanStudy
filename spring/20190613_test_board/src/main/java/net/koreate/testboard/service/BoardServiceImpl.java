package net.koreate.testboard.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.koreate.testboard.dao.BoardDAO;
import net.koreate.testboard.util.Criteria;
import net.koreate.testboard.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO dao;
	
	@Override
	public String register(BoardVO board) {		
		int result = dao.register(board);		
		return resultMsg(result);
	}
	
	@Override
	public List<BoardVO> readList() {		
		return dao.readList();
	}
	
	@Override
	public List<BoardVO> readListCri(Criteria cri) {		
		return dao.readListCri(cri);
	}
	
	@Override
	public int readTotalCount() {		 
		return dao.readTotalCount();
	}	
	
	@Override
	public BoardVO readPage(int bno) {	
		return dao.readPage(bno);
	}
	
	@Override
	public String updateViewCount(int bno) {
		int result = dao.updateViewCount(bno); 
		return this.resultMsg(result);
	}	
	

	@Override
	public String updatePage(BoardVO board) {
		int result = dao.updatePage(board);
		return this.resultMsg(result);
	}
	
	

	@Override
	public String remove(int bno) {
		int result = dao.remove(bno);
		return resultMsg(result);
	}

	public String resultMsg(int result) {
		
		String msg = "FAIL";
		if(result > 0) msg = "SUCCESS";
		return msg;
	}


}
