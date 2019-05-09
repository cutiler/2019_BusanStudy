package com.cutiler.www;

import java.util.Scanner;

public class Explain_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String myId = "id001";
		
		System.out.print("아이디 입력 >");
		String id = sc.nextLine();
		
		if(myId.equals(id)) {
			System.out.println("아이디가 일치합니다.");
		}else {
			System.out.println("아이디가 일치 하지 않습니다.");
			
		}
		
		}

}
