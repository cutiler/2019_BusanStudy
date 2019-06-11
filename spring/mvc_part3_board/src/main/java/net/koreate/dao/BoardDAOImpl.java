package net.koreate.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import net.koreate.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	SqlSession session;
	
	String namespace = "net.koreate.mappers.BoardMapper";
	
	
	@Override
	public int create(BoardVO board) {
		int result = session.insert(namespace+".create",board);		
		System.out.println("result : "+result);
		return result;
	}

	@Override
	public List<BoardVO> listAll() {
		/*List<BoardVO> boardList = session.selectList(namespace+".listALL");
		return boardList;*/
		return  session.selectList(namespace+".listALL");
	}

	@Override
	public BoardVO read(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void upateViewCnt(int bno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int update(BoardVO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
