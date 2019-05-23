package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBCPUtil {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			DataSource ds = (DataSource)new InitialContext().lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("resource 를 찾을 수 없음");
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("connection 정보 오류");			
		}
		return conn;		
	}
	
	public static void close(AutoCloseable closer) {
		
		try {
			if(closer != null) {
				closer.close();
			}
		} catch (Exception e) {	}
		
	}

}
