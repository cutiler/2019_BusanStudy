package net.koreate.www;

import java.util.Scanner;

public class StuManagementExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean isRun = true;
		
		int studentNum =0;		
		
		int scores[] = null;
		
		while(isRun) {
			
			System.out.println("============================");
			System.out.println("1.학생수 2.점수입력 3.전체 4.분석 5.종료");
			System.out.println("============================");
			System.out.print("> ");
			
			Scanner sc = new Scanner(System.in);
			
			int selectNo = sc.nextInt();
			
			if(selectNo != 1 && scores == null) {
				System.out.println("학생수를 먼저 입력해 주세요");
				continue;
			}
		
			
			switch(selectNo) {
			case 1:
				System.out.print("학생수 입력 > ");
				studentNum = sc.nextInt();
				scores = new int[studentNum];
				System.out.println("학생 수는 : "+scores.length);
				
				break;
			case 2:
				System.out.print("점수 입력 > ");
				for(int i=0;i<scores.length;i++) {
					System.out.println((i+1)+"번째 학생 점수 입력 > ");
					scores[i] = sc.nextInt();
					
				}
				break;
			case 3:
				System.out.print("전체점수 ");
				for(int i=0; i <scores.length; i++) {
					System.out.println((i+1)+" 번째 학생의 점수 는"+scores[i]+"입니다.");
					
				}
				break;

			case 4:
				System.out.print("분석 ");
				// 전체합계
				//전체평균
				//최고득점

				int sum = 0;
				int max =0;
				double avg = 0;
				int min = scores[0];

				for(int i : scores) {
					sum += i;
					if(max < i) max = i;
					if(min > i) min = i;
				}
				

				avg = sum/(double)studentNum;
				
				System.out.println("학생 수는 : " + scores.length);
				System.out.println("전체 합계 : " + sum);
				System.out.println("전체 평균 : " + avg);
				System.out.println("최고득점 : " + max);
				
				break;

			case 5:
				System.out.print("프로그램 종료 ");
				isRun = false;
				break;
				default:
					System.out.print("잘못 입력하셨습니다. ");
					break;
			
			}
			
			
			
		}
		

	}

}
