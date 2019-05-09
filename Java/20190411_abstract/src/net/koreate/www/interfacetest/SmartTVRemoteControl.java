package net.koreate.www.interfacetest;

public class SmartTVRemoteControl implements RemoteControl, Searchable {

	int value =1;	
	
	// Searchable
	@Override
	public void search(String word) {
		System.out.println(word+"로 검색합니다.");
	}
	
	// RemoteControl
	@Override
	public void turnOn() {
	
		System.out.println("스마트 TV를 켭니다.");
		
	}

	@Override
	public void turnOff() {
	
		System.out.println("스마트 TV를 끕니다.");
		
	}

	@Override
	public void setValue(int value) {
	
		this.value = value;
		System.out.println("스마트 TV 채널을 "+value+"로 설정합니다.");
	}	
	
}
