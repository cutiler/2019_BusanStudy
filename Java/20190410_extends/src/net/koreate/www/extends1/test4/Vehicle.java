package net.koreate.www.extends1.test4;

public class Vehicle {
	
	public void run() {
		System.out.println("탈것이 달립니다.");
	}

}

class Bus extends Vehicle{
	
	public void run() {
		System.out.println("버스가 달립니다.");
	}
	
}

class Taxi extends Vehicle{
	
	public void run() {
	
		System.out.println("택시가 달립니다.");
		
	}	
	
}