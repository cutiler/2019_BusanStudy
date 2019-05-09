package net.koreate.www.accessmodifier.filed_method_access2;

import net.koreate.www.accessmodifier.filed_method_access.A;


public class C {

	int filed1;
	
	public C() {
		A a = new A();
		a.field1 = 10;
//		a.filed2 = 10;
		
		a.method1();
//		a.method2();
//		D d = new D();
		
	}
	
}
