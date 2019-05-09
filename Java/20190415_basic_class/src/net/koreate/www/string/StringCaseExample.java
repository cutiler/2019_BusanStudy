package net.koreate.www.string;

public class StringCaseExample {

	public static void main(String[] args) {
		
		String str1 = "Java Programming";
		String str2 = "JAVA Programming";
		
		System.out.println(str1.equals(str2));
		
		String lowerStr1 = str1.toLowerCase();
		String lowerStr2 = str2.toLowerCase();
		System.out.println("lowerStr 1 :"+lowerStr1);
		System.out.println("lowerStr 2 :"+lowerStr2);
		System.out.println(lowerStr1.equals(lowerStr2));
		
		System.out.println(str1.toUpperCase().equals(str2.toUpperCase()));
		
		System.out.println(str1.equalsIgnoreCase(str2));
		
		// trim();
		String tel1 = "              02";
		String tel2 = "1234            ";
		String tel3 = "   1234         ";
		String tel4 = "010 9486 7166";
		System.out.println(tel1.trim()+tel2.trim()+tel3.trim());
		System.out.println(tel4.trim());
		
		// vlaueOf()
		String s = String.valueOf(1);
		String s1 = String.valueOf(0.234);
		String s2 = String.valueOf(true);
		
		System.out.println(s +s1 +s2);
		String s3 = 1+"abcd";
		s3 = s3+100;
		System.out.println(s3);
		

	}

}
