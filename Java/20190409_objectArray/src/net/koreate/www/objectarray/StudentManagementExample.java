package net.koreate.www.objectarray;

import java.util.Scanner;

public class StudentManagementExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * Student[] students = new Student[5]; System.out.println(students[0]);
		 * 
		 * students[0] = new Student(); System.out.println(students[0].number);
		 * System.out.println(students[0].name); System.out.println(students[0].score);
		 * 
		 * Student student = new Student(); student.number = 1; student.name = "최기근";
		 * student.score = 100; students[1] = student;
		 * 
		 * System.out.println(students[1].number); System.out.println(students[1].name);
		 * System.out.println(students[1].score);
		 * System.out.println("==================================");
		 * System.out.println(students[1].toString());
		 * 
		 * for(int i=0;i<students.length;i++) { // Student(number, name, score);
		 * //students[i] = new Student(i+1,"이름"+i,i*10);
		 * 
		 * students[i] = new Student(); students[i].number = i+1; students[i].name =
		 * "이름"+i; students[i].score = i*10;
		 * 
		 * //System.out.println(i+"번째 "+students[i].toString());
		 * 
		 * }
		 * 
		 * for(Student s : students) { System.out.println(s.toString());
		 * 
		 * }
		 */
		
		// 학생 점수 관리
		Scanner sc = new Scanner(System.in);
		
		Student students[] = null;

		boolean isRun = true;
		
		int selectNo = 0;
		
		while(isRun) {
			System.out.println("========================================");
			System.out.println("1. 학생수 | 2. 정보입력 | 3. 정보확인 | 4. 분석 | 5. 종료");
			System.out.println("========================================");
			System.out.println("번호를 선택하세요 >");
			
			selectNo = sc.nextInt();
			
						
			
			switch(selectNo) {
				case 1 :
					System.out.println("학생수");
					System.out.println("학생수 입력 >");
					int stuCount = sc.nextInt();
					students = new Student[stuCount];
					System.out.println("학생수는 "+students.length+"명 입니다.");					
					break;
				case 2 :
					System.out.println("정보입력");
					for(int i = 0; i < students.length; i++) {
						
						System.out.println("이름을 입력해주세요 >");
						String name = sc.next();
						
						System.out.println("점수를 입력해주세요 >");
						int score = sc.nextInt();
									
						int number = i+1;
						
						students[i] = new Student(number,name,score);
						
					}
					break;
				case 3 :
					System.out.println("정보확인");
					for(Student s : students) {
						System.out.println(s.toString());						
					}					
					
					break;
				case 4 :
					System.out.println("분석");
					int sum = 0;
					double avg = 0;
					int max = 0;
					Student best = null;
					
					for(Student s : students) {
						sum += s.score;
						if(max < s.score) {
							max = s.score;
							best = s;							
						}						
					}
					
					System.out.println("총점 : "+sum);
					System.out.println("최고득점자 정보 :"+best.toString());
					System.out.println("최고점수 : "+max);
					System.out.println("평균 : "+ ((double)sum/students.length) );
					
					break;
				case 5 : default :
					System.out.println("시스템 종료");
					isRun = false;
			}
			
			
			
		}//while
		
		sc.close();
		
		
		
	}

}
