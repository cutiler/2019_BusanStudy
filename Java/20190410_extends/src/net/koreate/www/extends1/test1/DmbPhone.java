package net.koreate.www.extends1.test1;

public class DmbPhone extends Phone{
	
	int channel;
	
	public DmbPhone() {}
	
	public DmbPhone(String model, String color, int channel) {
		super.model = model;
		super.color = color;
		this.channel = channel;
	}
	
	void changeChannel(int channel) {
		this.channel = channel;
		System.out.println("채널 이"+this.channel+"로 변경되었습니다.");
	}
	
	void turnOnDmb() {
		System.out.println("DMB 수신을 시작합니다.");
	}
	
	void turnOff() {
		System.out.println("DMB 수신을 종료합니다.");
	}
	
}
