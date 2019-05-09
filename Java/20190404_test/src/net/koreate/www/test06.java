package net.koreate.www;

public class test06 {

	public static void main(String[] args) {
		
		int s[] = {12,3,19,6,18,8,12,4,1,19};
		int mininum=0;
		
		mininum = s[0];
		
		for(int i =1; i < s.length ; i++) {
			
			if(mininum > s[i]) mininum = s[i];
		
		}
		
		
		System.out.println("최소값은 :"+mininum+" 입니다.");
	}
	
}
