package net.koreate.www.interfacetest.database;

public class OracleDAO implements DatabaseAccessObject{

	@Override
	public void connection() {
		System.out.println("Oracle DataBase 연결");
		
	}

	@Override
	public void select() {
		System.out.println("Oracle DataBase 검색");
		
	}

	@Override
	public void insert() {
		System.out.println("Oracle DataBase 삽입");
		
	}

	@Override
	public void update() {
		System.out.println("Oracle DataBase 수정");
		
	}

	@Override
	public void delete() {
		System.out.println("Oracle DataBase 삭제");
		
	}

	@Override
	public void close() {
		System.out.println("Oracle DataBase 연결 끊음.");
		
	}

	

	
	
	
}
