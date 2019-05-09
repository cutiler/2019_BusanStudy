package net.koreate.www.interfacetest.database;

public class DAOExample {
	
	static void dbWork(DatabaseAccessObject dao) {
		dao.connection();
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
		dao.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		dbWork(new OracleDAO());
		dbWork(new MySqlDAO());
		
		
	}

}
