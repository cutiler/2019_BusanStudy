package net.koreate.www.object.tostring;

public class Phone {
	
	private String company;
	private String os;
	
	public Phone(String company, String os) {
		this.company = company;
		this.os = os;
	}
	
	@Override
	public String toString() {
		return this.company+" : "+this.os;
	}

}
