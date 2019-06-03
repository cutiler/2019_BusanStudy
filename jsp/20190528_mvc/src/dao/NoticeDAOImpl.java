package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBCPUtil;
import util.OraclePageMaker;
import vo.NoticeVO;

public class NoticeDAOImpl implements NoticeDAO{
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	@Override
	public boolean noticeWrite(NoticeVO noticeVO) {
		boolean isSuccess = false;
		
		conn = DBCPUtil.getConnection();
		
		String sql = 
			"INSERT INTO notice_board VALUES(notice_board_seq.nextval,?,?,?,?,sysdate)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeVO.getNotice_category());
			pstmt.setString(2, noticeVO.getNotice_author());
			pstmt.setString(3, noticeVO.getNotice_title());
			pstmt.setString(4, noticeVO.getNotice_content());
			int result = pstmt.executeUpdate();
			if(result != 0) isSuccess = true;			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.close(rs);
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}
		
		
		
		
		
		return isSuccess;
	}

	@Override
	public boolean noticeUpdate(NoticeVO noticeVO) {
		boolean isSuccess = false;
		
		try {
			
			String sql = "UPDATE notice_board SET "
						+ " notice_category = ?, "
						+ " notice_author = ?, "
						+ " notice_title = ?, "
						+ " notice_content = ?, "
						+ " notice_date = sysdate "
						+ " WHERE notice_num = ?";
			
			conn = DBCPUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeVO.getNotice_category());
			pstmt.setString(2, noticeVO.getNotice_author());
			pstmt.setString(3, noticeVO.getNotice_title());
			pstmt.setString(4, noticeVO.getNotice_content());
			pstmt.setInt(5, noticeVO.getNotice_num());
			
			int result = pstmt.executeUpdate();
			if(result != 0) { isSuccess = true;}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}
		return isSuccess;
	}

	@Override
	public boolean noticeDelete(int notice_num) {
		boolean isSuccess = false;
		
		try {
			String sql = "DELETE FROM notice_board WHERE notice_num = ?";
			conn = DBCPUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			
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

	@Override
	public ArrayList<NoticeVO> getNoticeList(int startRow, int endRow) {
		
		ArrayList<NoticeVO> noticeList = new ArrayList<>();

		String sql = "SELECT B.* FROM"
					+ " (SELECT ROWNUM AS rnum, A.* FROM "
					+ " (SELECT * FROM notice_board ORDER BY notice_num DESC) A"
					+ " ) B"
					+ " WHERE rnum BETWEEN ? AND ?";
		
		try {
			conn = DBCPUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				NoticeVO n = new NoticeVO();
				n.setNotice_num(rs.getInt("notice_num"));
				n.setNotice_category(rs.getString("notice_category"));
				n.setNotice_author(rs.getString("notice_author"));
				n.setNotice_title(rs.getString("notice_title"));
				n.setNotice_date(rs.getTimestamp("notice_date"));
				noticeList.add(n);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCPUtil.close(rs);
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}
		return noticeList;
	}

	@Override
	public int getListCount() {
		int listCount = 0;
		
		try {
			conn = DBCPUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT count(*) FROM notice_board");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.close(rs);
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}
		return listCount;
	}

	// 게시물 정보 요청
	@Override
	public NoticeVO getNoticeVO(int notice_num) {
		NoticeVO notice= null;
		
		try {
			
			String sql = "SELECT * FROM notice_board WHERE notice_num = ? ";
			
			conn = DBCPUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				notice = new NoticeVO();
				notice.setNotice_num(notice_num);
				notice.setNotice_category(rs.getString("notice_category"));
				notice.setNotice_author(rs.getString("notice_author"));
				notice.setNotice_title(rs.getString("notice_title"));
				notice.setNotice_content(rs.getString("notice_content"));
				notice.setNotice_date(rs.getTimestamp("notice_date"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBCPUtil.close(rs);
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}
		return notice;
	}

	@Override
	public int getSearchListCount(String searchName, String searchValue) {
		int listCount = 0;
		
		String sql = "SELECT count(*) FROM notice_board ";
		if(searchName.equals("author")){
			sql += " WHERE notice_author LIKE ? ";
		}else {
			sql += " WHERE notice_title LIKE ? ";
		}
		System.out.println("search sql : " +sql);
		try {
			conn = DBCPUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchValue+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.close(rs);
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}
		return listCount;
	}

	@Override
	public ArrayList<NoticeVO> getSearchNoticeList(String searchName, String searchValue, OraclePageMaker pageMaker) {
		ArrayList<NoticeVO> noticeList = new ArrayList<>();
		
		String sql  ="SELECT B.* FROM"
				+ "	(SELECT ROWNUM AS rnum, A.* FROM "
				+ " (SELECT * FROM notice_board ";
				if(searchName.equals("author")) {
					sql+=" WHERE notice_author LIKE ? ";
				}else {
					sql+=" WHERE notice_title LIKE ? ";
				}		
				sql+= " ORDER BY notice_num DESC) A ) B ";
				sql+= " WHERE rnum BETWEEN ? AND ?";
		
		try {
			conn = DBCPUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchValue+"%");
			pstmt.setInt(2, pageMaker.getStartRow());
			pstmt.setInt(3, pageMaker.getEndRow());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVO n = new NoticeVO();
				n.setNotice_num(rs.getInt("notice_num"));
				n.setNotice_category(rs.getString("notice_category"));
				n.setNotice_author(rs.getString("notice_author"));
				n.setNotice_title(rs.getString("notice_title"));
				n.setNotice_content(rs.getString("notice_content"));
				n.setNotice_date(rs.getTimestamp("notice_date"));
				noticeList.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.close(rs);
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}
		return noticeList;
	}
	
	
	
}
