package net.koreate.www.generic.generic_mothod;

public class Util {
	
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<>();
		
		box.setType(t);
				
		return box;
		
	}

}
