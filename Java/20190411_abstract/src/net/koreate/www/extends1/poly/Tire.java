package net.koreate.www.extends1.poly;

public class Tire {
	
	int maxRocation; // 최대 회전수(수명)
	int accRocation; // 누적회전수
	String location;  // 타이어의 위치
	
	public Tire(String location, int maxRocation) {
		this.location = location;
		this.maxRocation = maxRocation;
	}
	
	public boolean roll() {
		++accRocation;
		if(accRocation < maxRocation) {
			System.out.println(location+" tire 수명이 "+(maxRocation - accRocation)+"회");
			return true;
		}
		return false;
	}

}
