package net.koreate.www.accessmodifier.filed_method_access;

public class B {
	
	public B() {
		A a = new A();
		a.field1 = 10; //public
		a.field2 = 10; // default
		//a.filed3 = 10; // private
		a.method1(); // public
		a.method2(); // default
//		a.method3(); // default
	}

}
