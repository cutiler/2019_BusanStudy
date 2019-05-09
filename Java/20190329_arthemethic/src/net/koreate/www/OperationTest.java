package net.koreate.www;

public class OperationTest {
	
	public static void main(String[] args){
		
		// + - / * %
		
		int num1 = 10;
		int num2 = 20;
		
		System.out.println(+num1);
		System.out.println(-num2);
		System.out.println(num2);
		
		num2 = -num2;
		
		System.out.println(num2);
		
		
		int sum = num1 + num2;
		
		System.out.println(sum);
		
		
		int i = 10;
		int i2 = 3;
		
		int divide = i / i2;
		
		System.out.println("divide : "+divide);
		
		
		double d = i / i2;
		
		System.out.println("d : " + d);
		
		
		double result = (double)i/i2;
		
		System.out.println("result : " + result);
		
		
		System.out.println(i % i2);
		
		
		int multi = i * i2;
		System.out.println(multi);
		
		
		String s = "문자열";
		
		String s1 = "테스트!";
		
		String str = s + " " + s1;
		
		System.out.println(str);
		
		str = s + num1;
		
		System.out.println(str);
		
		System.out.println("num1 : "+num1);
		
	}
	

}
