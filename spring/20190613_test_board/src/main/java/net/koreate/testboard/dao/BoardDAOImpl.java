package net.koreate.testboard.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import net.koreate.testboard.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	SqlSession session;
	
	String namespace = "net.koreate.testboard.mappers.BoardMapper";
	
	@Override
	public int register(BoardVO board) {
		System.out.println(board);
		int result = session.insert(namespace+".register",board);
		System.out.println(result);
		return result;
	}

	
}
