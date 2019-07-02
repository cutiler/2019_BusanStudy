package net.koreate.testboard.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import net.koreate.testboard.util.Criteria;
import net.koreate.testboard.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	SqlSession session;
	
	String namespace = "net.koreate.testboard.mappers.BoardMapper";
	
	@Override
	public int register(BoardVO board) {		
		return session.insert(namespace+".register",board);		
	}

	@Override
	public List<BoardVO> readList() {
		return session.selectList(namespace+".readList");
	}
	
	@Override
	public List<BoardVO> readListCri(Criteria cri) {
		return session.selectList(namespace+".readListCri",cri);
	}

	@Override
	public int readTotalCount() {		
		return session.selectOne(namespace+".readTotalCount");
	}

	@Override
	public BoardVO readPage(int bno) {		
		return session.selectOne(namespace+".readPage",bno);
	}

	@Override
	public int updateViewCount(int bno) {	
		return session.update(namespace+".updateViewCount", bno);
	}

	@Override
	public int updatePage(BoardVO board) {	
		return session.update(namespace+".updatePage",board);
	}

	@Override
	public int remove(int bno) {	
		return session.delete(namespace+".remove", bno);
	}
	
	
	
	
	
	
	

	
}
