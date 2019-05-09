package net.koreate.www;

public class logic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1 = 5;
		int num2 = 10;
		
		boolean result = (num1 > 0) && (num2 > 0);
		
		System.out.println(result);
		
		result = (num1 > 0) && (num2 < 0);
		
		System.out.println(result);
		
		result = (num1 < 0) && (num2 > 0);
		
		System.out.println(result);
		
		boolean result1 = (num1 < 0) || (num2 > 0);
		
		System.out.println(result1);
		System.out.println(!result1);
		
		

	}

}
