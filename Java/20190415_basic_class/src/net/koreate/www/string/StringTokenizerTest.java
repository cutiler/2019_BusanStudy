package net.koreate.www.string;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {

		String text = "홍길동|최기근|이순신|전지현";
		
		String[] names = text.split("\\|");
		System.out.println(names.length);
		for(String s : names) {
			System.out.println(s);
		}
		
		String text2 = "홍길동/이순신/박문수";
		StringTokenizer st = new StringTokenizer(text2,"/");
		int count = st.countTokens();
		System.out.println(count);
		for(int i=0; i <count; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
		int count1 = st.countTokens();
		System.out.println(count1);
		
		StringTokenizer st1 = new StringTokenizer(text2,"/");
		while(st1.hasMoreTokens()) {
			String token = st1.nextToken();
			System.out.println(token);
			
		}

	}

}
