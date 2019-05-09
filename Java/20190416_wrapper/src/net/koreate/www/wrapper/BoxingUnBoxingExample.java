package net.koreate.www.wrapper;

public class BoxingUnBoxingExample {

	public static void main(String[] args) {
		
		//boxing
		Integer obj1 = new Integer(100);
		System.out.println("obj1 : "+obj1.intValue());
		Integer obj2 = new Integer("200");
		System.out.println("obj2 : "+obj2.intValue());
		
		//unboxing
		int val1 = obj1;
		System.out.println(val1);
		Integer obj3 = 100;
		System.out.println(obj3);
		
		Integer obj4 = Integer.valueOf("600");
		
		int val2 = Integer.parseInt("700");
		
		
		// 자동 boxing&unboxing
		int val3 = Integer.valueOf("600");
		
		Integer obj5 = Integer.parseInt("700");
		
		
		
		
		double value = Double.parseDouble("3.14");
		
		boolean value1 = Boolean.parseBoolean("true");
		
		
		
		
		
		
	}
	
}
