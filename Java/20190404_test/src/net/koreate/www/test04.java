package net.koreate.www;

import java.util.Scanner;

public class test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a,b;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수를 입력하세요 > ");
		
		a = sc.nextInt();
		
		System.out.print("첫번째 정수를 입력하세요 > ");
		
		b = sc.nextInt();
		
		if (a < b) System.out.println("큰수는 "+b);
		else if(a > b) System.out.println("큰수는 "+a);
		else System.out.println("두 값이 동일합니다.");
		
		
	}

}
