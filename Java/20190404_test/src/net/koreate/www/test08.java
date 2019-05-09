package net.koreate.www;

import java.util.Scanner;

public class test08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 예약 정보 저장
		int [][] seats = new int[10][10];
		
		
		// 반복 flag
		boolean isRun = true;
		
		// 열이름
		String strColumn;
		char inputColumn;
		
		// 행번호
		int rowNum;
		
		char charA = 'A';		
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("    SCREEN      ");
			for(int i=0; i < seats.length; i++) {
				System.out.print("["+(i+1)+"]");
			}System.out.println(" [행]");
			
			for(int i =0; i < seats.length;i++) {
				for(int j =0; j < seats[i].length;j++) {
						
					if(seats[i][j] == 0) {
						System.out.print("[□]");
					}else System.out.print("(■]");
					
					//System.out.print("["+seats[i][j]+"]");
					
				}System.out.println(" ["+(char)(charA+i) +"열]");
				
			}
			
			System.out.println("예약하실 좌석의 열을 입력해주세요.");
			strColumn = sc.next();
			/*
			 * String s = "Hello Java"; char cs = s.charAt(0);
			 */
			
			inputColumn = strColumn.trim().charAt(0);
			System.out.println("입력한 열 : "+inputColumn);
			
			if(inputColumn < 'A' || inputColumn > 'K') {
				System.out.println("선택할 수 없는 열입니다.");
				continue;				
			}
			
			int column = inputColumn - 'A';
			
			System.out.println("예약 하실 좌석의 행 번호를 입력해주세요 >");
			
			rowNum = sc.nextInt();
			
			if(rowNum < 1 || rowNum > 10) {
				System.out.println("선택하실 수 없는 행 번호 입니다.");
				continue;
			}
			
			System.out.println("선택하신 좌석은 : "+inputColumn+"열 "+rowNum+" 행입니다.");
			System.out.println("예약 완료 하시겠습니까: y/n");
			
			String s = sc.next();
			if(s.equals("y") || s.equals("Y") ) {
				seats[column][rowNum-1] = 1;
				System.out.println("예약이 완료 되었습니다.");
			}else {
				System.out.println("취소되었습니다.");				
				isRun = false;
			}
			
			
		}while(isRun);
		
		
		sc.close();
		
	}

}
