package net.koreate.www.extends1;

class Car{
	String company ="기아자동차";
	int maxSpeed;
	
	//Car() {	}

	Car(String company) {	
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public String toString() {
		return "Car [company=" + this.company + ", maxSpeed=" + this.maxSpeed + "]";
	}	
	
}

class Taxi extends Car{
	
	String model;
	
		
	
	
		public Taxi(String company) {
		super(company);		
		}



		public String toString() {
		return "[Taxi : model=" + this.model +
				" company : " + this.company +
				" maxSpeed : " + this.maxSpeed + "]";
	}
	
	
	
	
}

class Bus extends Car{

	public Bus() {
		super("현대자동차");
		System.out.println("aa");
	}
	
}



public class CarExample {

	public static void main(String[] args) {
		
		Taxi t = new Taxi("기아자동차");
		System.out.println(t.toString());
		
		Bus b = new Bus();
		System.out.println(b.toString());		
		
		
	}

}
