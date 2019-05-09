package net.koreate.www;

import java.util.Scanner;

public class test07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int size =10;
		int[] seats = new int[size];
		
		while(true) {
			System.out.println("---------------------");
			for(int i=0;i<size;i++)
				System.out.print(i+1+" ");
			System.out.println("\n---------------------");
			for(int i=0;i<size;i++)
				System.out.print(seats[i]+" ");	
			System.out.println("\n---------------------");
			
			System.out.print("원하시는 좌석번호를 입력하세요.(종료는 -1)");
			Scanner scan = new Scanner(System.in);
			int s = scan.nextInt();
			if (s == -1) break;
			if (seats[s-1] == 1) System.out.println(s +"좌석은 이미 예약 되어있습니다.");
			seats[s-1] = 1;
		}
		
		
	}

}
