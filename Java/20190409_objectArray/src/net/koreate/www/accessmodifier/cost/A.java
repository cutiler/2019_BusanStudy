package net.koreate.www.accessmodifier.cost;

public class A {

	A a1 = new A();
	A a2 = new A(1);
	A a3 = new A("이기적인 놈");
	
	public A() {
	
	}
	
	A(int a){}
	
	private A(String s){}
	
	

}
