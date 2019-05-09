package net.koreate.www.extends1.poly;

public class KumhoTire extends Tire{
	
	public KumhoTire(String location, int maxRocation) {
		super(location, maxRocation);
		
	}
	
	
	@Override
	public boolean roll() {
		++accRocation;
		if(accRocation < maxRocation) {
			System.out.println(this.location +" 금호타이어의 수명 "+(maxRocation - accRocation)+" 회");
			return true;
		}
		
		return false;
	}

}
