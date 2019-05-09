package net.koreate.www.generic.generic_extends;

public class ExtendsExample {
	
	public static void main(String[] args) {
		
		int result = Util.<Integer>compare(10, 20);
		System.out.println(result);
		
		int result1 = Util.compare(4.5, 3.4f);
		System.out.println(result1);
		
		// Number class 자기 자신 또는 상속받는 자식 객체만 가능.(T extends Number)
		//int result2 = Util.compare("A", "B");
		
	}

}
