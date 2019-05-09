package net.koreate.www.interfacetest;

public class TVRemoteControl implements RemoteControl{

	
	int value=1;
	
		
	
	// RemoteControl
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
		
	}

	@Override
	public void setValue(int value) {
		this.value = value;
		System.out.println(this.value+" 로 음량을 설정합니다.");
		
	}


	

}
