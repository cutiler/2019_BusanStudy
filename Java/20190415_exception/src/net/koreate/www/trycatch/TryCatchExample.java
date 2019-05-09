package net.koreate.www.trycatch;

import java.util.Scanner;

public class TryCatchExample {
	
	public static void main(String[] args) {
		System.out.println("Main START");
		
		String str = null;
		System.out.println(str);
		
		Scanner sc = new Scanner(System.in);
		int selectNo = 0;
		
		try {
			
			selectNo = sc.nextInt();
			
			System.out.println("try start");
			System.out.println(str.toString());
			System.out.println("try end");
		}catch(NullPointerException | java.util.InputMismatchException e) {
			e.printStackTrace();
			//System.out.flush();
		}finally {
			System.out.println("오류가 발생하든 발생하지 않든 실행");
		}
		
		try {
			selectNo = sc.nextInt();
			System.out.println(str.equals("id001"));
			
		}catch(NullPointerException e) {
			System.out.println("널 값 참조");
		}catch(java.util.InputMismatchException e) {
			System.out.println("사용자 작성 오류");
		}catch(Exception e) {
			System.out.println("오류 발생 : "+ e.getMessage());
		}
		
		
		
		
		System.out.println("Main END");
		
	}

}
