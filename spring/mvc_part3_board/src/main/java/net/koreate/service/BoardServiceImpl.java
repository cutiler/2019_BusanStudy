package net.koreate.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.koreate.dao.BoardDAO;
import net.koreate.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	BoardDAO dao;
	
	@Override
	public String register(BoardVO board) {	
		int result = dao.create(board);
		return getResult(result);
	}

	@Override
	public List<BoardVO> listAll() {		
		return dao.listAll();
	}

	@Override
	public BoardVO read(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateViewCnt(int bno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String modify(BoardVO board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String remove(int bno) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getResult(int result) {
		String msg = "FAIL";
		
		if(result > 0) {
			msg = "SUCCESS";
		}
		
		return msg;
	}

}
