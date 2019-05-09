package ex02;

import java.util.Random;
import java.util.Scanner;

public class explain02 {
	
	public static void main(String[] args) {
		
		// 난수발생.,
		
		Random rdv = new Random();
				
		int randNum;
		
		randNum = rdv.nextInt(100)+1;
		
		Scanner sc = new Scanner(System.in);
		
		int userNum;
		int count = 0;
		boolean isCheck = true;
		
		 	do{
		 		count++;
		 		System.out.print("1~100까지의 정수를 입력해 주세요 : ");
		 		userNum = sc.nextInt();
		 		if(userNum < randNum) System.out.println("제시한 정수가 낮습니다.");
		 		else if(userNum > randNum) System.out.println("제시한 정수가 높습니다.");
		 		else {
		 			System.out.println("축하합니다. 시도횟수="+count);
		 			isCheck = false;
		 		}
				
			} while(isCheck);			
			
				
				
	}

}
