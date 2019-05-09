package net.koreate.www.extends1.poly;

public class CarExample {

	public static void main(String[] args) {

		Car car = new Car();
		
		for(int i =0; i <= 5; i++) {
			int problemLocation = car.run();
			
			switch(problemLocation) {
				case 1:
					System.out.println("앞 왼쪽 바퀴 문제 한국 타이어로 교체");
					car.frontLeftTire = new HankookTire("앞왼쪽",20);
					break;
				case 2:
					System.out.println("앞 오른쪽 바퀴 문제 금호 타이어로 교체");
					car.frontRightTire = new KumhoTire("앞오른쪽",20);
					break;
				case 3:
					System.out.println("뒤 왼쪽 바퀴 문제 한국 타이어로 교체");
					car.backLeftTire = new HankookTire("뒤왼쪽",20);
					break;
				case 4:
					System.out.println("뒤 오른쪽 바퀴 문제 금호 타이어로 교체");
					car.backRightTire = new KumhoTire("뒤오른쪽",20);
					break;
			}
			
		}

	}

}
