package net.koreate.www.interfacetest.extends1;

public class MyClassTest {

	public static void main(String[] args) {
		
		MyClass myClass = new MyClass();
		
		myClass.printA();
		myClass.printB();
		myClass.printC();
		
		A a = new MyClass();
		a.printA();
		
		B b = (B)a;
		b.printB();
		
		C c = new MyClass();
		
		c.printA();
		c.printB();
		c.printC();

	}

}
