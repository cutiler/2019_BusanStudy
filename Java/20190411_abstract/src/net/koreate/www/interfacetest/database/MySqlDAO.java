package net.koreate.www.interfacetest.database;

public class MySqlDAO implements DatabaseAccessObject {
	
	public void connection() {
		System.out.println("Mysql DataBase 에 연결");
	}
	
	public void select() {
		System.out.println("Mysql DataBase 검색");
	}
	
	public void insert() {
		System.out.println("Mysql DataBase 삽입");
	}
	
	public void update() {
		System.out.println("Mysql DataBase 수정");
	}
	
	public void delete() {
		System.out.println("Mysql DataBase 삭제");
	}
	
	@Override
	public void close() {
		System.out.println("Mysql DataBase 연결 끊음");
	}

}
