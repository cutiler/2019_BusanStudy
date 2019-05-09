package net.koreate.www.generic.generic_extends;

public class Util {
	
	public static <T extends Number> int compare(T t1, T t2) {
		
		double v1 = t1.doubleValue();
		System.out.println(t1.getClass().getName());
		double v2 = t2.doubleValue();
		System.out.println(t2.getClass().getName());
		
		if(v1 > v2) {
		
			return (int)v1;
			
		}else return (int)v2;
		
		
	}

}
