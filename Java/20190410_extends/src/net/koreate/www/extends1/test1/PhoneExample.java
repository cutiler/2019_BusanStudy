package net.koreate.www.extends1.test1;

public class PhoneExample {

	public static void main(String[] args) {

		Phone p = new Phone();
		p.powerOn();
		p.bell();
		p.sendVoice("여보세요!");
		p.receiveVoice("고객님 이번에 저희 보험에서.... 새로운 상품이....");
		p.sendVoice("아 네 괜찮습니다.");
		p.hangUp();
		p.powerOff();
		
		DmbPhone dmbphone = new DmbPhone("가로본능","실버",8);
		
		dmbphone.powerOn();
		dmbphone.bell();
		dmbphone.sendVoice("여보세요");
		dmbphone.receiveVoice("이번에 대출 금리가... 저금리로....");
		dmbphone.sendVoice("꺼저!");
		dmbphone.hangUp();
		dmbphone.turnOnDmb();
		dmbphone.changeChannel(10);
		dmbphone.turnOff();		
	}

}
