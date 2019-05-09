package net.koreate.www;

import java.util.Scanner;

public class LottoTest {
	
	public static void main(String[] args) {
		
		double random = Math.random();
		System.out.println(random);
		
		int r = (int)(Math.random()*45)+1;
	//	System.out.println(r);
		
		int lotto[] = new int[6];
		
		for(int i =0; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45)+1;
		//	System.out.print(lotto[i]+" ");
			for(int j =0; j < i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;					
				}
				
			}
			
		}System.out.println();
		
		int temp = 0;
		
		for(int i=0; i<lotto.length;i++) {
			
			for(int j = i+1; j<lotto.length;j++) {
				if(lotto[i] > lotto[j]) {
					temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}				
			}
			
		}
		
		/*
		 * for(int l : lotto) { System.out.print(l+" "); }System.out.println();
		 */
		
		boolean isRun = true;

		int[] myLotto = new int[6];
		
		Scanner sc = new Scanner(System.in);
		
		while(isRun) {
			
			System.out.println("===================================");
			System.out.println("1.로또구입 | 2.번호확인 | 3.당첨확인 | 4.종료");
			System.out.println("===================================");
			

			System.out.println("번호를 선택해 주세요 > ");
			int selectNo = sc.nextInt();
			
			if(selectNo == 1) {
				System.out.println("로또 구입 > ");
				// 1 ~45의 정수값을 입력 받아 myLotto 배열에 값을 넣어주자.
				
				for(int i = 0; i < myLotto.length; i++) {
					System.out.println((i+1)+"번째 번호를 입력하세요 >");
					int result = sc.nextInt();
					if(result < 1 || result > 45) {
						System.out.println("1~45까지의 정수를 입력해주세요");
						i--;
					}else {
						myLotto[i] = result;
						
					}
				}
				
				for(int i=0; i<myLotto.length;i++) {
					
					for(int j = i+1; j<myLotto.length;j++) {
						if(myLotto[i] > myLotto[j]) {
							temp = myLotto[i];
							myLotto[i] = myLotto[j];
							myLotto[j] = temp;
						}				
					}
					
				}
				
			}else if(selectNo == 2) {
				System.out.println("번호 확인");
				for(int i : myLotto) {
					System.out.print(i+" ");
				}System.out.println();
				
			}else if(selectNo == 3) {
				System.out.println("당첨 확인");
				System.out.println("당첨 번호");
				for(int i : lotto) {
					System.out.print(i+" ");
					
				}System.out.println();
				System.out.println("나의 번호");
				for(int i : myLotto) {
					System.out.print(i+" ");
					
				}System.out.println();
				
				int count = 0;
				for(int i=0; i <myLotto.length; i++) {
					for(int j =0; j < lotto.length; j++) {
						if(myLotto[i] == lotto[j]){
							count++;							
						}
					}
					
				}
				System.out.println("동일한 번호 개수는 : "+count);
				
				
			}else{
				System.out.println("프로그램 종료");
				isRun = false;
			}
			
		}
		
		sc.close();
		
	}

}
