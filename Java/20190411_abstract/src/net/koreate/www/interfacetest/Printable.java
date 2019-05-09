package net.koreate.www.interfacetest;

public interface Printable {
	
	
	
	void print();
	default void colorPrint() {
		System.out.println("칼라 출력");
	}
	
	static void copy(String message) {
		System.out.println(message+" Copy");
	}
	
}
