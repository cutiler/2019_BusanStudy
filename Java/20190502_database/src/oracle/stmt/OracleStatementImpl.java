package oracle.stmt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import oracle.base.Book;
import oracle.util.DBHelper;
import oracle.util.OracleDAO;

public class OracleStatementImpl implements OracleDAO {

	//DB 연결 객체
	private Connection con;
	// 질의를 DB에 전달하는 객체
	private Statement stmt;
	// 검색질의의 결과값을 저장하는 객체
	private ResultSet rs;
	
	
	@Override
	public int insert(Book book) {		
		int result = 0;
		
		try {
			con = DBHelper.getConnection();
			stmt = con.createStatement();
			String sql = "INSERT INTO tbl_book VALUES(book_seq.nextval,"
					+ " '"+book.getTitle()+"',"
					+ " '"+book.getAuthor()+"',"
					+"sysdate)";
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Insert 오류 : "+e.getMessage());
		} finally {
			
			try {
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {	}
			
		}
		
		return result;
	}

	@Override
	public int update(Book book) {
		int result = 0;
		
		try {
			con = DBHelper.getConnection();
			stmt = con.createStatement();
			String sql = "UPDATE tbl_book SET"
						+ " title = '"+book.getTitle()+"', "
						+ " author = '"+book.getAuthor()+"', "
						+ " regdate = sysdate "
						+ " WHERE num = "+book.getNum();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("UPDATE 오류 : "+e.getMessage());
		} finally {			
			try {
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {	}
		}
		return 0;
	}

	@Override
	public int delete(int num) {
		int result =0;		
		try {
			con = DBHelper.getConnection();
			stmt = con.createStatement();
			String sql = "DELETE FROM tbl_book WHERE num = "+num;
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("DELETE 오류 :" + e.getMessage());
		} finally {			
			try {
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {	}
		}
		return result;
	}

	@Override
	public ArrayList<Book> select() {
		ArrayList<Book> books = new ArrayList<>();
		
		try {
			con = DBHelper.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM tbl_book ORDER BY num DESC";		
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int num = rs.getInt(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				Date regDate = rs.getTimestamp(4);
				Book book = new Book(num,title,author,regDate);
				books.add(book);
				//books.add(new Book(num,title,author,regDate));
			}
		} catch (SQLException e) {
			System.out.println("검색 오류 : "+ e.getMessage());
		} finally {
			
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				
			} catch (SQLException e) {	}
		}		
		return books;
	}

	@Override
	public Book selectBook(int num) {		
		Book book = null;
		try {
			con = DBHelper.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM tbl_book Where num="+num;		
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//int num = rs.getInt(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				Date regDate = rs.getTimestamp(4);
				book = new Book(num,title,author,regDate);				
			}
		} catch (SQLException e) {
			System.out.println("검색 오류 : "+ e.getMessage());
		} finally {			
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				
			} catch (SQLException e) {	}
		}	 
		return book;
	}
	
	
	

}
