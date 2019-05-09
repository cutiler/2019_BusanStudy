package net.koreate.www;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] scores = null;
		
		scores = new int[6];
		
		for(String str : args) {
			System.out.println("System argument : "+ str);
			
		}
		
		int length = scores.length;
		
		System.out.println("socres 의 길이 : "+ scores.length);
		
		int[] scores1 = {0,1,2,3,4,5};
		System.out.println(scores1[0]);
		
		String[] str = {"C언어","JAVA","C++","JSP"};
		for(int i = 0; i < scores.length; i++) {
			scores[i] = i;
		}
		
		for(int i : scores) {
			System.out.println(i);
			
		}
		
		
		
		
		String strs[] = new String[5];
		
		// s = strs[i], strs.legth. i++
		// for each 문.
		for(String s : strs) {
			System.out.println(s);
			
		}
		
		
		//2차원배열
		int[][] arrays2 = {
				{1,2,3}, {4,5,6,}
				
		};
		for(int i = 0; i < arrays2.length; i++) {
			for(int j = 0; j < arrays2[i].length; j++) {
				System.out.print(arrays2[i][j]+" ");
				
			}
			System.out.println();
			
		}
		
		char[] chars = new char[26];
		
		char c = 'A';
		
		for(int i=0; i < chars.length; i++, c++) {
			chars[i] = c;
			
		}
		
		for(char ch : chars) {
			System.out.println(ch);
			
		}
		

		
		
		
		
	}

}
