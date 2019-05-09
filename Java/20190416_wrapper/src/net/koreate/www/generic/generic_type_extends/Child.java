package net.koreate.www.generic.generic_type_extends;

public class Child<T, M, C> extends Parent<T, M> {

	private C company;

	public C getCompany() { return company;}

	public void setCompany(C company) {	this.company = company;	}
	
	
	
}
