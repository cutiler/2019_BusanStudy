package net.koreate.www.generic.multitype;

public class ProductExample {
	
	public static void main(String[] args) {
		
		Product<Tv, String> p = new Product<>();
		p.setKind(new Tv());
		String model1 = "LG 스마트 TV ";
		p.setModel(model1);
		
		Product<Car, Integer> p1 = new Product<>();
		
		p1.setKind(new Car());
		p1.setModel(100);
		
		
	}

}
