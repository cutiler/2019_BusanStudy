package oracle.util;

import java.util.ArrayList;

import oracle.base.Book;

/*Oracle DataBase Access Object*/


public interface OracleDAO {

	// 삽입
	public int insert(Book book);
	
	//수정
	public int update(Book book);
	
	// 삭제
	public int delete(int num);
	
	//도서 목록
	public ArrayList<Book> select();
	
	//Book 객체 검색
	public Book selectBook(int num);
	
	
}
