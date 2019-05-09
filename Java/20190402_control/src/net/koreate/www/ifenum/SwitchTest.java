package net.koreate.www.ifenum;

import java.util.Scanner;

public class SwitchTest {
	public static void main(String[] args) {
		
		int a = 10;
		
		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * System.out.print("a을 입력해주세요 : ");
		 * 
		 * a = sc.nextInt();
		 */
				
		switch(a) {
		
		case 1: System.out.println("a는 1");
		break;
		case 3: System.out.println("a는 3");
		break;
		case 5: System.out.println("a는 5");
		break;
		case 7: System.out.println("a는 7");
		break;
		case 9: System.out.println("a는 9");
		break;
		case 10: System.out.println("a는 10");
		break;
			default :
				System.out.println("일치하는 값이 없습니다.");
				
		}
		
		
		
		Scanner sc = new Scanner(System.in);
//		월에 따른 날의 수를 반환 하는 프로그램
		System.out.println("월을 입력해 주세요 > ");
		int month = sc.nextInt();
		int day = 0;
		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			day = 31;
			break;
		case 4: case 6: case 9: case 11: 
			day = 30;
			break;
		case 2:
			day = 28;
			break;
			default :
				System.out.println("존재하지 않는 월입니다.");
				
		}
		
		System.out.println(month + "월의 날 수는" + day + "일입니다.");
		
		
		char grade = 'A';
		
		switch(grade) {
		case 'A':
			System.out.println("A 학점 입니다.");
			break;
		case 'B':
			System.out.println("B 학점 입니다.");
			break;
		case 'C':
			System.out.println("C 학점 입니다.");
			break;
		case 'D':
			System.out.println("D 학점 입니다.");
			break;
		case 'F':
			System.out.println("F 학점 입니다.");
			break;
		}
		
		String rank = "Gold";
		switch(rank) {
		case "Gold":
			System.out.println("금메달 입니다.");
			break;
		case "Silver":
		System.out.println("은메달 입니다.");
		break;
		case "Bronze":
		System.out.println("동메달 입니다.");
		break;
		default :
			System.out.println("획득한 메달이 없습니다.");
		}
	}

}
