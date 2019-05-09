package net.koreate.www.extends1.test1;

public class SmartPhone extends DmbPhone{
	
	String url;
	
	SmartPhone(String model, String color, int channel, String url){
		super(model,color,channel);
		this.url = url;
	}	
	
	void turnOnInternet() {
		System.out.println("인터넷"+url+"을 켭니다.");
	}
	
	void turnOffInternet() {
		System.out.println("인터넷을 끕니다.");
	}
	
	void changeUrl(String url) {
		this.url = url;
		System.out.println(url+" 을 켭니다.");
	}

}
