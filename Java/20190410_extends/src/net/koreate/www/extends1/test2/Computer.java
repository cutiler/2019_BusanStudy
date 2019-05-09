package net.koreate.www.extends1.test2;

public class Computer extends Calculator{

	double pi = 3.141592;
	
	
	
	// 재정의를 할때 제대로 하는지 알려줌.
	@Override	
	public double circleArea(double radius) {
		System.out.println("Computer 에 존재하는 circleArea 호출");
		return radius * radius * pi;
	}

	
	
	
}
