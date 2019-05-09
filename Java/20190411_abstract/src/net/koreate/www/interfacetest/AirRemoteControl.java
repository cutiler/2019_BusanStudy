package net.koreate.www.interfacetest;

public class AirRemoteControl implements RemoteControl {

	int value = 0;
	
	@Override
	public void turnOn() {
		System.out.println("에어콘을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("에어콘을 끕니다.");
	}

	@Override
	public void setValue(int value) {
		this.value = value;
		System.out.println(this.value+"로 온도를 설정합니다.");
	}
	
	

}
