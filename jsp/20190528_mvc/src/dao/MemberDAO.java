package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBCPUtil;
import vo.MemberVO;

public class MemberDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public boolean memberJoin(MemberVO member) {
		conn = DBCPUtil.getConnection();
		try {
			String sql = "SELECT * FROM mvc_member WHERE id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {return false;}
			
			sql = "INSERT INTO mvc_member(num,id,pass,name,age,gender) "
				  + "VALUES(m_num_seq.nextval,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			
			int result = pstmt.executeUpdate();
			if(result <= 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			DBCPUtil.close(rs);
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}
		return true;
	}

	// 로그인 정보 존재 체크
	public MemberVO memberLogin(String id, String pass) {
		
		MemberVO member = null;
		
		try {
			conn = DBCPUtil.getConnection();
			String sql = "SELECT * FROM mvc_member WHERE id = ? AND pass = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberVO();
				member.setNum(rs.getInt(1));
				member.setId(rs.getString(2));
				member.setPass(rs.getString(3));			
				member.setName(rs.getString(4));
				member.setAge(rs.getInt(5));
				member.setGender(rs.getString(6));
				member.setRegdate(rs.getTimestamp(7));
				member.setUpdatedate(rs.getTimestamp(8));
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally {
			DBCPUtil.close(rs);
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}
		
		return member;
	}

	public MemberVO getMemberById(String id) {
		MemberVO member = null;
		
		try {
			conn = DBCPUtil.getConnection();
			String sql = "SELECT * FROM mvc_member WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberVO();
				member.setNum(rs.getInt(1));
				member.setId(rs.getString(2));
				member.setPass(rs.getString(3));			
				member.setName(rs.getString(4));
				member.setAge(rs.getInt(5));
				member.setGender(rs.getString(6));
				member.setRegdate(rs.getTimestamp(7));
				member.setUpdatedate(rs.getTimestamp(8));
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally {
			DBCPUtil.close(rs);
			DBCPUtil.close(pstmt);
			DBCPUtil.close(conn);
		}	
		
		return member;
	}

}
