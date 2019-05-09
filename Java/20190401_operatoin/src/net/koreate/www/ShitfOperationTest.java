package net.koreate.www;

public class ShitfOperationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		byte num = (byte)0B00000101; //5를 이진수로 표현
		//   7  6  5  4 3 2 1 0
		// 128 64 32 16 8 4 2 1
		//   0  0  0  0 0 1 0 1 == 5
		System.out.println(num);
		System.out.println(num << 2);

	}

}
