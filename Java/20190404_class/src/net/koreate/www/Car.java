package net.koreate.www;

class Tire {
	int size;	
}

public class Car {
	
	//제조사
	String company;
	//모델명
	String model;
	// 최고속도
	int maxSpeed;
	// 현제 속도
	int speed;
	
	// 타이어
	Tire tire;
	
	
	 public Car() { 
		 //기본 생성자
		 System.out.println("기본 생성자 호출"); 
		 }
	 	
	/*
	 * public Car(String c, String m, int maxS) { System.out.println("두번째 생성자 호출");
	 * company = c; model = m; maxSpeed = maxS;
	 * 
	 * }
	 */
	
	public Car(String company, String model, int maxSpeed) {
		System.out.println("두번째 생성자 호출");
		this.company = company;
		this.model = model;
		this.maxSpeed = maxSpeed;
		
	}
	
	
	int speedUp(int x) {
		speed += x;
		return speed;
	}
	
	int speedDown(int x) {
		speed -= x;
		return speed;		
	}
	
	void setModel(String s) {
		model = s;
	}
		

}
