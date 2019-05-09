package access;

public class A {
	
	interface F{
		void setValue();
	}
	
	F f;
	

	B field = new B();
	C field2 = new C();
	
	//static B field3 = new B();
	static C field4 = new C();
	
	void method1() {
		f = new F() {
			@Override
			public void setValue() {}
		};
		
		B b = new B();
		C c = new C();
	}
	
	static void method2() {
		//B b = new B();
		C c = new C();
	}
	
	int val1;
	void method() {}
	
	static int val2;
	static void methods() {}
	
	class B{
		void method() {
			val1 = 10;
			method();
			val2 = 100;
			methods();
		}
		
	}
	
	static class C{
		void method() {			
			//val1 =100;
			//method();
			val2 = 100;
			methods();
		}
		
	}
	
	
}
