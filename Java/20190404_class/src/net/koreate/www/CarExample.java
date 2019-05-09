package net.koreate.www;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car c = new Car();
		c.company = "SM";
		c.model = "SM6";
		c.maxSpeed = 280;
		
		System.out.println("c 제조회사 :"+c.company);
		System.out.println("c 모델명 :"+c.model);
		System.out.println("c 최고속도 :"+c.maxSpeed);
		
		Car c1 = new Car();
		c1.company = "KIA";
		c1.model =  "K9";
		c1.maxSpeed = 250;
		c1.maxSpeed = 100;
		
		//System.out.println(c1.tire.size);
		
		Tire tire = new Tire();
		tire.size = 36;
		c1.tire = tire;
		
		System.out.println(c1.tire.size);
		
		System.out.println("c1 제조회사 :"+c1.company);
		System.out.println("c1 모델명 :"+c1.model);
		System.out.println("c1 최고속도 :"+c1.maxSpeed);
		
		System.out.println(c == c1);
		
		
		Car c2 = new Car("Benz","C350",280);
		
		System.out.println("c2 제조회사 :"+c2.company);
		System.out.println("c2 모델명 :"+c2.model);
		System.out.println("c2 최고속도 :"+c2.maxSpeed);
		
		
		int speed = c2.speedUp(10);
		System.out.println(speed);
	}

}
