package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBCPUtil;
import util.OraclePageMaker;
import vo.BoardVO;

public class QNABoardDAOImpl implements QNABoardDAO{
	
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private static QNABoardDAOImpl boardDAO;
	
	private QNABoardDAOImpl() {}
	
	public static QNABoardDAOImpl getInstance() {
		if(boardDAO == null) {
			boardDAO = new QNABoardDAOImpl();
		}		
		return boardDAO;
	}
	

	@Override
	public int getListCount() {
		int listCount = 0;
		
		try {
			conn = DBCPUtil.getConnection();
			String sql = "SELECT count(*) FROM qna_board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) listCount = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCPUtil.close(rs);
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}
		return listCount;
	}

	@Override
	public ArrayList<BoardVO> getBoardList() {
		ArrayList<BoardVO> boardList = new ArrayList<>();
		try {
			
			conn = DBCPUtil.getConnection();
			String sql = "SELECT * FROM qna_board ORDER BY board_re_ref DESC, board_re_seq ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_name(rs.getString("board_name"));
				board.setBoard_pass(rs.getString("board_pass"));
				board.setBoard_title(rs.getString("board_title"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_file(rs.getString("board_file"));
				board.setBoard_file_origin(rs.getString("board_file_origin"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
				board.setBoard_readcount(rs.getInt("board_readcount"));
				board.setBoard_date(rs.getTimestamp("board_date"));
				boardList.add(board);				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBCPUtil.close(rs);
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}
		return boardList;
	}

	@Override
	public ArrayList<BoardVO> getBoardList(OraclePageMaker pageMaker) {
		ArrayList<BoardVO> boardList = new ArrayList<>();
		
		try {
			conn = DBCPUtil.getConnection();
			String sql = " SELECT * FROM "
						+ "(SELECT ROWNUM AS rnum , A.* FROM "
						+ "(SELECT * FROM qna_board ORDER BY board_re_ref DESC, board_re_seq ASC) A ) "
						+ " WHERE rnum BETWEEN ? AND ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageMaker.getStartRow());
			pstmt.setInt(2, pageMaker.getEndRow());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_name(rs.getString("board_name"));
				board.setBoard_title(rs.getString("board_title"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
				board.setBoard_readcount(rs.getInt("board_readcount"));
				board.setBoard_date(rs.getTimestamp("board_date"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCPUtil.close(rs);
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}
		return boardList;
	}

	@Override
	public void boardWrite(BoardVO board) {
		
		
		try {
			conn = DBCPUtil.getConnection();
			String sql ="INSERT INTO qna_board VALUES(qna_board_seq.nextval,?,?,?,?,?,?,qna_board_seq.currval,0,0,0,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoard_name());
			pstmt.setString(2, board.getBoard_pass());
			pstmt.setString(3, board.getBoard_title());
			pstmt.setString(4, board.getBoard_content());
			pstmt.setString(5, board.getBoard_file());
			pstmt.setString(6, board.getBoard_file_origin());
			
			pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}
	}

	@Override
	public BoardVO getBoardVO(int board_num) {
		
		BoardVO board = null;
		
		try {
			conn = DBCPUtil.getConnection();
			String sql = "SELECT * FROM qna_board WHERE board_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_name(rs.getString("board_name"));
				board.setBoard_title(rs.getString("board_title"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_file(rs.getString("board_file"));
				board.setBoard_file_origin(rs.getString("board_file_origin"));	
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCPUtil.close(rs);
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}
		
		
		return board;
	}

	@Override
	public void updateReadCount(int board_num) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "UPDATE qna_board SET board_readcount = board_readcount + 1 "
						+ " WHERE board_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}
	}

	@Override
	public void boardReplySubmit(BoardVO board) {
		int ref = board.getBoard_re_ref();
		int lev = board.getBoard_re_lev();
		int seq = board.getBoard_re_seq();
		
		String sql ="";
		
		try {
			sql = "UPDATE qna_board SET board_re_seq = board_re_seq +1 "
				  + " WHERE board_re_ref = ? AND board_re_seq > ?";
			conn = DBCPUtil.getConnection();
			conn.setAutoCommit(false);			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, seq);
			pstmt.executeUpdate();
			
			sql = "INSERT INTO qna_board VALUES(qna_board_seq.nextval,?,?,?,?,?,?,?,?,?,0,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoard_name());
			pstmt.setString(2, board.getBoard_pass());
			pstmt.setString(3, board.getBoard_title());
			pstmt.setString(4, board.getBoard_content());
			pstmt.setString(5, "");
			pstmt.setString(6, "");
			pstmt.setInt(7, ref);
			pstmt.setInt(8, lev+1);
			pstmt.setInt(9, seq+1);
		
			pstmt.executeUpdate();
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {}
			
		}finally {
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}
	}

	@Override
	public void boardUpdate(BoardVO board) {
		
		try {
			
			conn = DBCPUtil.getConnection();
			String sql ="UPDATE qna_board SET "
						+ " board_name = ?, "
						+ " board_title = ?, "
						+ " board_content = ? "
						+ " WHERE board_num = ? "
						+ " AND board_pass = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoard_name());
			pstmt.setString(2, board.getBoard_title());
			pstmt.setString(3, board.getBoard_content());
			pstmt.setInt(4, board.getBoard_num());
			pstmt.setString(5, board.getBoard_pass());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}
		
	}

	@Override
	public boolean boardDelete(int board_num, String board_pass) {
		
		boolean isSuccess = false;
		
		try {
			conn = DBCPUtil.getConnection();
			String sql = "DELETE FROM qna_board WHERE board_num = ? AND board_pass = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, board_num);
			pstmt.setString(2, board_pass);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {isSuccess = true;}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}
		return isSuccess;
	}
	
	

}
