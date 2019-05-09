package net.koreate.www.ifenum;

import java.util.Scanner;

public class DoWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		boolean isLogin = false;
		
		do {
			System.out.println("===== 로그인 =====");
			System.out.println("아이디를 입력해주세요 > ");
			String id = sc.next();
			System.out.println("비밀번호를 입력해주세요 > ");
			String pw = sc.next();
			
			if(id.equals("id001") && pw.equals("12345")){
				System.out.println("로그인 성공");
				isLogin = false;
								
			}else {
				System.out.println("로그인 실패");
				isLogin = true;
				
			}
			
			
		}while(isLogin);
		
		sc.close();
		System.out.println("main method 종료");

	}

}
