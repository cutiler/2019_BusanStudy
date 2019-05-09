package net.koreate.www.extends1.protected2;

import net.koreate.www.extends1.protected1.A;

public class D extends A{

	A a = new A();
	
	public D() {
		// 생성된 인스턴스에서만 접근가능
		super.number = 100;
		// 생성된 객체에서는 접근 불가능
		//a.number = 10;
	}
	
}
