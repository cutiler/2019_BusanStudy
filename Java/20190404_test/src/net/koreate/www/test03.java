package net.koreate.www;

public class test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum=0;
		
		boolean check;
		
		for(int i=1; i < 101; i++) {
			if(i%2 != 0) {
				sum += i;
			}
		}
		System.out.println("홀수의 합: "+sum);
	}

}
