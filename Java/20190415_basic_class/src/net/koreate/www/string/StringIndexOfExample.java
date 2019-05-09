package net.koreate.www.string;

public class StringIndexOfExample {

	public static void main(String[] args) {

		String str = "자바 프로그래밍 자바!";
		//	indexOf && lastIndexOf
		
		int location = str.indexOf("프로그래밍");
		System.out.println(location);
		
		if(str.indexOf("자바") != -1) {
			System.out.println("자바가 존재합니다.");
		}else {
			System.out.println("자바가 존재하지 않습니다.");
		}
		System.out.println(str.indexOf("자바"));
		System.out.println(str.lastIndexOf("자바"));

	}

}
