package net.koreate.www;

public class TypeCastTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		byte v = 127;
		
		int i = v;
		
		int b1 = 128;
		
		byte v2 = (byte)b1;
		
		final int count = 3;
		
		int engScore = 100;
		int mathScore = 80;
		int koScore = 85;
		
		int sum = engScore + mathScore + koScore;
		System.out.println("전체 합계 : " + sum);
		
	
		double  avg = sum / (double)count;
		
		System.out.println("평균 : " + avg);

	}

}
