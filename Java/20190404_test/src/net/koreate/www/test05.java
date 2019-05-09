package net.koreate.www;

import java.util.Scanner;

public class test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = new int[5];
		int sum = 0;
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i < 5; i++) {
			System.out.print("성적을 입력하시오:");
			array[i] = sc.nextInt();
			sum += array[i];
		}
		
		System.out.println("평균 성적은"+ (sum/5) +"입니다.");
		
		

	}

}
