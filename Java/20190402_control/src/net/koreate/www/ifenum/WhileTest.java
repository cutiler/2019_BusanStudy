package net.koreate.www.ifenum;

import java.util.Scanner;

public class WhileTest {
	
	public static void main(String[] args) {
		
		int i = 1;
		int sum = 0;
		
		while(i <= 10) {
			System.out.println("i = "+i);
			sum += i;
			i++;
			
		}
		System.out.println(sum);
		
		Scanner sc = new Scanner(System.in);
		
		boolean isLogin = true;
		
		while(isLogin) {
			System.out.println("아이디를 입력해주세요 > ");
			String id = sc.next();
			System.out.println("비밀번호를 입력해주세요 > ");
			String pw = sc.next();
			
			if(id.equals("id001") && pw.equals("12345")){
				System.out.println("로그인 완료");
				isLogin = false;
				
			}else {
				System.out.println("아이디와 패스워드가 일치하지 않습니다. \n 다시 시도해주세요");
				
			}
			
		}
		
		sc.close();		
		
	}

}
