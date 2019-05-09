package oracle.pstmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import book.BookRowNum;
import oracle.base.Book;
import oracle.util.DBHelper;
import oracle.util.OracleDAO;

public class OraclePSTMTImpl implements OracleDAO{
	
	private Connection conn;
	
	private PreparedStatement pstmt;
	
	private ResultSet rs;

	@Override
	public int insert(Book book) {
		int result = 0;		
		try {
			conn = DBHelper.getConnection();		
			String sql = "INSERT INTO tbl_book VALUES(book_seq.nextval,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("PSTMT INSERT 오류 : "+e.getMessage());
		} finally {			
			DBHelper.close(pstmt);
		}
		return result;
	}

	@Override
	public int update(Book book) {
		int result = 0;
		
		try {
			conn = DBHelper.getConnection();
			String sql = "UPDATE tbl_book SET title= ? , author= ? , regdate = sysdate Where num = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getNum());
						
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("PSTMT UPDATE 오류 : "+e.getMessage());
		} finally {
			DBHelper.close(pstmt);
		}
		return result;
	}

	@Override
	public int delete(int num) {
		int result=0;
		
		try {
			conn = DBHelper.getConnection();
			String sql = "DELETE FROM tbl_book Where num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);		
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("PSTMT DELETE 오류 : "+e.getMessage());
		} finally {
			DBHelper.close(pstmt);
		}
 		return result;
	}

	@Override
	public ArrayList<Book> select() {
		ArrayList<Book> books = new ArrayList<>();
		
		try {
			conn = DBHelper.getConnection();
			String sql ="SELECT ROWNUM AS rnum, tbl_book.* FROM tbl_book Order BY rnum DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int rnum = rs.getInt(1);
				int num = rs.getInt(2);
				String title = rs.getString(3);
				String author = rs.getString(4);
				Date regDate = rs.getTimestamp(5);
				books.add(new BookRowNum(rnum,num,title,author,regDate));
			}
		} catch (SQLException e) {
			System.out.println("PSTMT SELECT 오류 : "+e.getMessage());
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
		}
		
		return books;
	}

	@Override
	public Book selectBook(int num) {		
		BookRowNum book = null;
		
		try {
			conn = DBHelper.getConnection();
			String sql = "SELECT A.rnum, num, title, author, regdate FROM"
					+ "(SELECT ROWNUM AS rnum, tbl_book.* FROM tbl_book ORDER BY rnum DESC) A "
					+ " WHERE num = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {			
				int rnum = rs.getInt("rnum");
				num = rs.getInt("num");
				String title = rs.getString("title");
				String author = rs.getString("author");
				Date regDate = rs.getTimestamp("regDate");
				
				book = new BookRowNum(rnum,num,title,author,regDate);
			}
		} catch (SQLException e) {
			System.out.println("PSTMT SELECT BOOK 오류 : "+e.getMessage());
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);			
		}
		return book;
	}

}
