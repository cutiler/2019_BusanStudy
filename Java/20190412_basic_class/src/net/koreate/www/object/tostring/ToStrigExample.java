package net.koreate.www.object.tostring;

public class ToStrigExample {

	public static void main(String[] args) {
	
		Object o = new Object();
				
		System.out.println(o.toString());
		//	위와 같음
		//	System.out.println(o);
				
		Phone phone = new Phone("구글", "안드로이드");
		// println에서 객체를 받으면 객체가 null이면 null을 출력하고
		// null이 아니라면 toString을 호출한다.
		System.out.println(phone);
	}

}
