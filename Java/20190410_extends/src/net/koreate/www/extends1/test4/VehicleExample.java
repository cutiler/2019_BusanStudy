package net.koreate.www.extends1.test4;

public class VehicleExample {

	void runVehicle(Vehicle v) {
		v.run();
	}	
	
	public static void main(String[] args) {
	
		Vehicle v = new Vehicle();
		Bus b = new Bus();
		Taxi t = new Taxi();
		
		VehicleExample ve = new VehicleExample();
		
		// 파라미터 다형성
		ve.runVehicle(v);
		ve.runVehicle(b);
		ve.runVehicle(t);
	}

}
