package net.koreate.www.string;

public class StringBuilderTest {

	public static void main(String[] args) {
	
		// StringBuffer & StringBuilder
		String javaStr = new String("java");
		
		StringBuilder sb = new StringBuilder(javaStr);
		System.out.println(sb.toString());
		
		sb.append(1);
		
		System.out.println(sb.toString());
		
		sb.insert(4, 2);
		
		System.out.println(sb.toString());
		
		
		sb.setCharAt(4, '6');
		System.out.println(sb.toString());
		
		sb.replace(0, 4, "Book");
		
		System.out.println(sb.toString());
		
		sb.delete(0,4);
		System.out.println(sb.toString());
		
	}

}
