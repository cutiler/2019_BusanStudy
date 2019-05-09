package net.koreate.www;

public class OperatorTest {

	public static void main(String[] args) {
		// Relational operation
		
		int num1 = 5;
		int num2 = 10;
		
		boolean result = num1 > num2;
		
		System.out.println(result);
		
		System.out.println(num1 < num2);
		
		System.out.println(num1 <= num2);
		
		System.out.println(num1 >= num2);
		
		
		String s = "최기근";
		String s1 = "최기근";
		
		System.out.println(s == s1);
		String s2 = new String("최기근");
		
		System.out.println(s == s2);
		
		System.out.println(s.contentEquals(s2));
		
		
		

	}

}
