package net.koreate.www.extends1.test3;

public class Student extends Human{

	String cRoom; // 교실
	String sNum; // 학번
	String grade; // 학년
	
	public Student(String name, int age, int weight, int height,String cRoom, String sNum, String grade) {
		
//		super(name,age,weight,height);
		
		// 상속받은 필드도 this로 접근이 가능하지만
		// 헷갈리는걸 방지하기위해 super사용.
		
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
		
		this.cRoom = cRoom;
		this.sNum = sNum;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return super.toString() + " "+
				" 교실 : " + cRoom + 
				" 학번 : " + sNum + 
				" 학년 : " + grade + "]";
	}
	
	
	
	
}
