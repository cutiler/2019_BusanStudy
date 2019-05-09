package net.koreate.www.classtest;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car car = new Car();
		System.out.println("주소값 : "+car);
		System.out.println(car.company);
		System.out.println(car.model);
		System.out.println(car.engine);

		car.engine = new Engine();
		
		Engine engine = new Engine();
		
		Car car1 = new Car();
		car1.engine = engine;
		engine.maxSpeed = 300;
		
		car.engine = engine;
		
		System.out.println(engine.maxSpeed);
		System.out.println(car1.engine.maxSpeed);
		System.out.println(car.engine.maxSpeed);
		
		Car car2 = new Car();
		car2.setEngine(engine);
		car2.engine.maxSpeed = 200;
		
	}

}
