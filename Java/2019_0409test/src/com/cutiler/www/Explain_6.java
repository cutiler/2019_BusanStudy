package com.cutiler.www;

import java.util.Scanner;

public class Explain_6 {
	
	public static void main(String[] args) {
		
		int grade;
		
		Scanner sc = new Scanner(System.in);
		
		boolean isRun = true;
		
		while(isRun) {
			System.out.println("점수를 입력해주세요 >");
			grade = sc.nextInt();
			
			if(grade <= 100 && grade >= 90) System.out.println("A학점 입니다.");
			else if(grade < 90 && grade >= 80) System.out.println("B학점 입니다.");
			else if(grade < 80 && grade >= 70) System.out.println("C학점 입니다.");
			else if(grade < 70 && grade >= 60) System.out.println("D학점 입니다.");
			else if(grade < 60 && grade >= 0) System.out.println("F학점 입니다.");
			else isRun = false;
		}
		
		
	}

}
