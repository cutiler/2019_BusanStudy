package net.koreate.www.objectarray;

public class Student {
	
	//번호
	int number;

	//이름
	String name;
	//정수
	int score;
	
	public Student() {}
	
	public Student(int number, String name, int score){
		this.number = number;
		this.name = name;
		this.score = score;
		
	}
	
	public String toString() {
		return "[student : number : "+ this.number
				+ ", name : " + this.name
				+ ", score : "+ this.score;
	}
	


}
