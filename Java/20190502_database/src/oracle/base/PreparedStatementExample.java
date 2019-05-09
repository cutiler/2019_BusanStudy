package oracle.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementExample {
	
	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "scott";
		String password = "tiger";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("DB 연결 성공");
			
			Scanner sc = new Scanner(System.in);
			int deptno = sc.nextInt();
			String sql = "SELECT * FROM dept_copy WHERE deptno= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				deptno= rs.getInt("deptno");
				String dname= rs.getString("dname");
				String loc= rs.getString("loc");
				System.out.println(deptno+" / "+dname+" / "+loc);
				
			}
			
			System.out.println("부서명을 입력해주세요");
			String dname = sc.next();
			System.out.println("지역명을 입력해 주세요");
			String loc = sc.next();
			System.out.println("부서번허 >");
			deptno = sc.nextInt();
			
			sql = "INSERT INTO dept_copy VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			int result = pstmt.executeUpdate();
			System.out.println("삽입 결과 :  "+result);
			
			
		} catch (SQLException e) {
			System.out.println("연결 정보를 찾을수 없습니다"+e.getMessage());
		}finally {
			
			try {
				rs.close();
				pstmt.close();
				conn.close();
				System.out.println("자원해제 완료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}
