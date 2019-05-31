package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBCPUtil;
import vo.NoticeVO;

public class NoticeDAOImpl implements NoticeDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public boolean noticeWrite(NoticeVO noticeVO) {
		boolean isSuccess = false;
		
		conn = DBCPUtil.getConnection();
		String sql = "INSERT INTO notice_board VALUES(notice_board_seq.nextval,?,?,?,?,sysdate)";
		
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
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
			
		}
		
		return isSuccess;
	}

	@Override
	public boolean noticeUpdate(NoticeVO noticeVO) {

		return false;
	}

	@Override
	public boolean noticeDelete(int notice_num) {

		return false;
	}

	@Override
	public ArrayList<NoticeVO> getNoticeList(int startRow, int endRow) {

		ArrayList<NoticeVO> noticeList = new ArrayList<>();
		
		String sql = "SELECT B.* FROM"
				+ " (SELECT ROWNUM AS rnum, A.* FROM "
				+ " (SELECT * FROM notice_board ORDER BY notice_num DESC) A"
				+ ") B"
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
		} finally {
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
			if(rs.next()){
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

}
