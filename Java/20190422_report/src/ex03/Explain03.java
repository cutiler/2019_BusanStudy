package ex03;

import java.util.Random;

public class Explain03 {

	public static void main(String[] args) {
		
		Random rndObj = new Random();
		
		int[] myArray = new int[10];
		int temp=0;
		int count =1;
				
		// 10개의 난수를 생성하고 중복되면 제거.
		for(int i =0; i < 10; i++) {
			for(int j=0; j < count; j++) {
				
			}			
			
		
		}
		
		System.out.print("최초의 리스트 : ");
		for(int i : myArray) {
			System.out.print(i+" ");
		}System.out.println();
			
		
		for(int i=0; i < 10; i++) {
			for(int j=0; j < 9; j++) {
				if(myArray[j] > myArray[j+1]) {
					temp = myArray[j];
					myArray[j] = myArray[j+1];				
					myArray[j+1] = temp;				
			}
		}
		}
		
		System.out.print("정렬된 리스트 : ");
		for(int i : myArray) {
			System.out.print(i+" ");
		}System.out.println();
		
		
		
		
		
	}
	
}
