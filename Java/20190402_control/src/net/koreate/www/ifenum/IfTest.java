package net.koreate.www.ifenum;

import java.util.Scanner;

public class IfTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 10;
		int b = 100;
		
		boolean op = a > b;
		
		System.out.println("op : "+op);
		
		if(!op) {
			System.out.println("a가 b보다 작거나 같습니다.");
			
		}
		
		
		
		if( a < b) {
			System.out.println("a가 b보다 작습니다.");
			
		}else {
			System.out.println("a가 b보다 크거나 같습니다.");
			
		}
		
		// 삼항 연산자
		
		boolean result = (a<b) ? true : false;
		System.out.println("result : "+ result);
		
		int score = 75;
		
		if(score >= 90) {
			System.out.println("A");
		}else if (score >= 80) {
			System.out.println("B");			
		}else if(score >= 70) {
			System.out.println("C");
			if(score >= 77) {
				System.out.println("C+");				
			}else if(score >= 73) {
				System.out.println("C0");
			}else {
				System.out.println("C-");
			}
		}else if(score >= 60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
		
		//String id = "id001";
		//String pw = "pw001";
		
		// ctrl + /
		
		/*
		 * ctrl + shit + /
		*/

		
		// ctrl + shift + o
		Scanner sc = new Scanner(System.in);
		System.out.println("ID 를 입력해 주세요 > ");
		String id = sc.next();
		
		
		
		System.out.println("PASSWORD 를 입력해 주세요 > ");
		String pw = sc.next();
		
		
		if(id == "id001" && pw == "pw001") {
			System.out.println("정상적으로 로그인 되었습니다.");
		}else {
			System.out.println("아이디와 패스워드가 일치하지 않습니다.");
			
		}
		sc.close();
		
		System.out.println("메인종료");

	}

}
