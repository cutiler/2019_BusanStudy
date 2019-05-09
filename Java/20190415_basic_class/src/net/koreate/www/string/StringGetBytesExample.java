package net.koreate.www.string;

import java.io.UnsupportedEncodingException;

public class StringGetBytesExample {

	public static void main(String[] args) {

		String str = "한글표현";
		System.out.println(str.length());
		
		byte[] bytes1 = str.getBytes();
		System.out.println("bytes1 의 length : "+ bytes1.length);
		
		String str1 = new String(bytes1);
		System.out.println("str1 : "+str);
		
		
		
		try {
			// utf-8 한글 3바이트
			byte[] bytes2 = str.getBytes("UTF-8");
			System.out.println(bytes2.length);
			
			// euc-kr 한글 2바이트.
			byte[] bytes3 = str.getBytes("EUC-KR");
			System.out.println(bytes3.length);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
