package basic;

public class A {
	
	A(){
		System.out.println("A 객체 생성");
	}
	
	// 인스턴스 멤버 클래스
	public class B{
		B(){
			System.out.println("B 객체 생성");
		}
		
		int field1;
		//static field2;
		void method() {
			System.out.println("B method");
		}
		//static method2(){}
	}
	
	// 정적 멤버 클래스
	static class C{
		C(){
			System.out.println("객체 생성");
		}
		int field1;
		static int field2;
		void method1() {
			System.out.println("C method1");
		}
		static void method2() {
			System.out.println("C method2");
		}
	}
	
	//A의 method
	void method() {
		//local class
		class D{
			
			D(){
				System.out.println("D 객체 생성됨");
			}
			
			int field1;
			// static int field2;
			void method1() { System.out.println("D의 method1"); }
		}
			// static void method(){};			
			D d = new D();
			d.field1 = 3;
			d.method1();
			
				
		
	}

}
