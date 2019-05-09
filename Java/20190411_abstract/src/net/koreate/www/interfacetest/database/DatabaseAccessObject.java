package net.koreate.www.interfacetest.database;

public interface DatabaseAccessObject {

	
	void connection();
	void select();
	void insert();
	void update();
	void delete();
	void close();
	
	
}
