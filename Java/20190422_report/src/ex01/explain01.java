package ex01;

import java.util.Scanner;

public class explain01 {
	
	public static void main(String[] args) {
		
		Scanner si = new Scanner(System.in);
		
		System.out.println("크기를 입력하세요");
		
		int input;
		input = si.nextInt();
		
		int[][] array = new int[input+1][input+1];
//		System.out.println("입력받은 크기는 "+input);
		
		for(int i =0; i <= input; i++) {
			for(int j = 0; j <= i; j++) {
				array[i][j] = j;
			}

		}
		
		for(int i =0; i <= input; i++) {
			for(int j = 0; j <= i; j++) {
					System.out.print(array[i][j]);
			}System.out.println();

		}
		
		
		
		
	}
			

}
