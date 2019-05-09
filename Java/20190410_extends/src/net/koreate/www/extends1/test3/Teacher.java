package net.koreate.www.extends1.test3;

public class Teacher extends Human{
	
	String tNumber; //교번
	String subject; //교과목
	String grade; // 담당 학년
	
	Teacher(String name, int age, int weight, int height, String tNumber, String subject, String grade){
		super(name,age,weight,height);
		this.tNumber = tNumber;
		this.subject = subject;
		this.grade = grade;
		
		
	}
	
	public void teach() {
		System.out.println(subject+"를 가르칩니다.");
	}

	@Override
	public String toString() {
		return super.toString() +
				" 교번 : " + this.tNumber
				+  " 교과목 : " + this.subject
				+ " 담당학년 : " + this.grade;
	}
	
}
