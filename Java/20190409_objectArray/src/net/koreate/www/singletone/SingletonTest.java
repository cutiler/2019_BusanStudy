package net.koreate.www.singletone;


class Student {

	
	private static Student s;
	// 외부에서 new 연산을 이용해 생성할 수 없음.
	private Student() {
		
	}
		
	public static Student getInstance() {
		if(s == null) {
			s = new Student();
		}
		
		return s;
	}
	
}


public class SingletonTest {
	
	

	private SingletonTest() {}
	
	
	
	public static void main(String[] args) {
		
		SingletonTest s = new SingletonTest();
		
		//Student s1 = new Student();
		Student s2 = Student.getInstance();
		
		Student s3 = Student.getInstance();
		
		System.out.println(s2 == s3);
		
	}

}
