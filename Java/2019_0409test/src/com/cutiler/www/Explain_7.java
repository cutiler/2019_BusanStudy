package com.cutiler.www;

public class Explain_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] lotto = new int[6];
		
		int max;
		
		// 인덱스 0에는 number값을 대입하고
		// 그후 중복 검사하고 소팅.
		
		for(int i=0; i < 6; i++) {
			int number = (int)(Math.random()*45)+1;
			if (lotto[i] == 0) lotto[i] = number;
			
		
		}
		
	}

}
