package net.koreate.www.abstracttest;

public abstract class Animal {
	
	String kind;
	
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}
	
	abstract public void sound();

}
