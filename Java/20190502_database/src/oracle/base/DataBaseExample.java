package oracle.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataBaseExample {
	
	public static void main(String[] args) {
		
		// 위치(localhost) + 포트 + 스키마
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "scott";
		String password = "tiger";
		
		// 데이터베이스 연결정보
		Connection conn = null;
		// 연결정보를 가지고 질의 전송을 도와주는 객체
		Statement stmt = null;
		// 질의에 대한 결과값을 담는 객체
		ResultSet rs = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url,username,password);
			//oracle.jdbc.driver.OracleDriver driver = oracle.jdbc.driver.OracleDriver();
			System.out.println("DATABASE 와 연결 되었습니다.");
			
			String sql="SELECT * FROM student";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);			
						
			while(rs.next()) {
				int stu_no = rs.getInt(1);
				String stu_name = rs.getString(2) ;
				String stu_dept = rs.getString(3);
				int stu_grade = rs.getInt(4);
				// 1byte
				char stu_class = rs.getString(5).charAt(0);
				char stu_gender = rs.getString(6).charAt(0);
				double stu_height = rs.getDouble(7);
				double stu_weight = rs.getDouble(8);
				
				StudentVO studentVO = new StudentVO(stu_no,stu_name,stu_dept,stu_grade,stu_class,stu_gender,stu_height,stu_weight);
				System.out.println(studentVO);
				
			}
			// Student table 모든 정보 검색 완료
			
			sql = "INSERT INTO dept_copy VALUES(50,'PROGRAMMING','BUSAN')";
			//stmt = conn.createStatement();
			
			int result = stmt.executeUpdate(sql);
			System.out.println(result);
			stmt.close();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("부서명을 입력해주세요");
			String dname = sc.next();
			System.out.println("지역명을 입력해 주세요");
			String loc = sc.next();
			System.out.println("부서번허 >");
			int deptno = sc.nextInt();
			// 
			sql = "INSERT INTO dept_copy VALUES("+deptno+",'"+dname+"','"+loc+"')";
			System.out.println("sql : "+ sql);
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			
			sql = "UPDATE dept_copy SET dname = 'COMPUTTING' WHERE deptno = 50";
			result = stmt.executeUpdate(sql);
			System.out.println("update result : " + result);
			
			sql="DELETE FROM dept_copy WHERE deptno = 50";
			result = stmt.executeUpdate(sql);
			System.out.println("delete result : "+ result);
			
			sc.close();
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER를 찾을 수 없습니다."+e.getMessage());
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("DATABASE 정보가 잘못 되었습니다."+e.getMessage());
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		
		
	}

}
