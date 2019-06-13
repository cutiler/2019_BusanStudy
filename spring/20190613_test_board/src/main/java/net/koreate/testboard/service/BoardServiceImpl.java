package net.koreate.testboard.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.koreate.testboard.dao.BoardDAO;
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

	
	public String resultMsg(int result) {
		
		String msg = "FAIL";
		if(result > 0) msg = "SUCCESS";
		return msg;
	}
	
	
}
