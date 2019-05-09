package net.koreate.www.generic.generic_mothod2;

public class CompareMethodExample {
	
	public static void main(String[] args) {
		
		Pair<Integer, String> pair1 = new Pair<>(1,"사과");
		Pair<Integer, String> pair2 = new Pair<>(1, "사과");
		
		boolean result1 = Util.<Integer, String>compare(pair1,pair2); 
		
		if(result1) {
			System.out.println("논리적으로 동등한 객체입니다.");
		}else {
			System.out.println("논리적ㅇ로 동등하지 않는 객체입니다.");
		}

		Pair<String, String> p1 = new Pair<>("user1","최기근");
		Pair<String, String> p2 = new Pair<>("user2","최기근");
		
		boolean reuslt2 = Util.compare(p1, p2);
		
	}

}
