package com.cutiler.www.eclipse;

class Fonttest{
	int a;
	String[] b;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	
	Fonttest(){}
	
	public Fonttest(int a, String[] b) {
		super();
		this.a = a;
		this.b = b;
	}

}

public class EclipseTest {

	final static int c = 10;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0; i< 10; i++) {
			System.out.println(i);
			
		}
		System.out.println("이것은 스트링이다.");
		Fonttest f = new Fonttest();
		f.setA(10);

	}

}
