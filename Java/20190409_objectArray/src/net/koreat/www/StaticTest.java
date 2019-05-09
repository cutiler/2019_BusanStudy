package net.koreat.www;



class Student {
	
	static String school;
	
	String name;
	int age;
	String grade;
	
	boolean equals(Student s) {
		return s == this;
	}
	
}
public class StaticTest{
	
	static int a = 10;
	
	public static void sum(int x, int y) {
		System.out.println(x+y);
	}
	
	
		
	public static void main(String[] args) {
		
		a = 100;
		
		System.out.println(a);
		
		Student.school = "한국기술교육직업학교";
		
		Student s = new Student();
		s.name = "최기근";
		s.age = 20;
		s.grade = "A등급";
		System.out.println(s.name);
		System.out.println(s.age);
		System.out.println(s.grade);
		System.out.println(s.school);
		
		Student s1 = new Student();
		s1.name = "홍길동";
		s1.age = 30;
		s1.grade = "b등급";
		
		System.out.println(s1.name);
		System.out.println(s1.age);
		System.out.println(s1.grade);
		System.out.println(s1.school);
		
		s1.school = "한국IT교육센터";
		
		System.out.println(s.school);
		System.out.println(s1.school);
		
		sum(10,20);
		
	}

}
