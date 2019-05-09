package net.koreate.www.thorwsexam;

public class ThrowsExample {
	
	public static void main(String[] args){
		
		try {
			findClass("java.lang.String2");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void findClass(String path) throws ClassNotFoundException {
		
		Class clazz = Class.forName(path);
		
	}

}
